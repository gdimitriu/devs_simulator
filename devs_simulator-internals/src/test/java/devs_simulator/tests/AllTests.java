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
package devs_simulator.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import devs_simulator.tests.configuration.ConfigurationLoadTest;
import devs_simulator.tests.internal.NetworkTests;
import devs_simulator.tests.internal.ProcessorTests;

/**
 * Suite of all unitests for devs_simulator.
 * @author Gabriel Dimitriu
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ConfigurationLoadTest.class, ProcessorTests.class, NetworkTests.class})
public class AllTests {

}
