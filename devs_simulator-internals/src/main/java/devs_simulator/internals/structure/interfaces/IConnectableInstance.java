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

import java.util.List;

/**
 * Interface for the connect-able instances.
 * @author Gabriel Dimitriu
 *
 */
public interface IConnectableInstance extends IBaseConnectableType {

	/**
	 * get the list of input connection points (pad)
	 * @return list of pads
	 */
	List<IConnectionPoint> getInputConnectionPoints();
	
	/**
	 * get the list of output connection points (pad)
	 * @return list of pads
	 */
	List<IConnectionPoint> getOutputConnectionPoints();
	
	/**
	 * get the list of the connection points of a specific type.
	 * There could be more connection point of same type (if is a bus). 
	 * @param type of the connection point (name)
	 * @return list of the connection point.
	 */
	List<IConnectionPoint> getConnectionPointByType(final String type);
	
	/**
	 * get the connection point specified by the position.
	 * @param position
	 * @return
	 */
	IConnectionPoint getConnectionPointByPosition(final int position);
	
	/**
	 * get a specific connection point.
	 * There is only one connection point specified by the unique ID.
	 * @param id of the connection.
	 * @return connection point.
	 */
	IConnectionPoint getConnectionPointByID(final String id);
	
	/**
	 * add a connection point by type.
	 * The position will be increased automatically if there is no gap. 
	 * If the connection point has specified the position,
	 * the pad will be put at that position.
	 * @param pad the connection point.
	 */
	void addConnectionPoint(final IConnectionPoint pad);
	
	/**
	 * add a connection point by type and position.
	 * @param position of the connection point
	 * @param pad the connection point
	 */
	void addConnectionPoint(final int position, final IConnectionPoint pad);
	
	/**
	 * set a connection point by type and position.
	 * It will replace the connection point specified by the position and type.
	 * @param position of the connection point
	 * @param pad the connection point
	 */
	void setConnectionPoint(final int position, final IConnectionPoint pad);
}
