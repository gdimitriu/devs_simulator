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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class for marshall/unmarshall the root part of the devs_simulator configuration.
 * @author Gabriel Dimitriu
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "devs_simulator")
public class XmlDevsSimulator {
	
	/** runner for devs simulator */
	@XmlElement(name = "runner")
	private XmlRunner runner;
	
	/** definitions of elements */
	@XmlElement(name = "definitions")
	private XmlDefinitions definitions;
	
	/**
	 * 
	 */
	public XmlDevsSimulator() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the runner
	 */
	public XmlRunner getRunner() {
		return runner;
	}

	/**
	 * @param runner the runner to set
	 */
	public void setRunner(final XmlRunner runner) {
		this.runner = runner;
	}

	/**
	 * @return the definitions
	 */
	public XmlDefinitions getDefinitions() {
		return definitions;
	}

	/**
	 * @param definitions the definitions to set
	 */
	public void setDefinitions(final XmlDefinitions definitions) {
		this.definitions = definitions;
	}

}
