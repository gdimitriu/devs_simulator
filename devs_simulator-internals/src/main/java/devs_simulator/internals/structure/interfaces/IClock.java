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
package devs_simulator.internals.structure.interfaces;

import java.time.LocalDateTime;

/**
 * Interface for the clock signal.
 * @author Gabriel Dimitriu
 *
 */
public interface IClock {

	/** advance the clock with internal step */
	void advance();
	
	/** register the runner based on the visitor pattern */
	void registerRunner(final IRunningInstance visitor);
	
	/** set the advancing clock in second */
	void setAdvanceSecond(final long seconds);
	
	void setAdvance(final LocalDateTime advance);
}
