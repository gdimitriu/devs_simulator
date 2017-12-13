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
 * This is the base for all connect-able or connection instance.
 * This is the base interface for Connect-able instance (like processors and networks).
 * This is the base interface for connection instance (IConnectionPoint).
 * @author Gabriel Dimitriu
 *
 */
public interface IBaseConnectableType {

	/**
	 * get the instance id which is unique.
	 * @return unique id of the instance 
	 */
	String getInstanceID();
	
	/**
	 * set the instance id which is unique. 
	 * @param id the unique id of the instance
	 */
	void setInstanceID(final String id);
	
	/**
	 * get the type name of the instance.
	 * @return the type name of the instance (not unique)
	 */
	String getInstanceType();

	/**
	 * set the type name of the instance.
	 * @param type the type name of the instance (not unique).
	 */
	void setIntanceType(final String type);
}
