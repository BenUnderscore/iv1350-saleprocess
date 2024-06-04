package se.kth.iv1350.highergradetasks;

import java.util.Random;

public class ComposedSummingRandom {
    private double sum;
    private Random random;

    public ComposedSummingRandom() {
        random = new Random();
        sum = 0.0;
    }

    public ComposedSummingRandom(long seed) {
        random = new Random();
        sum = 0.0;
    }

    public void nextBytes(byte[] bytes) {
        random.nextBytes(bytes);
        for(int i = 0; i < bytes.length; i++) {
            sum += bytes[i];
        }
    }

    public int nextInt() {
        int value = random.nextInt();
        sum += value;
        return value;
    }

    public int nextInt(int upperBound) {
        int value = random.nextInt(upperBound);
        sum += value;
        return value;
    }

    public long nextLong() {
        long value = random.nextLong();
        sum += value;
        return value;
    }

    public float nextFloat() {
        float value = random.nextFloat();
        sum += value;
        return value;
    }

    public double nextDouble() {
        double value = random.nextDouble();
        sum += value;
        return value;
    }
    
    public double nextGaussian() {
        double value = random.nextGaussian();
        sum += value;
        return value;
    }

    public double getSum() {
        return sum;
    }
}
