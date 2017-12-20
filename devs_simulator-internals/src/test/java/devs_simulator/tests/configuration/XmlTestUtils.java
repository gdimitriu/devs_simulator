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
import static org.junit.Assert.assertNotNull;

import devs_simulator.internals.configuration.XmlDefinitions;
import devs_simulator.internals.configuration.xmldefinitions.XmlConnection;
import devs_simulator.internals.configuration.xmldefinitions.XmlConnectionPoint;
import devs_simulator.internals.configuration.xmldefinitions.XmlInstantiable;
import devs_simulator.internals.configuration.xmldefinitions.XmlNetwork;
import devs_simulator.internals.configuration.xmldefinitions.XmlProcessor;
import devs_simulator.internals.configuration.xmldefinitions.XmlWire;

/**
 * Utils for test validations of xml configurations.
 * @author Gabriel Dimitriu
 *
 */
public final class XmlTestUtils {

	/**
	 * 
	 */
	public XmlTestUtils() {
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
		validateListOfConnection(inputs, inInstances, inPositions);
		validateListOfConnection(outputs, outInstances, outPositions);
	}

	/**
	 * Validate list of connection
	 * @param inputs
	 * @param inInstances
	 * @param inPosition
	 */
	private static void validateListOfConnection(final List<XmlConnection> inputs, final List<String> inInstances,
			final List<String> inPosition) {
		for (int i = 0; i < inputs.size(); i++) {
			assertEquals(inInstances.get(i), inputs.get(i).getInstanceId());
			assertEquals(inPosition.get(i), inputs.get(i).getPosition());
		}
	}
	
	/**
	 * Validate list of connection points
	 * @param message the message to display
	 * @param connections the list of connection points
	 * @param instancesTypes the type of the connection points
	 * @param positions the position of the connection points
	 * @param sizes the size of each wire
	 */
	public static void validateListOfConnectionPoints(final String message, final List<XmlConnectionPoint> connections, 
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
	 * validate the processor xml definition.
	 @param message the message to display
	 * @param processor the processor in xml structure
	 * @param instanceId the id of the processor
	 * @param instanceType the type of processor
	 * @param inTypes the type in input connections
	 * @param inPositions the positions of input connections
	 * @param outTypes the type of output connections
	 * @param outPositions the positions of output connections
	 * @param inSize the size of input elements
	 * @param outSize the size of output elements
	 */
	public static void validateProcessor(final String message, final XmlProcessor processor,
			final String instanceId, final String instanceType,
			final List<String> inTypes, final List<String> inPositions,
			final List<String> outTypes, final List<String> outPositions,
			final List<Integer> inSize, final List<Integer> outSize) {
		assertEquals(message + " expected values for input does not agree ", inTypes.size(), inPositions.size());
		assertEquals(message + " exepcted values for outptus does not agree ", outTypes.size(), outPositions.size());
		assertEquals(message + " instanceId ", instanceId, processor.getInstanceId());
		assertEquals(message + " instanceType ", instanceType, processor.getInstanceType());
		assertEquals(message + " inputs size does not match ", inTypes.size(), processor.getInputConnections().size());
		assertEquals(message + " output size does not match ", outTypes.size(), processor.getOutputConnections().size());
		validateListOfConnectionPoints(message + " input ", processor.getInputConnections(), inTypes, inPositions, inSize);
		validateListOfConnectionPoints(message + " output ", processor.getOutputConnections(), outTypes, outPositions, outSize);
	}

	/**
	 * Validate the wires references and ports.
	 * @param wires the wires to be checked.
	 * @param net the network in which wires reside.
	 * @param definitions from the definition section.
	 */
	public static void validateWiresReferences(final List<XmlWire> wires, final XmlNetwork net, final XmlDefinitions definitions) {
		for (XmlWire wire : wires) {
			validateWireRefereces(wire, net, definitions);
		}		
	}
	
	/**
	 * Validate the wires references and ports.
	 * @param wire the wire to be checked
	 * @param net the network in which wires reside.
	 * @param definitions from the definition section.
	 */	
	public static void validateWireRefereces(final XmlWire wire, final XmlNetwork net, final XmlDefinitions definitions) {
		List<XmlConnection> connections = wire.getInputs();
		for (XmlConnection connection : connections) {
			validateConnectionReferences(connection, net, definitions);
		}
		connections = wire.getOutputs();
		for (XmlConnection connection : connections) {
			validateConnectionReferences(connection, net, definitions);
		}
	}
	
	/**
	 * Validate the connection references and ports.
	 * @param connection the connection from wire
	 * @param net the network in which wires reside.
	 * @param definitions from the definition section.
	 */

	private static void validateConnectionReferences(final XmlConnection connection, final XmlNetwork net, final XmlDefinitions definitions) {
		if (connection.getInstanceId() != null && !connection.getInstanceId().isEmpty()) {
			XmlInstantiable instance = net.getInstanceById(connection.getInstanceId());
			assertNotNull("instance with the id " + connection.getInstanceId() + "doesn't exist", instance);
			if (instance.getType() != null && !instance.getType().isEmpty()) {
				instance = definitions.getInstanceDefByType(instance.getType());
			}
			if (instance instanceof XmlProcessor) {
				instance = ((XmlProcessor) instance).getInstanceByPosition(connection.getPosition());
				assertNotNull("processor " + connection.getInstanceId() + " with internal position " + connection.getPosition() + " doesn't exist", instance);
			} else if (instance instanceof XmlNetwork) {
				instance = ((XmlNetwork) instance).getInstanceByPosition(connection.getPosition());
				assertNotNull("network " + connection.getInstanceId() + " with internal position " + connection.getPosition() + " doesn't exist", instance);
			}
		} else {
			XmlInstantiable instance = net.getInstanceByPosition(connection.getPosition());
			assertNotNull("instance with position " + connection.getPosition() + " doesn't exist", instance);
		}
	}
}
