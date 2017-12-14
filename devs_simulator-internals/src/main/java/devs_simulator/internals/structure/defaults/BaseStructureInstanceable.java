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

import devs_simulator.internals.structure.interfaces.IBaseInstantiableType;

/**
 * Default (Abstract) implementation for BaseInstanceable Type.
 * This should be inherited by all instance-able instances.
 * @author Gabriel Dimitriu
 *
 */
public abstract class BaseStructureInstanceable implements IBaseInstantiableType{

	/** the internal unique id of the instance */
	private String instanceId;
	
	/** the type name of the instance */
	private String instanceType;
	
	/**
	 * 
	 */
	public BaseStructureInstanceable() {
		// TODO Auto-generated constructor stub
	}
	
	/* (non-Javadoc)
	 * @see devs_simulator.internals.structure.interfaces.IBaseInstantiableType#setInstanceId(java.lang.String)
	 */
	@Override
	public void setInstanceId(final String id) {
		instanceId = id;
	}

	/* (non-Javadoc)
	 * @see devs_simulator.internals.structure.interfaces.IBaseInstantiableType#getInstanceId()
	 */
	@Override
	public String getInstanceId() {
		return instanceId;
	}
	
	/* (non-Javadoc)
	 * @see devs_simulator.internals.structure.interfaces.IBaseInstantiableType#setInstanceType(java.lang.String)
	 */
	@Override
	public void setInstanceType(final String type) {
		instanceType = type;
	}
	
	/* (non-Javadoc)
	 * @see devs_simulator.internals.structure.interfaces.IBaseInstantiableType#getInstanceType()
	 */
	@Override
	public String getInstanceType() {
		return instanceType;
	}
}
