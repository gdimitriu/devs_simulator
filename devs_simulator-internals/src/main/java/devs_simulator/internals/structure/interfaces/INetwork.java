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
 * Interface for network (high level processing unit of DEVS) instances.
 * @author Gabriel Dimitriu
 *
 */
public interface INetwork extends IConnectableInstance, IRunningInstance {

	/**
	 *  add a connect-able instance to the network.
	 *  The instance could be a network or a processor
	 *  or something that implement the IConnectableInstance interface.
	 *  @param instance the instance to be added.
	 */
	void addConnectable(final IConnectableInstance instance);
	
	/**
	 * get the list of processors from this network.
	 * @return list of processors from this network.
	 */
	List<IConnectableInstance> getProcessors();
	
	/**
	 * get the list of subnetworks from this network. 
	 * @return list of networks from this network.
	 */
	List<IConnectableInstance> getNetworks();
	
	/**
	 * add an already defined wire.
	 * @param wire defined.
	 */
	void addWire(final IWire wire);
	
	/**
	 * add a wire between two connection points.
	 * @param inputID the ID of the input connection point.
	 * @param outputID the ID of the output connection point.
	 * @return the added wire.
	 */
	IWire addWire(final String inputID, final String outputID);
}
