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

import devs_simulator.internals.structure.interfaces.IClock;
import devs_simulator.internals.structure.interfaces.IConnectionPoint;
import devs_simulator.internals.structure.interfaces.IWire;

/**
 * Default implementation for wire connection.
 * This could be also:
 * 	-bus
 *  -transmission line
 *  -MUX/DMUX
 * @author Gabriel Dimitriu
 *
 */
public class Wire implements IWire {
	
	/** list of input connections */
	private List<IConnectionPoint> inputConnections;
	
	/** list of output connections */
	private List<IConnectionPoint> outputConnections;

	/**
	 * 
	 */
	public Wire() {
		inputConnections = new ArrayList<>();
		outputConnections = new ArrayList<>();
	}

	/* (non-Javadoc)
	 * @see devs_simulator.internals.structure.interfaces.IRunningInstance#run(devs_simulator.internals.structure.interfaces.IClock)
	 */
	@Override
	public void run(IClock clock) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see devs_simulator.internals.structure.interfaces.IWire#getInputConnectionPoints()
	 */
	@Override
	public List<IConnectionPoint> getInputConnectionPoints() {
		return inputConnections;
	}

	/* (non-Javadoc)
	 * @see devs_simulator.internals.structure.interfaces.IWire#getOutputConnectionPoints()
	 */
	@Override
	public List<IConnectionPoint> getOutputConnectionPoints() {
		return outputConnections;
	}

	@Override
	public void addInputConnectionPoint(final IConnectionPoint connection) {
		inputConnections.add(connection);
	}

	@Override
	public void addOutputConnectionPoint(final IConnectionPoint connection) {
		outputConnections.add(connection);
	}

}
