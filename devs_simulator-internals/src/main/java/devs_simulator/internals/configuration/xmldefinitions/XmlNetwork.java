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

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
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
	@XmlElementWrapper(name = "inputs")
	@XmlElement(name = "connectionPoint")
	private List<XmlConnectionPoint> inputConnections;
	
	/** list of output connections */
	@XmlElementWrapper(name = "outputs")
	@XmlElement(name = "connectionPoint")
	private List<XmlConnectionPoint> outputConnections;
	
	/** list of processors in this network */
	@XmlElementWrapper(name = "processors")
	@XmlElement(name = "processor")
	private List<XmlProcessor> processors;
	
	/** list of subnetworks in this network */
	@XmlElementWrapper(name = "networks")
	@XmlElement(name = "network")
	private List<XmlNetwork> networks;
	
	/** list of wire connection  in this network */
	@XmlElementWrapper(name = "connections")
	@XmlElement(name = "wire")
	private List<XmlWire> connections;
	
	/**
	 * 
	 */
	public XmlNetwork() {
		inputConnections = new ArrayList<>();
		outputConnections = new ArrayList<>();
		networks = new ArrayList<>();
		processors = new ArrayList<>();
		connections = new ArrayList<>();
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

	/**
	 * get an instance-able instance (network, processor, connection point) defined by id.
	 * @param id of the instance (unique in this network instance).
	 * @return the instance.
	 */
	public XmlInstantiable getInstanceById(final String id) {
		//find the id in networks
		for (XmlNetwork net : networks) {
			if (id.equals(net.getInstanceId())) {
				return net;
			}
		}
		//find in processors
		for (XmlProcessor proc : processors) {
			if (id.equals(proc.getInstanceId())) {
				return proc;
			}
		}
		//find in input connection points
		for (XmlConnectionPoint conn : inputConnections) {
			if (id.equals(conn.getInstanceId())) {
				return conn;
			}
		}
		//find in output connection points
		for (XmlConnectionPoint conn : outputConnections) {
			if (id.equals(conn.getInstanceId())) {
				return conn;
			}
		}
		return null;
	}
	
	/**
	 * get an connection point defined by position.
	 * @param position of the instance (unique in this network instance as input/output connection point).
	 * @return the instance.	 */
	public XmlInstantiable getInstanceByPosition(final String position) {
		// find in input connection points
		for (XmlConnectionPoint conn : inputConnections) {
			if (position.equals(conn.getPosition())) {
				return conn;
			}
		}
		// find in output connection points
		for (XmlConnectionPoint conn : outputConnections) {
			if (position.equals(conn.getPosition())) {
				return conn;
			}
		}
		return null;
	}
}
