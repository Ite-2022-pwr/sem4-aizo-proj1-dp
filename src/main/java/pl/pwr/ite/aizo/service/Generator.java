package pl.pwr.ite.aizo.service;

import java.util.Random;

public class Generator {

    private final Random random = new Random();

    public int[] generateInts(int size) {
        return random.ints(size).toArray();
    }

    public char[] generateChars(int size) {
        char[] chars = new char[size];
        for(int i = 0; i < size; i++) {
            chars[i] = (char)randomInt(65, 91);
        }
        return chars;
    }

    public double[] generateDoubles(int size) {
        return random.doubles(size).toArray();
    }

    public int randomInt(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }
}
