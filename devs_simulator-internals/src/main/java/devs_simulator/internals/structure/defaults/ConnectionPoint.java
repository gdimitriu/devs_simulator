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

import devs_simulator.internals.structure.interfaces.IClock;
import devs_simulator.internals.structure.interfaces.IConnectableInstance;
import devs_simulator.internals.structure.interfaces.IConnectionPoint;
import devs_simulator.internals.structure.interfaces.IRunningInstance;

/**
 * Default (Abstract) implementation for the connection point.
 * @author Gabriel Dimitriu
 *
 */
public class ConnectionPoint extends BaseStructureInstanceable implements IRunningInstance, IConnectionPoint {

	/** the position inside network or processor */
	private String position ="0";
	
	/** the owner of this connection point. */
	private IConnectableInstance owner = null;
	/**
	 * 
	 */
	public ConnectionPoint() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * base instance-able constructor.
	 * @param id 
	 * @param type
	 */
	public ConnectionPoint(final String id, final String type, final String position) {
		super(id,type);
		this.position = position; 
	}

	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(final String position) {
		this.position = position;
	}
	
	@Override
	public void run(final IClock clock) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IConnectableInstance getOwner() {
		return owner;
	}

	@Override
	public void setOwner(final IConnectableInstance owner) {
		this.owner = owner;
	}
}
