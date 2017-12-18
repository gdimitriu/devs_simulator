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

import java.util.List;
import static org.junit.Assert.assertEquals;

import devs_simulator.internals.configuration.xmldefinitions.XmlConnection;
import devs_simulator.internals.configuration.xmldefinitions.XmlWire;

/**
 * Utils for test validations.
 * @author Gabriel Dimitriu
 *
 */
public final class TestUtils {

	/**
	 * 
	 */
	public TestUtils() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Validate that a wire has the correct parameters
	 * @param actual the wire instance
	 * @param inInstances the input instances
	 * @param inPositions the input ports
	 * @param outInstances the output instances
	 * @param outPositions the output ports
	 */
	public static void validateXMLWire(final XmlWire actual,
			final List<String> inInstances, final List<String> inPositions,
			final List<String> outInstances, final List<String> outPositions) {
		
		assertEquals("input size din't agree", inInstances.size(), inPositions.size());
		assertEquals("output size din't agree", outInstances.size(), outPositions.size());
		List<XmlConnection> inputs = actual.getInputs();
		assertEquals("not the same size of inputs", inInstances.size(), inputs.size());
		List<XmlConnection> outputs = actual.getOutputs();
		assertEquals("not the same size of outputs", outInstances.size(), outputs.size());
		ValidateListOfConnection(inputs, inInstances, inPositions);
		ValidateListOfConnection(outputs, outInstances, outPositions);
	}

	/**
	 * Validate list of connection
	 * @param inputs
	 * @param inInstances
	 * @param inPosition
	 */
	private static void ValidateListOfConnection(final List<XmlConnection> inputs, final List<String> inInstances,
			final List<String> inPosition) {
		for (int i = 0; i < inputs.size(); i++) {
			assertEquals(inInstances.get(i), inputs.get(i).getInstanceId());
			assertEquals(inPosition.get(i), inputs.get(i).getPosition());
		}
	}
}
