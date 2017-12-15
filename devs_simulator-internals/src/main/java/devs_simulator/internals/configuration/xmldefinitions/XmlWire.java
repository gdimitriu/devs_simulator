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
 * Class for marshall/unmarshall a wire connection into xml configuration file.
 * @author Gabriel Dimitriu
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "wire")
public class XmlWire {

	/** list of input connection points */
	@XmlElementWrapper(name = "inputs")
	@XmlElement(name = "connection")
	private List<XmlConnection> inputs;
	
	/** list of output connection points */
	@XmlElementWrapper(name = "outputs")
	@XmlElement(name = "connection")
	private List<XmlConnection> outputs;
	
	/**
	 * 
	 */
	public XmlWire() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the inputs
	 */
	public List<XmlConnection> getInputs() {
		return inputs;
	}

	/**
	 * @param inputs the inputs to set
	 */
	public void setInputs(final List<XmlConnection> inputs) {
		this.inputs = inputs;
	}

	/**
	 * @return the outputs
	 */
	public List<XmlConnection> getOutputs() {
		return outputs;
	}

	/**
	 * @param outputs the outputs to set
	 */
	public void setOutputs(final List<XmlConnection> outputs) {
		this.outputs = outputs;
	}

}
