/**
    Copyright (c) 2017 Gabriel Dimitriu All rights reserved.
	DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.

    This file is part of devs_simulator project.

    devs_simulator is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    devs_simulator is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with devs_simulator.  If not, see <http://www.gnu.org/licenses/>.
 */
package devs_simulator.internals.structure.factory;

import java.util.List;

import devs_simulator.internals.configuration.XmlDefinitions;
import devs_simulator.internals.configuration.xmldefinitions.XmlConnectionPoint;
import devs_simulator.internals.configuration.xmldefinitions.XmlNetwork;
import devs_simulator.internals.configuration.xmldefinitions.XmlProcessor;
import devs_simulator.internals.structure.defaults.ConnectionPoint;
import devs_simulator.internals.structure.defaults.Network;

/**
 * Factory for network instance.
 * @author Gabriel Dimitriu
 *
 */
public class NetworkFactory {

	/** definitions holder */
	private XmlDefinitions definitions = null;
	
	/** processor factory for this network */
	private ProcessorFactory procFactory = null;
	
	/**
	 * @param def the xml definitions of the common elements.
	 */
	public NetworkFactory(final XmlDefinitions def) {
		this.definitions = def;
		procFactory = new ProcessorFactory(def);
	}

	/**
	 * Create the Network from the xml definition.
	 * @param xmlNetworkDef the definition of the Network.
	 * @return the processor as internal structure instance
	 */
	public Network createNetwork(final XmlNetwork xmlNetworkDef) {
		
		XmlNetwork realDef = xmlNetworkDef;
		//the processor is referenced from a definition.
		if (xmlNetworkDef.getType() != null && !xmlNetworkDef.getType().isEmpty()) {
			realDef = definitions.getNetworkDefByType(xmlNetworkDef.getType());
		}
		final Network network = new Network(xmlNetworkDef.getInstanceId(), realDef.getInstanceType());
		List<XmlConnectionPoint> pads = realDef.getInputConnections();
		pads.stream().forEach(pad -> network.addInputConnectionPoint(new ConnectionPoint(pad.getInstanceId(), pad.getInstanceType(), pad.getPosition(), pad.getSize())));
		pads = realDef.getOutputConnections();
		pads.stream().forEach(pad -> network.addOutputConnectionPoint(new ConnectionPoint(pad.getInstanceId(), pad.getInstanceType(), pad.getPosition(), pad.getSize())));
		List<XmlProcessor> xmlProcs = realDef.getProcessors();
		if (!xmlProcs.isEmpty()) {
			xmlProcs.stream().forEach(xmlProc -> network.addProcessor((procFactory.createProcessor(xmlProc))));
		}
		return network;
	}

}
