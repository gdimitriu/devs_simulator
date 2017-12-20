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

import static org.junit.Assert.assertEquals;
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
import devs_simulator.internals.configuration.xmldefinitions.XmlProcessor;
import devs_simulator.internals.structure.defaults.Processor;
import devs_simulator.internals.structure.factory.ProcessorFactory;

/**
 * Unitests for processor.
 * @author Gabriel Dimitriu
 *
 */
public class ProcessorTests {

	/** the simulator configuration */
	private XmlDevsSimulator configSimulator = null;
	/** the definitions of processors and networks */
	private XmlDefinitions definitions = null;
	/**
	 * 
	 */
	public ProcessorTests() {
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
	public void createReferencedAndInlineProcessor() {
		XmlNetwork net = definitions.getNetworkById("net0");
		assertNotNull("network with id net0 should exist", net);
		List<XmlProcessor> xmlProcs = net.getProcessors();
		ProcessorFactory factory = new ProcessorFactory(definitions);
		final List<Processor> procs = new ArrayList<>();
		xmlProcs.stream().forEach(xmlProc -> procs.add(factory.createProcessor(xmlProc)));
		assertEquals("nr of processors should be ", 2, procs.size());
		
		List<String> inTypes = new ArrayList<>();
		inTypes.add("input");
		List<String> inPositions = new ArrayList<>();
		inPositions.add("0");
		List<String> outTypes = new ArrayList<>();
		outTypes.add("output");
		List<String> outPositions = new ArrayList<>();
		outPositions.add("1");
		List<Integer> inSize = new ArrayList<>();
		inSize.add(1);
		InternalTestUtils.validateProcessor("first proc", procs.get(0), "p0", "proc1", inTypes, inPositions, outTypes, outPositions, inSize, inSize);
		inSize.clear();
		inSize.add(2);
		InternalTestUtils.validateProcessor("second proc", procs.get(1), "p1", "proc2", inTypes, inPositions, outTypes, outPositions, inSize, inSize);
	}	
}
