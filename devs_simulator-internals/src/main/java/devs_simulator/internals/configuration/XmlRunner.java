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

import devs_simulator.internals.configuration.xmldefinitions.XmlExternalSource;
import devs_simulator.internals.configuration.xmldefinitions.XmlSamplingDevice;
import devs_simulator.internals.configuration.xmldefinitions.XmlWire;

/**
 * Class for marshall/unmarshall the runner into xml configuration file.
 * @author Gabriel Dimitriu
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "runner")
public class XmlRunner {
	
	/** list of external sources */
	@XmlElementWrapper(name = "ExternalSources")
	@XmlElement(name = "ExternalSource")
	private List<XmlExternalSource> externalSources;
	
	/** list of sampling devices */
	@XmlElementWrapper(name = "SamplingDevices")
	@XmlElement(name = "SamplingDevice")
	private List<XmlSamplingDevice> samplingDevices;
	
	/** list of wire connection in top level. */
	@XmlElementWrapper(name = "connections")
	@XmlElement(name = "wire")
	private List<XmlWire> connections;
	/**
	 * 
	 */
	public XmlRunner() {
		
	}
	/**
	 * @return the externalSources
	 */
	public List<XmlExternalSource> getExternalSources() {
		return externalSources;
	}
	/**
	 * @param externalSources the externalSources to set
	 */
	public void setExternalSources(final List<XmlExternalSource> externalSources) {
		this.externalSources = externalSources;
	}
	/**
	 * @return the samplingDevices
	 */
	public List<XmlSamplingDevice> getSamplingDevices() {
		return samplingDevices;
	}
	/**
	 * @param samplingDevices the samplingDevices to set
	 */
	public void setSamplingDevices(final List<XmlSamplingDevice> samplingDevices) {
		this.samplingDevices = samplingDevices;
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
