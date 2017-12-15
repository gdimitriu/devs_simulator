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
package devs_simulator.tests.configuration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

import devs_simulator.internals.configuration.XmlDefinitions;
import devs_simulator.internals.configuration.XmlDevsSimulator;
import devs_simulator.internals.configuration.XmlRunner;
import devs_simulator.internals.configuration.xmldefinitions.XmlExternalSource;
import devs_simulator.internals.configuration.xmldefinitions.XmlConnectionPoint;
import devs_simulator.internals.configuration.xmldefinitions.XmlNetwork;
import devs_simulator.internals.configuration.xmldefinitions.XmlSamplingDevice;
import devs_simulator.internals.configuration.xmldefinitions.XmlWire;

/**
 * @author Gabriel Dimitriu
 *
 */
public class ConfigurationLoadTest {

	/**
	 * 
	 */
	public ConfigurationLoadTest() {
		// TODO Auto-generated constructor stub
	}

	@Test
	public void loadDefinitions() {
		JAXBContext context = null;
		try {
			context = JAXBContext.newInstance(XmlDevsSimulator.class);
		} catch (JAXBException e) {
			fail("failed to create context : " + e.getLocalizedMessage());
		}
		Unmarshaller unmarshaller = null;
		try {
			unmarshaller = context.createUnmarshaller();
		} catch (JAXBException e) {
			fail("failed to create unmarshaller: " + e.getLocalizedMessage());
		}
		
		XmlDevsSimulator configSimulator = null;
		try {
			configSimulator = (XmlDevsSimulator) unmarshaller.unmarshal(this.getClass().getClassLoader().getResourceAsStream("ExampleConfigurationNew1.xml"));
		} catch (JAXBException e) {
			fail("failed to create configuration : " + e.getLocalizedMessage());
		}		
		XmlDefinitions definitions = configSimulator.getDefinitions();
		List<XmlNetwork> networks = definitions.getNetworkDefs();
		assertEquals("networks size",1, networks.size());
		
		XmlNetwork net = networks.get(0);
		assertEquals("type of network","network", net.getInstanceType());
		assertEquals("id of network","net0", net.getInstanceId());
		
		List<XmlConnectionPoint> connections = net.getInputConnections();
		assertEquals("nr of input pads", 2, connections.size());
		for (int i = 0; i < connections.size(); i++) {
			assertEquals("input position wrong", Integer.toString(i), connections.get(i).getPosition());
		}
		int nrOfInputs = connections.size();
		
		connections = net.getOutputConnections();
		assertEquals("nr of output pads", 2, connections.size());
		for (int i = 0; i < connections.size(); i++) {
			assertEquals("output position wrong", Integer.toString(nrOfInputs + i), connections.get(i).getPosition());
		}
	}
	
	@Test
	public void loadRunner() {
		JAXBContext context = null;
		try {
			context = JAXBContext.newInstance(XmlDevsSimulator.class);
		} catch (JAXBException e) {
			fail("failed to create context : " + e.getLocalizedMessage());
		}
		Unmarshaller unmarshaller = null;
		try {
			unmarshaller = context.createUnmarshaller();
		} catch (JAXBException e) {
			fail("failed to create unmarshaller: " + e.getLocalizedMessage());
		}
		
		XmlDevsSimulator configSimulator = null;
		try {
			configSimulator = (XmlDevsSimulator) unmarshaller.unmarshal(this.getClass().getClassLoader().getResourceAsStream("ExampleConfigurationNew1.xml"));
		} catch (JAXBException e) {
			fail("failed to create configuration : " + e.getLocalizedMessage());
		}
		
		XmlRunner runner = configSimulator.getRunner();
		List<XmlExternalSource> externalSources = runner.getExternalSources();
		assertEquals("nr of external sources", 2, externalSources.size());
		for (int i = 0; i < externalSources.size(); i++) {
			assertEquals("type of external ", "source", externalSources.get(i).getInstanceType());
			assertEquals("id for external source", "es" + i , externalSources.get(i).getInstanceId());
		}
		List<XmlSamplingDevice> samplingDevices = runner.getSamplingDevices();
		assertEquals("nr of sampling devices", 2, samplingDevices.size());
		for(int i = 0; i <samplingDevices.size(); i++) {
			assertEquals("type of sampling device ", "device", samplingDevices.get(i).getInstanceType());
			assertEquals("id for sampling device", "sd" + i , samplingDevices.get(i).getInstanceId());
		}
		List<XmlWire> wires = runner.getConnections();
		assertEquals("nr of connections in runner", 4 , wires.size());
	}
}
