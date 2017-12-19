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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;
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
import devs_simulator.internals.configuration.xmldefinitions.XmlProcessor;
import devs_simulator.internals.configuration.xmldefinitions.XmlSamplingDevice;
import devs_simulator.internals.configuration.xmldefinitions.XmlWire;

/**
 * Validate the unmarshall of the devs configuration description.
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

	/**
	 * Validate the definition part of the DEVS description.
	 */
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
			configSimulator = (XmlDevsSimulator) unmarshaller.unmarshal(this.getClass().getClassLoader().getResourceAsStream("DEVSConfigurationEx1.xml"));
		} catch (JAXBException e) {
			fail("failed to create configuration : " + e.getLocalizedMessage());
		}		
		XmlDefinitions definitions = configSimulator.getDefinitions();
		
		List<XmlNetwork> networks = definitions.getNetworkDefs();
		assertEquals("networks size should be",1, networks.size());
		XmlNetwork net = networks.get(0);
		validateNetwork(net, definitions);
		
		List<XmlProcessor> processors = definitions.getProcessorDefs();
		assertEquals("processor size should be ", 1, processors.size());
		
		List<String> inTypes = new ArrayList<>();
		inTypes.add("input");
		List<String> inPositions = new ArrayList<>();
		inPositions.add("0");
		
		List<String> outTypes = new ArrayList<>();
		outTypes.add("output");
		List<String> outPositions = new ArrayList<>();
		outPositions.add("1");
		TestUtils.validateProcessor("proc definition", processors.get(0), "", "proc1", inTypes, inPositions, outTypes, outPositions);
	}

	/**
	 * Validate the network example
	 * @param networks
	 * @param definitions 
	 */
	public void validateNetwork(final XmlNetwork net, final XmlDefinitions definitions) {
		
		assertEquals("type of network","network", net.getInstanceType());
		assertEquals("id of network","net0", net.getInstanceId());
		
		List<XmlConnectionPoint> connections = net.getInputConnections();
		List<String> instancesTypes = new ArrayList<>();
		List<String> positions = new ArrayList<>();
		instancesTypes.add("input");
		instancesTypes.add("input");
		positions.add("0");
		positions.add("1");
		TestUtils.validateListOfConnectionPoints("inputs", connections, instancesTypes, positions);
		
		connections = net.getOutputConnections();
		instancesTypes.clear();
		instancesTypes.add("output");
		instancesTypes.add("output");
		positions.clear();
		positions.add("2");
		positions.add("3");
		TestUtils.validateListOfConnectionPoints("outputs", connections, instancesTypes, positions);
		
		List<XmlProcessor> processors = net.getProcessors();
		assertEquals("nr or proc from master network", 2, processors.size());
		
		assertEquals("type id of proc by reference ","proc1", processors.get(0).getType());
		assertEquals("id of first proc", "p0", processors.get(0).getInstanceId());
		assertNotNull("the proc with specied type is not defined", definitions.getProcessorDefByType(processors.get(0).getType()));
		
		List<String> inTypes = new ArrayList<>();
		inTypes.add("input");
		List<String> inPositions = new ArrayList<>();
		inPositions.add("0");
		
		List<String> outTypes = new ArrayList<>();
		outTypes.add("output");
		List<String> outPositions = new ArrayList<>();
		outPositions.add("1");
		TestUtils.validateProcessor("second proc", processors.get(1), "p1", "proc2", inTypes, inPositions, outTypes, outPositions);
		//TODO: validate wires
		List<XmlWire> wires = net.getConnections();
		assertEquals("nr of internal connections", 4, wires.size());
		TestUtils.validateWiresReferences(wires, net, definitions);
	}
	
	/**
	 * Validate the runner part of the DEVS description.
	 */
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
			configSimulator = (XmlDevsSimulator) unmarshaller.unmarshal(this.getClass().getClassLoader().getResourceAsStream("DEVSConfigurationEx1.xml"));
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
		
		List<String> inInstances = new ArrayList<>();
		List<String> inPositions = new ArrayList<>();
		List<String> outInstances = new ArrayList<>();
		List<String> outPositions = new ArrayList<>();
		inInstances.add("es0");
		inPositions.add("0");
		outInstances.add("net0");
		outPositions.add("0");
		TestUtils.validateXMLWire(wires.get(0), inInstances, inPositions, outInstances, outPositions);
		assertNotNull("top level network doesn't exist", configSimulator.getDefinitions().getNetworkById("net0"));
		inInstances.clear();
		inInstances.add("es1");
		inPositions.clear();
		inPositions.add("0");
		outInstances.clear();
		outInstances.add("net0");
		outPositions.clear();
		outPositions.add("1");
		TestUtils.validateXMLWire(wires.get(1), inInstances, inPositions, outInstances, outPositions);
		inInstances.clear();
		inInstances.add("net0");
		inPositions.clear();		
		inPositions.add("2");
		outInstances.clear();
		outInstances.add("sd0");
		outPositions.clear();
		outPositions.add("0");
		TestUtils.validateXMLWire(wires.get(2), inInstances, inPositions, outInstances, outPositions);
		inInstances.clear();
		inInstances.add("net0");
		inPositions.clear();		
		inPositions.add("3");
		outInstances.clear();
		outInstances.add("sd1");
		outPositions.clear();
		outPositions.add("0");
		TestUtils.validateXMLWire(wires.get(3), inInstances, inPositions, outInstances, outPositions);
	}
}
