package local.example.aleatory.service;

import org.apache.commons.math3.random.*;
import org.apache.commons.rng.UniformRandomProvider;
import org.apache.commons.rng.simple.RandomSource;

public class AleatoryService {

    private final UniformRandomProvider uniformRandomProvider;
    private final UncorrelatedRandomVectorGenerator uncorrelatedRandomVectorGenerator;

    public AleatoryService() {
        uniformRandomProvider = RandomSource.create(RandomSource.WELL_512_A);
        uncorrelatedRandomVectorGenerator = new UncorrelatedRandomVectorGenerator(
                256,
                new GaussianRandomGenerator(
                        new ISAACRandom()
                )
        );
    }

    public double getUniformRandomProvider() {
        return uniformRandomProvider.nextDouble();
    }

    public double[] getUncorrelatedRandomVector() {
        return uncorrelatedRandomVectorGenerator.nextVector();
    }
}
