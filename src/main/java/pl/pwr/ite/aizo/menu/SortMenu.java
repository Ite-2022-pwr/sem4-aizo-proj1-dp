package pl.pwr.ite.aizo.menu;

import pl.pwr.ite.aizo.model.*;
import pl.pwr.ite.aizo.service.Sorter;

import java.awt.*;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Scanner;

public class SortMenu {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Sorter sorter = new Sorter();

    public static void printSortMenu(SortOptions sortOptions) {
        if(
                (sortOptions.getIntData() == null || sortOptions.getIntData().length == 0)
                && (sortOptions.getCharData() == null || sortOptions.getCharData().length == 0)
                && (sortOptions.getDoubleData() == null || sortOptions.getDoubleData().length == 0)
        ) {
            System.out.println("No data array provided. Load or generate array first.");
            MainMenu.printMainMenu();
        }
        System.out.println("\n");
        System.out.println("[1] Heap sort.");
        System.out.println("[2] Insertion sort.");
        System.out.println("[3] Quick sort.");
        System.out.println("[4] Shell sort.");
        System.out.println("[5] Exit.");

        System.out.println("\n");
        switch (scanner.nextInt()) {
            case 1 -> heapSort(sortOptions);
            case 2 -> insertionSort(sortOptions);
            case 3 -> quickSort(sortOptions);
            case 4 -> shellSort(sortOptions);
            case 5 -> SortMenu.printSortMenu(sortOptions);
            default -> {
                System.out.println("Unsupported operation.");
                SortMenu.printSortMenu(sortOptions);
            }
        }
    }

    private static void heapSort(SortOptions sortOptions) {
        long duration = -1;
        if(sortOptions.getDataType().equals(SortDataType.Integer)) {
            var dataCopy = Arrays.copyOf(sortOptions.getIntData(), sortOptions.getIntData().length);

            var startTime = Instant.now();
            sorter.heapSort(sortOptions);
            var finishTime = Instant.now();

            System.out.println("Original unsorted array (first 20 elements)");
            System.out.println(Arrays.toString(Arrays.copyOfRange(dataCopy, 0, 20)));

            System.out.println("Sorted array (first 20 elements)");
            System.out.println(Arrays.toString(Arrays.copyOfRange(sortOptions.getIntData(), 0, 20)));

            sortOptions.setIntData(dataCopy);
            duration = Duration.between(startTime, finishTime).toMillis();
        } else if(sortOptions.getDataType().equals(SortDataType.Character)) {
            var dataCopy = Arrays.copyOf(sortOptions.getCharData(), sortOptions.getCharData().length);

            var startTime = Instant.now();
            sorter.heapSort(sortOptions);
            var finishTime = Instant.now();

            System.out.println("Original unsorted array (first 20 elements)");
            System.out.println(Arrays.toString(Arrays.copyOfRange(dataCopy, 0, 20)));

            System.out.println("Sorted array (first 20 elements)");
            System.out.println(Arrays.toString(Arrays.copyOfRange(sortOptions.getCharData(), 0, 20)));

            sortOptions.setCharData(dataCopy);
            duration = Duration.between(startTime, finishTime).toMillis();
        } else if(sortOptions.getDataType().equals(SortDataType.Double)) {
            var dataCopy = Arrays.copyOf(sortOptions.getDoubleData(), sortOptions.getDoubleData().length);

            var startTime = Instant.now();
            sorter.heapSort(sortOptions);
            var finishTime = Instant.now();

            System.out.println("Original unsorted array (first 20 elements)");
            System.out.println(Arrays.toString(Arrays.copyOfRange(dataCopy, 0, 20)));

            System.out.println("Sorted array (first 20 elements)");
            System.out.println(Arrays.toString(Arrays.copyOfRange(sortOptions.getDoubleData(), 0, 20)));

            sortOptions.setDoubleData(dataCopy);
            duration = Duration.between(startTime, finishTime).toMillis();
        }
        System.out.println("Sorting took " + duration + " ms.");
    }

    private static void insertionSort(SortOptions sortOptions) {
        long duration = -1;
        if(sortOptions.getDataType().equals(SortDataType.Integer)) {
            var dataCopy = Arrays.copyOf(sortOptions.getIntData(), sortOptions.getIntData().length);

            var startTime = Instant.now();
            sorter.insertionSort(sortOptions);
            var finishTime = Instant.now();

            System.out.println("Original unsorted array (first 20 elements)");
            System.out.println(Arrays.toString(Arrays.copyOfRange(dataCopy, 0, 20)));

            System.out.println("Sorted array (first 20 elements)");
            System.out.println(Arrays.toString(Arrays.copyOfRange(sortOptions.getIntData(), 0, 20)));

            sortOptions.setIntData(dataCopy);
            duration = Duration.between(startTime, finishTime).toMillis();
        } else if(sortOptions.getDataType().equals(SortDataType.Character)) {
            var dataCopy = Arrays.copyOf(sortOptions.getCharData(), sortOptions.getCharData().length);

            var startTime = Instant.now();
            sorter.insertionSort(sortOptions);
            var finishTime = Instant.now();

            System.out.println("Original unsorted array (first 20 elements)");
            System.out.println(Arrays.toString(Arrays.copyOfRange(dataCopy, 0, 20)));

            System.out.println("Sorted array (first 20 elements)");
            System.out.println(Arrays.toString(Arrays.copyOfRange(sortOptions.getCharData(), 0, 20)));

            sortOptions.setCharData(dataCopy);
            duration = Duration.between(startTime, finishTime).toMillis();
        } else if(sortOptions.getDataType().equals(SortDataType.Double)) {
            var dataCopy = Arrays.copyOf(sortOptions.getDoubleData(), sortOptions.getDoubleData().length);

            var startTime = Instant.now();
            sorter.insertionSort(sortOptions);
            var finishTime = Instant.now();

            System.out.println("Original unsorted array (first 20 elements)");
            System.out.println(Arrays.toString(Arrays.copyOfRange(dataCopy, 0, 20)));

            System.out.println("Sorted array (first 20 elements)");
            System.out.println(Arrays.toString(Arrays.copyOfRange(sortOptions.getDoubleData(), 0, 20)));

            sortOptions.setDoubleData(dataCopy);
            duration = Duration.between(startTime, finishTime).toMillis();
        }
        System.out.println("Sorting took " + duration + " ms.");
    }

    private static void quickSort(SortOptions sortOptions) {
        sortOptions = QuickSortOptions.builder()
                .dataType(sortOptions.getDataType())
                .arrayType(sortOptions.getArrayType())
                .arraySizes(sortOptions.getArraySizes())
                .iterations(sortOptions.getIterations())
                .intData(sortOptions.getIntData())
                .charData(sortOptions.getCharData())
                .doubleData(sortOptions.getDoubleData())
                .build();
        getQuickSortOptions((QuickSortOptions) sortOptions);
        long duration = -1;
        if(sortOptions.getDataType().equals(SortDataType.Integer)) {
            var dataCopy = Arrays.copyOf(sortOptions.getIntData(), sortOptions.getIntData().length);

            var startTime = Instant.now();
            sorter.quickSort((QuickSortOptions) sortOptions);
            var finishTime = Instant.now();

            System.out.println("Original unsorted array (first 20 elements)");
            System.out.println(Arrays.toString(Arrays.copyOfRange(dataCopy, 0, 20)));

            System.out.println("Sorted array (first 20 elements)");
            System.out.println(Arrays.toString(Arrays.copyOfRange(sortOptions.getIntData(), 0, 20)));

            sortOptions.setIntData(dataCopy);
            duration = Duration.between(startTime, finishTime).toMillis();
        } else if(sortOptions.getDataType().equals(SortDataType.Character)) {
            var dataCopy = Arrays.copyOf(sortOptions.getCharData(), sortOptions.getCharData().length);

            var startTime = Instant.now();
            sorter.quickSort((QuickSortOptions) sortOptions);
            var finishTime = Instant.now();

            System.out.println("Original unsorted array (first 20 elements)");
            System.out.println(Arrays.toString(Arrays.copyOfRange(dataCopy, 0, 20)));

            System.out.println("Sorted array (first 20 elements)");
            System.out.println(Arrays.toString(Arrays.copyOfRange(sortOptions.getCharData(), 0, 20)));

            sortOptions.setCharData(dataCopy);
            duration = Duration.between(startTime, finishTime).toMillis();
        } else if(sortOptions.getDataType().equals(SortDataType.Double)) {
            var dataCopy = Arrays.copyOf(sortOptions.getDoubleData(), sortOptions.getDoubleData().length);

            var startTime = Instant.now();
            sorter.quickSort((QuickSortOptions) sortOptions);
            var finishTime = Instant.now();

            System.out.println("Original unsorted array (first 20 elements)");
            System.out.println(Arrays.toString(Arrays.copyOfRange(dataCopy, 0, 20)));

            System.out.println("Sorted array (first 20 elements)");
            System.out.println(Arrays.toString(Arrays.copyOfRange(sortOptions.getDoubleData(), 0, 20)));

            sortOptions.setDoubleData(dataCopy);
            duration = Duration.between(startTime, finishTime).toMillis();
        }
        System.out.println("Sorting took " + duration + " ms.");
    }

    private static void shellSort(SortOptions sortOptions) {
        sortOptions = ShellSortOptions.builder()
                .dataType(sortOptions.getDataType())
                .arrayType(sortOptions.getArrayType())
                .arraySizes(sortOptions.getArraySizes())
                .iterations(sortOptions.getIterations())
                .intData(sortOptions.getIntData())
                .charData(sortOptions.getCharData())
                .doubleData(sortOptions.getDoubleData())
                .build();

        getShellSortOptions((ShellSortOptions) sortOptions);
        long duration = -1;
        if(sortOptions.getDataType().equals(SortDataType.Integer)) {
            var dataCopy = Arrays.copyOf(sortOptions.getIntData(), sortOptions.getIntData().length);

            var startTime = Instant.now();
            sorter.shellSort((ShellSortOptions) sortOptions);
            var finishTime = Instant.now();

            System.out.println("Original unsorted array (first 20 elements)");
            System.out.println(Arrays.toString(Arrays.copyOfRange(dataCopy, 0, 20)));

            System.out.println("Sorted array (first 20 elements)");
            System.out.println(Arrays.toString(Arrays.copyOfRange(sortOptions.getIntData(), 0, 20)));

            sortOptions.setIntData(dataCopy);
            duration = Duration.between(startTime, finishTime).toMillis();
        } else if(sortOptions.getDataType().equals(SortDataType.Character)) {
            var dataCopy = Arrays.copyOf(sortOptions.getCharData(), sortOptions.getCharData().length);

            var startTime = Instant.now();
            sorter.shellSort((ShellSortOptions) sortOptions);
            var finishTime = Instant.now();

            System.out.println("Original unsorted array (first 20 elements)");
            System.out.println(Arrays.toString(Arrays.copyOfRange(dataCopy, 0, 20)));

            System.out.println("Sorted array (first 20 elements)");
            System.out.println(Arrays.toString(Arrays.copyOfRange(sortOptions.getCharData(), 0, 20)));

            sortOptions.setCharData(dataCopy);
            duration = Duration.between(startTime, finishTime).toMillis();
        } else if(sortOptions.getDataType().equals(SortDataType.Double)) {
            var dataCopy = Arrays.copyOf(sortOptions.getDoubleData(), sortOptions.getDoubleData().length);

            var startTime = Instant.now();
            sorter.shellSort((ShellSortOptions) sortOptions);
            var finishTime = Instant.now();

            System.out.println("Original unsorted array (first 20 elements)");
            System.out.println(Arrays.toString(Arrays.copyOfRange(dataCopy, 0, 20)));

            System.out.println("Sorted array (first 20 elements)");
            System.out.println(Arrays.toString(Arrays.copyOfRange(sortOptions.getDoubleData(), 0, 20)));

            sortOptions.setDoubleData(dataCopy);
            duration = Duration.between(startTime, finishTime).toMillis();
        }
        System.out.println("Sorting took " + duration + " ms.");
    }

    private static void getQuickSortOptions(QuickSortOptions quickSortOptions) {
        boolean shouldContinue = true;
        while (shouldContinue) {
            System.out.println("Choose pivot position");
            System.out.println("[1] Left");
            System.out.println("[2] Right");
            System.out.println("[3] Middle");
            System.out.println("[4] Random");
            var pivotPosition = switch (scanner.nextInt()) {
                case 1 -> PivotPosition.Left;
                case 2 -> PivotPosition.Right;
                case 3 -> PivotPosition.Middle;
                case 4 -> PivotPosition.Random;
                default -> null;
            };
            if(pivotPosition == null) {
                continue;
            }
            shouldContinue = false;
            quickSortOptions.setPivotPosition(pivotPosition);
        }
    }

    private static void getShellSortOptions(ShellSortOptions shellSortOptions) {
        boolean shouldContinue = true;
        while (shouldContinue) {
            System.out.println("Choose Shell algorithm");
            System.out.println("[1] Shell");
            System.out.println("[2] Knuth");
            var shellAlgorithm = switch (scanner.nextInt()) {
                case 1 -> ShellAlgorithmType.Shell;
                case 2 -> ShellAlgorithmType.Knuth;
                default -> null;
            };
            if(shellAlgorithm == null) {
                continue;
            }
            shouldContinue = false;
            shellSortOptions.setShellAlgorithmType(shellAlgorithm);
        }
    }
}
