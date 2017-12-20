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
import devs_simulator.internals.configuration.xmldefinitions.XmlProcessor;
import devs_simulator.internals.structure.defaults.ConnectionPoint;
import devs_simulator.internals.structure.defaults.Processor;

/**
 * Factory for processor instance.
 * @author Gabriel Dimitriu
 *
 */
public class ProcessorFactory {

	/** definitions holder */
	private XmlDefinitions definitions = null;
	
	/**
	 * @param def the xml definitions of the common elements.
	 */
	public ProcessorFactory(final XmlDefinitions def) {
		this.definitions = def;
	}

	/**
	 * Create the processor from the xml definition.
	 * @param xmlProcDef the definition of the processor.
	 * @return the processor as internal structure instance
	 */
	public Processor createProcessor(final XmlProcessor xmlProcDef) {
		
		XmlProcessor realDef = xmlProcDef;
		//the processor is referenced from a definition.
		if (xmlProcDef.getType() != null && !xmlProcDef.getType().isEmpty()) {
			realDef = definitions.getProcessorDefByType(xmlProcDef.getType());
		}
		final Processor proc = new Processor(xmlProcDef.getInstanceId(), realDef.getInstanceType());
		List<XmlConnectionPoint> pads = realDef.getInputConnections();
		pads.stream().forEach(pad -> proc.addInputConnectionPoint(new ConnectionPoint(pad.getInstanceId(), pad.getInstanceType(), pad.getPosition(), pad.getSize())));
		pads = realDef.getOutputConnections();
		pads.stream().forEach(pad -> proc.addOutputConnectionPoint(new ConnectionPoint(pad.getInstanceId(), pad.getInstanceType(), pad.getPosition(), pad.getSize())));
		
		return proc;
	}
}
