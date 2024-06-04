package se.kth.iv1350.highergradetasks;

import java.util.Random;

public class InheritedSummingRandom extends Random {

    private double sum;

    public InheritedSummingRandom() {
        super();
        sum = 0.0;
    }

    public InheritedSummingRandom(long seed) {
        super(seed);
        sum = 0.0;
    }

    @Override
    public void nextBytes(byte[] bytes) {
        super.nextBytes(bytes);
        for(int i = 0; i < bytes.length; i++) {
            sum += bytes[i];
        }
    }

    @Override
    public int nextInt() {
        int value = super.nextInt();
        sum += value;
        return value;
    }

    @Override
    public long nextLong() {
        long value = super.nextLong();
        sum += value;
        return value;
    }

    @Override
    public int nextInt(int upperBound) {
        int value = super.nextInt(upperBound);
        sum += value;
        return value;
    }

    @Override
    public float nextFloat() {
        float value = super.nextFloat();
        sum += value;
        return value;
    }

    @Override
    public double nextDouble() {
        double value = super.nextDouble();
        sum += value;
        return value;
    }
    
    @Override
    public double nextGaussian() {
        double value = super.nextGaussian();
        sum += value;
        return value;
    }

    public double getSum() {
        return sum;
    }
}