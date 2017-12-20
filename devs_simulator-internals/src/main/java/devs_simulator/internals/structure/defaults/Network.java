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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import devs_simulator.internals.structure.interfaces.IBaseInstantiableType;
import devs_simulator.internals.structure.interfaces.IClock;
import devs_simulator.internals.structure.interfaces.IConnectableInstance;
import devs_simulator.internals.structure.interfaces.INetwork;
import devs_simulator.internals.structure.interfaces.IProcessor;
import devs_simulator.internals.structure.interfaces.IWire;

/**
 * Default (Abstract) implementation for the network.
 * @author Gabriel Dimitriu
 *
 */
public class Network extends BaseStructureConnectable implements INetwork {

	/** map of processing units by id */
	private Map<String, IProcessor> processorUnits = null;
	
	/** map of the subnetwork units by id */
	private Map<String, INetwork> networkUnits = null;
	
	/** list of connections in this network */
	private List<IWire> connections = null;
	
	/**
	 * 
	 */
	public Network() {
		connections = new ArrayList<>();
		processorUnits = new HashMap<>();
		networkUnits = new HashMap<>();
	}
	
	/**
	 * base constructor for network.
	 * @param instanceId the instance id
	 * @param instanceType the type of the instance
	 */
	public Network(final String instanceId, final String instanceType) {
		super(instanceId, instanceType);
		connections = new ArrayList<>();
		processorUnits = new HashMap<>();
		networkUnits = new HashMap<>();
	}

	@Override
	public void addConnectable(final IConnectableInstance instance) throws Exception {
		if (!(instance instanceof IBaseInstantiableType)) {
			throw new Exception("The instance is not instanceable");
		}
		if (instance instanceof IProcessor) {
			processorUnits.put(((IProcessor) instance).getInstanceId(), (IProcessor) instance);
			((IProcessor) instance).setParent(this);
		} else if (instance instanceof INetwork) {
			networkUnits.put(((INetwork) instance).getInstanceId(), (INetwork) instance);
			((INetwork) instance).setParent(this);
		}
		throw new Exception("could not add "  + ((IBaseInstantiableType) instance).getInstanceId() + " to the " + getInstanceId());
	}
	
	@Override
	public void addProcessor(final Processor instance) {
		processorUnits.put(instance.getInstanceId(), instance);
		instance.setParent(this);
	}
	
	@Override
	public void addNetwork(final Network instance) {
		networkUnits.put(instance.getInstanceId(), instance);
		instance.setParent(this);
	}

	@Override
	public void run(final IClock clock) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<IProcessor> getProcessors() {
		List<IProcessor> procs = new ArrayList<>();
		for(Entry<String, IProcessor> entry : processorUnits.entrySet()) {
			procs.add(entry.getValue());
		}
		return procs;
	}

	@Override
	public List<INetwork> getNetworks() {
		List<INetwork> networks = new ArrayList<>();
		for(Entry<String, INetwork> entry : networkUnits.entrySet()) {
			networks.add(entry.getValue());
		}
		return networks;
	}

	@Override
	public void addWire(final IWire wire) {
		connections.add(wire);
	}

	@Override
	public IWire addWire(final String inputID, final String outputID) {
		// TODO Auto-generated method stub
		return null;
	}
}