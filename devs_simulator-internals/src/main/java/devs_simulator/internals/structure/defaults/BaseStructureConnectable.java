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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import devs_simulator.internals.structure.interfaces.IBaseConnectableType;

/**
 * Default (Abstract) implementation for BaseConnectable Type.
 * This should be inherited by all connect-able instances.
 * @author Gabriel Dimitriu
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class BaseStructureConnectable implements IBaseConnectableType{

	/** the internal unique id of the instance */
	@XmlElement(name = "instanceId")
	private String instanceId;
	
	/** the type name of the instance */
	@XmlElement(name = "instanceType")
	private String instanceType;
	
	/**
	 * 
	 */
	public BaseStructureConnectable() {
		// TODO Auto-generated constructor stub
	}
	
	/* (non-Javadoc)
	 * @see devs_simulator.internals.structure.interfaces.IBaseConnectableType#setInstanceId(java.lang.String)
	 */
	@Override
	public void setInstanceId(final String id) {
		instanceId = id;
	}

	/* (non-Javadoc)
	 * @see devs_simulator.internals.structure.interfaces.IBaseConnectableType#getInstanceId()
	 */
	@Override
	public String getInstanceId() {
		return instanceId;
	}
	
	/* (non-Javadoc)
	 * @see devs_simulator.internals.structure.interfaces.IBaseConnectableType#setInstanceType(java.lang.String)
	 */
	@Override
	public void setInstanceType(final String type) {
		instanceType = type;
	}
	
	/* (non-Javadoc)
	 * @see devs_simulator.internals.structure.interfaces.IBaseConnectableType#getInstanceType()
	 */
	@Override
	public String getInstanceType() {
		return instanceType;
	}
}
