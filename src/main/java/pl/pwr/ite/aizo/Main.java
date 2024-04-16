package pl.pwr.ite.aizo;

import pl.pwr.ite.aizo.algorithm.HeapSort;
import pl.pwr.ite.aizo.model.DefaultSortOptions;
import pl.pwr.ite.aizo.service.Sorter;

import java.time.Duration;
import java.time.Instant;

public class Main {

    private static final Sorter sorter = new Sorter();

    public static void main(String... arg) {
        var result = sorter.insertionSort();
        result.size();
    }
}