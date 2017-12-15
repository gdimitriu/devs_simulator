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

import static org.junit.Assert.fail;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

import devs_simulator.internals.configuration.XmlDevsSimulator;

/**
 * @author gdimitriu
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
	public void testLoadBasicConfiguration() {
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
		configSimulator.getDefinitions();
		configSimulator.getRunner();
	}
}
