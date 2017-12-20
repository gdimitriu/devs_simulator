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

import java.util.List;

import devs_simulator.internals.structure.defaults.BaseStructureConnectable;
import devs_simulator.internals.structure.interfaces.IConnectionPoint;

/**
 * Utils for test validations of internal configurations.
 * @author Gabriel Dimitriu
 *
 */
public final class InternalTestUtils {

	/**
	 * 
	 */
	public InternalTestUtils() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Validate list of connection points.
	 * @param message the message to display
	 * @param connections the list of connection points
	 * @param instancesTypes the type of the connection points
	 * @param positions the position of the connection points
	 * @param sizes the size of each wire
	 */
	public static void validateListOfConnectionPoints(final String message, final List<IConnectionPoint> connections, 
			final List<String> instancesTypes, final List<String> positions, final List<Integer> sizes) {
		assertEquals(message + " expected values does not agree ", instancesTypes.size(), positions.size());
		assertEquals(message + " the connections does not have the same size as expected ", instancesTypes.size(), connections.size());
		for (int i = 0; i < connections.size(); i++) {
			assertEquals("instanceType does not match for " + message, instancesTypes.get(i), connections.get(i).getInstanceType());
			assertEquals("instance position does not match for " + message, positions.get(i), connections.get(i).getPosition());
			assertEquals("instance size does not match for " + message, sizes.get(i), Integer.valueOf(connections.get(i).getSize()));
		}
	}
	
	/**
	 * validate the processor internal definition.
	 * @param message the message to display
	 * @param instance the processor/network in internal structure
	 * @param instanceId the id of the processor
	 * @param instanceType the type of processor
	 * @param inTypes the type in input connections
	 * @param inPositions the positions of input connections
	 * @param outTypes the type of output connections
	 * @param outPositions the positions of output connections
	 * @param inSize the size of input elements
	 * @param outSize the size of output elements
	 */
	public static void validateBaseConnectable(final String message, final BaseStructureConnectable instance,
			final String instanceId, final String instanceType,
			final List<String> inTypes, final List<String> inPositions,
			final List<String> outTypes, final List<String> outPositions,
			final List<Integer> inSize, final List<Integer> outSize) {
		assertEquals(message + " expected values for input does not agree ", inTypes.size(), inPositions.size());
		assertEquals(message + " expected values for outptus does not agree ", outTypes.size(), outPositions.size());
		assertEquals(message + " instanceId ", instanceId, instance.getInstanceId());
		assertEquals(message + " instanceType ", instanceType, instance.getInstanceType());
		assertEquals(message + " inputs size does not match ", inTypes.size(), instance.getInputConnectionPoints().size());
		assertEquals(message + " output size does not match ", outTypes.size(), instance.getOutputConnectionPoints().size());
		validateListOfConnectionPoints(message + " input ", instance.getInputConnectionPoints(), inTypes, inPositions, inSize);
		validateListOfConnectionPoints(message + " output ", instance.getOutputConnectionPoints(), outTypes, outPositions, outSize);
	}
}
