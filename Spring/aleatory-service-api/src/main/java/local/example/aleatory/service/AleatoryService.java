package local.example.aleatory.service;

import org.apache.commons.math3.random.GaussianRandomGenerator;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.UncorrelatedRandomVectorGenerator;
import org.apache.commons.rng.UniformRandomProvider;
import org.apache.commons.rng.simple.RandomSource;

public class AleatoryService {

    private final UniformRandomProvider uniformRandomProvider;
    private final GaussianRandomGenerator gaussianRandomGenerator;
    private final UncorrelatedRandomVectorGenerator uncorrelatedRandomVectorGenerator;

    public AleatoryService() {
        super();
        int[] seed = RandomSource.createIntArray(256);
        // TODO, to solve: deprecated
        this.uniformRandomProvider = RandomSource.create(RandomSource.MT, seed);
        // TODO, to solve: cannot be cast
        this.gaussianRandomGenerator = new GaussianRandomGenerator((RandomGenerator) uniformRandomProvider);
        this.uncorrelatedRandomVectorGenerator = new UncorrelatedRandomVectorGenerator(
                256,
                gaussianRandomGenerator
        );
    }

    public double getUniformRandomProvider() {
        return uniformRandomProvider.nextDouble();
    }

    public double getGaussianRandomGenerator() {
        return gaussianRandomGenerator.nextNormalizedDouble();
    }

    public double[] getUncorrelatedRandomVector() {
        return uncorrelatedRandomVectorGenerator.nextVector();
    }
}
