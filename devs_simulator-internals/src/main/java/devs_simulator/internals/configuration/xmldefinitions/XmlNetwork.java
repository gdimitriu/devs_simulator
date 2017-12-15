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
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class for marshall/unmarshall network into xml configuration file.
 * @author Gabriel Dimitriu
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "network")
public class XmlNetwork extends XmlInstantiable {

	/** list of input connections */
	@XmlElement(name = "inputs")
	private List<XmlConnectionPoint> inputConnections;
	
	/** list of output connections */
	@XmlElement(name = "outputs")
	private List<XmlConnectionPoint> outputConnections;
	
	/** list of processors in this network */
	@XmlElement(name = "processors")
	private List<XmlProcessor> processors;
	
	/** list of subnetworks in this network */
	@XmlElement(name = "networks")
	private List<XmlNetwork> networks;
	
	/** list of wire connection  in this network */ 
	@XmlElement(name = "connections")
	private List<XmlWire> connections;
	
	/**
	 * 
	 */
	public XmlNetwork() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the inputConnections
	 */
	public List<XmlConnectionPoint> getInputConnections() {
		return inputConnections;
	}

	/**
	 * @param inputConnections the inputConnections to set
	 */
	public void setInputConnections(final List<XmlConnectionPoint> inputConnections) {
		this.inputConnections = inputConnections;
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

	/**
	 * @return the processors
	 */
	public List<XmlProcessor> getProcessors() {
		return processors;
	}

	/**
	 * @param processors the processors to set
	 */
	public void setProcessors(final List<XmlProcessor> processors) {
		this.processors = processors;
	}

	/**
	 * @return the networks
	 */
	public List<XmlNetwork> getNetworks() {
		return networks;
	}

	/**
	 * @param networks the networks to set
	 */
	public void setNetworks(final List<XmlNetwork> networks) {
		this.networks = networks;
	}

	/**
	 * @return the connections
	 */
	public List<XmlWire> getConnections() {
		return connections;
	}

	/**
	 * @param connections the connections to set
	 */
	public void setConnections(final List<XmlWire> connections) {
		this.connections = connections;
	}

}
