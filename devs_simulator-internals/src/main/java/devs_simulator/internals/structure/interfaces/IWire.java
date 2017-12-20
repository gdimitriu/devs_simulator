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
 * Interface for connection between two connect-able instances.
 * @author Gabriel Dimitriu
 *
 */
public interface IWire extends IRunningInstance {
	
	/**
	 * get the input connection points.
	 * @return list of input connection points.
	 */
	List<IConnectionPoint> getInputConnectionPoints();
	
	/** 
	 * get the output connection points.
	 * @return list of output connection points.
	 */
	List<IConnectionPoint> getOutputConnectionPoints();
	
	/**
	 * Add an input connection point as last connection.
	 * @param connection the connection to be added.
	 */
	void addInputConnectionPoint(final IConnectionPoint connection);
	
	/**
	 * Add an output connection point as last connection.
	 * @param connection the connection to be added.
	 */
	void addOutputConnectionPoint(final IConnectionPoint connection);
}
