package pl.pwr.ite.aizo.service;

import java.util.Random;

public class Generator {

    private final Random random = new Random();

    public int[] generateInts(int size) {
        return random.ints(size).toArray();
    }

    public char[] generateChars(int size) {
        return new char[0];
    }

    public double[] generateDoubles(int size) {
        return new double[0];
    }
}
