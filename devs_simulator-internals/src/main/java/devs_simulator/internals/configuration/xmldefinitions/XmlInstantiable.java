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
package devs_simulator.internals.configuration.xmldefinitions;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Base class for instantiable into xml configuration file.
 * @author Gabriel Dimitriu
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlTransient
public class XmlInstantiable {

	/** instanceId unique name inside another instance of network*/
	/** The top level network must have an instanceId. */
	@XmlElement(name = "instanceId", required = false)
	private String instanceId;
	
	/** instance type the defined type of this instance */
	@XmlElement(name = "instanceType", required = true)
	private String instanceType;
	
	/**
	 * 
	 */
	public XmlInstantiable() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the instanceId
	 */
	public String getInstanceId() {
		return instanceId;
	}

	/**
	 * @param instanceId the instanceId to set
	 */
	public void setInstanceId(final String instanceId) {
		this.instanceId = instanceId;
	}

	/**
	 * @return the instanceType
	 */
	public String getInstanceType() {
		return instanceType;
	}

	/**
	 * @param instanceType the instanceType to set
	 */
	public void setInstanceType(final String instanceType) {
		this.instanceType = instanceType;
	}

}
