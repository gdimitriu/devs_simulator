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
package devs_simulator.internals.structure.interfaces;

/**
 * Interface for the connection point instance.
 * The connect-able instance could be network, processor of external source. 
 * @author Gabriel Dimitriu
 *
 */
public interface IConnectionPoint extends IBaseConnectableType {

	/**
	 * Get the owner of this connection point(IConnectableInstance).
	 * @return owner of this pad.
	 */
	IConnectableInstance getOwner();
	
	/**
	 * Set the owner of this connection point.
	 * @param owner the the pad.
	 */
	void setOwner(final IConnectableInstance owner);
	
	/**
	 * set the position inside the connect-able instance. 
	 * @param position of the connection point.
	 */
	void setPosition(final int position);
	
	/**
	 * get the position inside the connect-able instance.
	 * @return the position of the connection point.
	 */
	int getPosition();
	
	/**
	 * set the size of the bus.
	 * the default is 1 (single wire).
	 * The buses should override the setter. 
	 * @param size of the bus.
	 */
	default void setSize(final int size) {
		
	}
	
	/**
	 * get the size of the bus.
	 * the default is 1 (single byte wire).
	 * The buses should override the getter.
	 * @return the size of the bus.
	 */
	default int getSize() {
		return 1;
	}
}
