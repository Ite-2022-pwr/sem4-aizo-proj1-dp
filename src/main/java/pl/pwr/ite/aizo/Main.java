package pl.pwr.ite.aizo;

import pl.pwr.ite.aizo.menu.MainMenu;
import pl.pwr.ite.aizo.model.*;
import pl.pwr.ite.aizo.service.FileService;
import pl.pwr.ite.aizo.service.Sorter;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final Sorter sorter = new Sorter();
    private static final FileService fileService = new FileService();

    public static void main(String... arg) {
        MainMenu.printMainMenu();
    }

    private static void start() {
        List<SortResult> results = new ArrayList<>();
        var startTime = Instant.now();

        quickSort(results);
        fileService.writeResults(results);

        results.clear();
        shellSort(results);
        fileService.writeResults(results);

        results.clear();
        heapSort(results);
        fileService.writeResults(results);

        results.clear();
        insertionSort(results);
        fileService.writeResults(results);

        var finishTime = Instant.now();
        var duration = Duration.between(startTime, finishTime).toMillis();
        System.out.println("Whole sorting took " + duration + " ms.");
    }

    public static void insertionSort(List<SortResult> results) {
        Instant start = Instant.now();
        var options = new SortOptions();
        options.setIterations(20);
        options.setArraySizes(DefaultSortOptions.SORT_SIZES);
        for(var dataType : SortDataType.values()) {
            options.setDataType(dataType);
            for(var arrayType : ArrayType.values()) {
                options.setArrayType(arrayType);
                results.addAll(sorter.insertionSort(options));
                System.out.println("INSERTION SORT | " + dataType + " | " + arrayType + " finished");
            }
        }
        Instant finish = Instant.now();
        System.out.println("INSERTION SORT finished, took " + Duration.between(start, finish).toMillis() + " ms.");
    }

    public static void heapSort(List<SortResult> results) {
        Instant start = Instant.now();
        var options = new SortOptions();
        options.setIterations(100);
        options.setArraySizes(DefaultSortOptions.SORT_SIZES);
        for(var dataType : SortDataType.values()) {
            options.setDataType(dataType);
            for(var arrayType : ArrayType.values()) {
                options.setArrayType(arrayType);
                results.addAll(sorter.heapSort(options));
                System.out.println("HEAP SORT | " + dataType + " | " + arrayType + " finished");
            }
        }
        Instant finish = Instant.now();
        System.out.println("HEAP SORT finished, took " + Duration.between(start, finish).toMillis() + " ms.");
    }

    public static void quickSort(List<SortResult> results) {
        Instant start = Instant.now();
        var options = new QuickSortOptions();
        options.setIterations(100);
        options.setArraySizes(DefaultSortOptions.QUICK_SORT_SIZES);
        for(var dataType : SortDataType.values()) {
            options.setDataType(dataType);
            for(var arrayType : ArrayType.values()) {
                options.setArrayType(arrayType);
                for(var pivotPosition : PivotPosition.values()) {
                    options.setPivotPosition(pivotPosition);
                    results.addAll(sorter.quickSort(options));
                    System.out.println("QUICK SORT | " + dataType + " | " + arrayType + " | " + pivotPosition + " finished");
                }
            }
        }
        Instant finish = Instant.now();
        System.out.println("QUICK SORT finished, took " + Duration.between(start, finish).toMillis() + " ms.");
    }

    public static void shellSort(List<SortResult> results) {
        Instant start = Instant.now();
        var options = new ShellSortOptions();
        options.setIterations(100);
        options.setArraySizes(DefaultSortOptions.SORT_SIZES);
        for(var dataType : SortDataType.values()) {
            options.setDataType(dataType);
            for(var arrayType : ArrayType.values()) {
                options.setArrayType(arrayType);
                for(var algorithmType : ShellAlgorithmType.values()) {
                    options.setShellAlgorithmType(algorithmType);
                    results.addAll(sorter.shellSort(options));
                    System.out.println("SHELL SORT | " + dataType + " | " + arrayType + " | " + algorithmType + " finished");
                }
            }
        }
        Instant finish = Instant.now();
        System.out.println("SHELL SORT finished, took " + Duration.between(start, finish).toMillis() + " ms.");
    }
}