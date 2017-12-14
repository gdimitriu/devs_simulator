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
package devs_simulator.internals.configuration;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import devs_simulator.internals.configuration.xmldefinitions.XmlNetwork;
import devs_simulator.internals.configuration.xmldefinitions.XmlProcessor;

/**
 * Class for marshall/unmarshall the definitions of processors and networks into xml configuration file.
 * @author Gabriel Dimitriu
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "definitions")
public class XmlDefinitions {

	/** list of definitions of processors */
	@XmlElement(name = "processors")
	private List<XmlProcessor> processorDefs;
	
	/** list of definitions of networks */
	@XmlElement(name = "networks")
	private List<XmlNetwork> networkDefs;
	
	/**
	 * 
	 */
	public XmlDefinitions() {
		// TODO Auto-generated constructor stub
	}

}
