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
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import devs_simulator.internals.configuration.xmldefinitions.XmlInstantiable;
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
	@XmlElementWrapper(name = "processors")
	@XmlElement(name = "processor")
	private List<XmlProcessor> processorDefs;
	
	/** list of definitions of networks */
	@XmlElementWrapper(name = "networks")
	@XmlElement(name = "network")
	private List<XmlNetwork> networkDefs;
	
	/**
	 * 
	 */
	public XmlDefinitions() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the processorDefs
	 */
	public List<XmlProcessor> getProcessorDefs() {
		return processorDefs;
	}

	/**
	 * @param processorDefs the processorDefs to set
	 */
	public void setProcessorDefs(final List<XmlProcessor> processorDefs) {
		this.processorDefs = processorDefs;
	}

	/**
	 * @return the networkDefs
	 */
	public List<XmlNetwork> getNetworkDefs() {
		return networkDefs;
	}

	/**
	 * @param networkDefs the networkDefs to set
	 */
	public void setNetworkDefs(final List<XmlNetwork> networkDefs) {
		this.networkDefs = networkDefs;
	}

	/**
	 * get a network specified by type.
	 * @param type
	 * @return the network definition.
	 */
	public XmlNetwork getNetworkDefByType(final String type) {
		for (XmlNetwork net : networkDefs) {
			if (type.equals(net.getInstanceType())) {
				return net;
			}
		}
		return null;
	}
	
	/**
	 * get the processor specified by type.
	 * @param type
	 * @return the processor definition.
	 */
	public XmlProcessor getProcessorDefByType(final String type) {
		for (XmlProcessor proc : processorDefs) {
			if (type.equals(proc.getInstanceType())) {
				return proc;
			}
		}
		return null;
	}
	
	/**
	 * get the network with a specific ID (this is used by the runner to get the top level network).
	 * In definition only the top level network should have an Id.
	 * @param id from the runner configuration.
	 * @return the network from runner.
	 */
	public XmlNetwork getNetworkById(final String id) {
		for (XmlNetwork net : networkDefs) {
			if (id.equals(net.getInstanceId())) {
				return net;
			}
		}
		return null;
	}

	/**
	 * get the instance by type (network, processor, connection point).
	 * @param type of instance
	 * @return defined instance
	 */
	public XmlInstantiable getInstanceDefByType(final String type) {
		for (XmlProcessor proc : processorDefs) {
			if (type.equals(proc.getInstanceType())) {
				return proc;
			}
		}
		for (XmlNetwork net : networkDefs) {
			if (type.equals(net.getInstanceType())) {
				return net;
			}
		}
		return null;
	}
}
