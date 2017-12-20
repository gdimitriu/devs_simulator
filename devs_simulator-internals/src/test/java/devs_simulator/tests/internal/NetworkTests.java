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
package devs_simulator.tests.internal;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.junit.Before;
import org.junit.Test;

import devs_simulator.internals.configuration.XmlDefinitions;
import devs_simulator.internals.configuration.XmlDevsSimulator;
import devs_simulator.internals.configuration.xmldefinitions.XmlNetwork;
import devs_simulator.internals.structure.defaults.Network;
import devs_simulator.internals.structure.factory.NetworkFactory;

/**
 * Unitests for the network.
 * @author Gabriel Dimitriu
 *
 */
public class NetworkTests {

	/** the simulator configuration */
	private XmlDevsSimulator configSimulator = null;
	/** the definitions of processors and networks */
	private XmlDefinitions definitions = null;
	
	/**
	 * 
	 */
	public NetworkTests() {
		// TODO Auto-generated constructor stub
	}
	
	/** load the xml configuration 
	 * @throws JAXBException */ 
	@Before
	public void loadXmlConfiguration() {
		try {
			JAXBContext context = JAXBContext.newInstance(XmlDevsSimulator.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			configSimulator = (XmlDevsSimulator) unmarshaller.unmarshal(this.getClass().getClassLoader().getResourceAsStream("DEVSConfigurationEx1.xml"));
			definitions = configSimulator.getDefinitions();
		} catch (JAXBException e) {
			fail("failed to create configuration : " + e.getLocalizedMessage());
		}
	}
	
	@Test
	public void validateProcessorsInNetwork() {
		XmlNetwork net = definitions.getNetworkById("net0");
		assertNotNull("network with id net0 should exist", net);
		NetworkFactory factory = new NetworkFactory(definitions);
		Network network = null;
		try {
			network = factory.createNetwork(net);
		} catch (Exception e) {
			fail("exception cought in create network:" + e.getLocalizedMessage());
		}
		assertNotNull("network with id net0 should be created", network);
		List<String> inTypes = new ArrayList<>();
		inTypes.add("input");
		inTypes.add("input");
		List<String> inPositions = new ArrayList<>();
		inPositions.add("0");
		inPositions.add("1");
		List<String> outTypes = new ArrayList<>();
		outTypes.add("output");
		outTypes.add("output");
		List<String> outPositions = new ArrayList<>();
		outPositions.add("2");
		outPositions.add("3");
		List<Integer> inSize = new ArrayList<>();
		inSize.add(1);
		inSize.add(2);
		InternalTestUtils.validateBaseConnectable("net0", network, "net0", "network", inTypes, inPositions, outTypes, outPositions, inSize, inSize);
		ProcessorTests.validateNet0Procs(network.getProcessors());
	}

}
