/**
 * 
 * Copyright 2018 paolo mococci
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * 	   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package local.example.draft.service;

import org.apache.commons.math4.random.GaussianRandomGenerator;
import org.apache.commons.math4.random.UncorrelatedRandomVectorGenerator;
import org.apache.commons.rng.UniformRandomProvider;
import org.apache.commons.rng.simple.RandomSource;

/**
 *
 * @author paolo mococci
 */

public class AleatoryService {
    private final int[] seed;
    private final UniformRandomProvider urp;
    private final GaussianRandomGenerator grg;
    private final UncorrelatedRandomVectorGenerator urvg;

    public AleatoryService() {
        super();
        this.seed = RandomSource.createIntArray(256);
        this.urp = RandomSource.create(RandomSource.MT, seed);
        this.grg = new GaussianRandomGenerator(urp);
        this.urvg = new UncorrelatedRandomVectorGenerator(256, grg);
    }

    public double getUniformRandomProvider() {
        return urp.nextDouble();
    }

    public double getGaussianRandomGenerator() {
        return grg.nextNormalizedDouble();
    }

    public double[] getUncorrelatedRandomVector() {
        return urvg.nextVector();
    }
}
