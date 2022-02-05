package local.example.aleatory.service;

import org.apache.commons.math3.random.*;
import org.apache.commons.rng.UniformRandomProvider;
import org.apache.commons.rng.simple.RandomSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

public class AleatoryService {

    private final UniformRandomProvider uniformRandomProvider;
    private final UncorrelatedRandomVectorGenerator uncorrelatedRandomVectorGenerator;

    private final RandomGenerator randomGenerator;
    private final RandomGenerator.SplittableGenerator splittableGenerator;

    public AleatoryService() {
        randomGenerator = RandomGenerator.of("L64X256MixRandom");

        splittableGenerator = RandomGeneratorFactory
                .<RandomGenerator.SplittableGenerator>of("L64X256MixRandom").create();

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

    public List<Long> getThreadSafeRandomLongNumberVector() {
        List<Long> longs = Collections.synchronizedList(new ArrayList<>());
        ExecutorService executorService = Executors.newCachedThreadPool();

        splittableGenerator.splits(256).forEach(
                splittableGenerator -> executorService.submit(() -> {
                    longs.add(splittableGenerator.nextLong());
        }));
        return longs;
    }

    public List<Double> getThreadSafeRandomDoubleNumberVector() {
        List<Double> doubles = Collections.synchronizedList(new ArrayList<>());
        ExecutorService executorService = Executors.newCachedThreadPool();

        splittableGenerator.splits(256).forEach(
                splittableGenerator -> executorService.submit(() -> {
                    doubles.add(splittableGenerator.nextDouble());
        }));
        return doubles;
    }
}
