/* Copyright 2002-2023 CS GROUP
 * Licensed to CS GROUP (CS) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * CS licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.orekit.propagation;

import org.orekit.time.AbsoluteDate;

/** This interface is intended for ephemerides valid only during a time range.
 *
 * <p>This interface provides a mean to retrieve orbital parameters at
 * any time within a given range. It should be implemented by orbit readers
 * based on external data files and by continuous models built after numerical
 * integration has been completed and dense output data as been
 * gathered.</p>
 *
 * @author Luc Maisonobe
 *
 */
public interface BoundedPropagator extends Propagator {

    /** Get the first date of the range.
     * @return the first date of the range
     */
    AbsoluteDate getMinDate();

    /** Get the last date of the range.
     * @return the last date of the range
     */
    AbsoluteDate getMaxDate();

}