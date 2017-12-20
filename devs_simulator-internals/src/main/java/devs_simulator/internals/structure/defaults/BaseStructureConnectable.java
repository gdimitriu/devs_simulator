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
import devs_simulator.internals.structure.interfaces.IConnectableInstance;
import devs_simulator.internals.structure.interfaces.IConnectionPoint;

/**
 * Default (Abstract) implementation for BaseConnectable and instance-able Type.
 * This should be inherited by all connect-able instances
 * @author Gabriel Dimitriu
 *
 */
public class BaseStructureConnectable extends BaseStructureInstanceable implements IConnectableInstance{
	
	/** input hash map key is position and value is the connection point */
	private Map<String, IConnectionPoint> inputConnections = new HashMap<>();
	
	/** output hash map key is position and value is the connection point */
	private Map<String, IConnectionPoint> outputConnections = new HashMap<>();
	
	/**
	 * 
	 */
	public BaseStructureConnectable() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * base constructor.
	 * @param id of instance.
	 * @param type of instance.
	 */
	public BaseStructureConnectable(final String id, final String type) {
		super(id, type);
	}

	@Override
	public List<IConnectionPoint> getInputConnectionPoints() {
		List<IConnectionPoint> connections = new ArrayList<>();
		for(Entry<String, IConnectionPoint> entry : inputConnections.entrySet()) {
			connections.add(entry.getValue());
		}
		return connections;
	}

	@Override
	public List<IConnectionPoint> getOutputConnectionPoints() {
		List<IConnectionPoint> connections = new ArrayList<>();
		for(Entry<String, IConnectionPoint> entry : outputConnections.entrySet()) {
			connections.add(entry.getValue());
		}
		return connections;
	}

	@Override
	public void addInputConnectionPoint(final IConnectionPoint pad) {
		pad.setOwner(this);		
		inputConnections.put(pad.getPosition(), pad);
	}
	
	@Override
	public void addOutputConnectionPoint(IConnectionPoint pad) {
		pad.setOwner(this);		
		outputConnections.put(pad.getPosition(), pad);
	}

	@Override
	public IConnectionPoint getConnectionPointByPosition(final String position) throws Exception {
		if (inputConnections.containsKey(position)) {
			return inputConnections.get(position);
		}
		if (outputConnections.containsKey(position)) {
			return outputConnections.get(position);
		}
		throw new Exception("position=" + position);
	}
}
