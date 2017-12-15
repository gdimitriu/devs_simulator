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

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class for marshall/unmarshall an external source into xml configuration file.
 * @author Gabriel Dimitriu
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ExternalSource")
public class XmExternalSource extends XmlInstantiable {

	/** list of output connections */
	@XmlElementWrapper(name = "outputs")
	@XmlElement(name = "connectionPoint", required = true)
	private List<XmlConnectionPoint> outputConnections;
	
	/**
	 * 
	 */
	public XmExternalSource() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the outputConnections
	 */
	public List<XmlConnectionPoint> getOutputConnections() {
		return outputConnections;
	}

	/**
	 * @param outputConnections the outputConnections to set
	 */
	public void setOutputConnections(final List<XmlConnectionPoint> outputConnections) {
		this.outputConnections = outputConnections;
	}

}
