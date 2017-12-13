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
package devs_simulator.internals.structure.defaults;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import devs_simulator.internals.structure.interfaces.IConnectableInstance;
import devs_simulator.internals.structure.interfaces.INetwork;
import devs_simulator.internals.structure.interfaces.IProcessor;

/**
 * Default (Abstract) implementation for the network.
 * @author Gabriel Dimitriu
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Network extends BaseStructureConnectable implements INetwork {

	/** list of the processors id and type which are in this instance */
	@XmlElement(name = "processors")
	private List<InstanceHolder> processors;
	
	/** list of the networks id which are in this instance */
	@XmlElement(name = "networks")
	private List<InstanceHolder> networks;
	
	@XmlElement(name = "inputIds")
	private List<String> inputIds;
	
	@XmlElement(name = "outputIds")
	private List<String> outputIds;
	
	/*------------------------------------------------------------
	 * Internal storage which will not be part of xml description.
	 *----------------------------------------------------------*/
	/** map of processing units by id */
	@XmlTransient
	private Map<String, IProcessor> processorUnits = null;
	
	/** map of the subnetwork units by id */
	@XmlTransient
	private Map<String, INetwork> networkUnits = null;
	
	/**
	 * 
	 */
	public Network() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<IConnectableInstance> getProcessors() {
		List<IConnectableInstance> returnData = new ArrayList<>();
		for (InstanceHolder instance : processors) {
			returnData.add(processorUnits.get(instance.getId()));
		}
		return returnData;
	}
	
	@Override
	public List<IConnectableInstance> getNetworks() {
		List<IConnectableInstance> returnData = new ArrayList<>();
		for (InstanceHolder instance : networks) {
			returnData.add(networkUnits.get(instance.getId()));
		}
		return returnData;
	}
}