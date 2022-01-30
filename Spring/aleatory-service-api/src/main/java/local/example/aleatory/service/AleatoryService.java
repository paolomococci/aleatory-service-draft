package local.example.aleatory.service;

import org.apache.commons.math4.random.GaussianRandomGenerator;
import org.apache.commons.math4.random.UncorrelatedRandomVectorGenerator;
import org.apache.commons.rng.UniformRandomProvider;
import org.apache.commons.rng.simple.RandomSource;

import org.springframework.stereotype.Service;

@Service
public class AleatoryService {

    private final UniformRandomProvider uniformRandomProvider;
    private final GaussianRandomGenerator gaussianRandomGenerator;
    private final UncorrelatedRandomVectorGenerator uncorrelatedRandomVectorGenerator;

    public AleatoryService() {
        super();
        int[] seed = RandomSource.createIntArray(256);
        this.uniformRandomProvider = RandomSource.create(RandomSource.MT, seed);
        this.gaussianRandomGenerator = new GaussianRandomGenerator(uniformRandomProvider);
        this.uncorrelatedRandomVectorGenerator = new UncorrelatedRandomVectorGenerator(256, gaussianRandomGenerator);
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
