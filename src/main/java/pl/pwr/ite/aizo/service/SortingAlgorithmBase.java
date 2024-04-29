package pl.pwr.ite.aizo.service;

import com.sun.source.tree.BreakTree;
import lombok.Getter;
import lombok.Setter;
import pl.pwr.ite.aizo.model.*;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public abstract class SortingAlgorithmBase<E extends SortOptions> {

    protected final Generator generator = new Generator();

    @Getter
    @Setter
    private E sortOptions;

    @Getter
    @Setter
    private long[] sortTimes;

    public List<SortResult> sort(E options) {
        if(options == null) {
            throw new IllegalArgumentException("No options provided.");
        }
        this.sortOptions = options;
        this.sortTimes = new long[options.getIterations()];

        PivotPosition pivotPosition = null;
        ShellAlgorithmType shellAlgorithmType = null;
        if(options instanceof QuickSortOptions quickSortOptions) {
            pivotPosition = quickSortOptions.getPivotPosition();
        } else if(options instanceof ShellSortOptions shellSortOptions) {
            shellAlgorithmType = shellSortOptions.getShellAlgorithmType();
        }

        var sortTimes = new ArrayList<SortResult>();

        for(int i = 0; i < options.getArraySizes().length; i++) {
            var arraySize = options.getArraySizes()[i];

            var sort = new SortResult();
            sort.setArraySize(arraySize);
            sort.setAlgorithmType(getAlgorithmType());
            sort.setDataType(options.getDataType());
            sort.setPivotPosition(pivotPosition);
            sort.setShellAlgorithmType(shellAlgorithmType);
            sort.setArrayType(options.getArrayType());

            for(int j = 0; j < options.getIterations(); j++) {
                Instant startTime;
                switch (options.getDataType()) {
                    case Integer -> {
                        int[] data = options.getIntData() == null
                                ? getIntData(options, arraySize)
                                : options.getIntData();
                        startTime = Instant.now();
                        sort(data);
                    }
                    case Character -> {
                        char[] data = options.getCharData() == null
                                ? getCharData(options, arraySize)
                                : options.getCharData();
                        startTime = Instant.now();
                        sort(data);
                    }
                    case Double -> {
                        double[] data = options.getDoubleData() == null
                                ? getDoubleData(options, arraySize)
                                : options.getDoubleData();
                        startTime = Instant.now();
                        sort(data);
                    }
                    default -> throw new IllegalArgumentException("Sort data type not supported.");
                }
                var finishTime = Instant.now();
                var sortDuration = Duration.between(startTime, finishTime).toMillis();
                sort.getSortTimes().add(sortDuration);
            }

            sortTimes.add(sort);
        }

        return sortTimes;
    }

    private int[] getIntData(SortOptions options, int arraySize) {
        int[] data = generator.generateInts(arraySize);
        return switch (options.getArrayType()) {
            case FullyRandom -> data;
            case SortedAsc -> {
                Arrays.sort(data);
                yield data;
            }
            case SortedDesc -> Arrays.stream(data).boxed()
                    .sorted(Collections.reverseOrder())
                    .mapToInt(Integer::intValue)
                    .toArray();
            case ThirdSorted -> {
                int third = (int) (arraySize * 0.33);
                Arrays.sort(data, 0, third);
                yield data;
            }
            case TwoThirdSorted -> {
                int twoThird = (int) (arraySize * 0.66);
                Arrays.sort(data, 0, twoThird);
                yield data;
            }
        };
    }

    private char[] getCharData(SortOptions options, int arraySize) {
        char[] data = generator.generateChars(arraySize);
        return switch (options.getArrayType()) {
            case FullyRandom -> data;
            case SortedAsc -> {
                Arrays.sort(data);
                yield data;
            }
            case SortedDesc -> {
                Character[] charObjectArray = new Character[data.length];
                for (int i = 0; i < data.length; i++) {
                    charObjectArray[i] = data[i];
                }
                Arrays.sort(charObjectArray, Comparator.reverseOrder());
                for (int i = 0; i < data.length; i++) {
                    data[i] = charObjectArray[i];
                }
                yield data;
            }
            case ThirdSorted -> {
                int third = (int) (arraySize * 0.33);
                Arrays.sort(data, 0, third);
                yield data;
            }
            case TwoThirdSorted -> {
                int twoThird = (int) (arraySize * 0.66);
                Arrays.sort(data, 0, twoThird);
                yield data;
            }
        };
    }

    private double[] getDoubleData(SortOptions options, int arraySize) {
        double[] data = generator.generateDoubles(arraySize);
        return switch (options.getArrayType()) {
            case FullyRandom -> data;
            case SortedAsc -> {
                Arrays.sort(data);
                yield data;
            }
            case SortedDesc -> Arrays.stream(data).boxed()
                    .sorted(Collections.reverseOrder())
                    .mapToDouble(Double::doubleValue)
                    .toArray();
            case ThirdSorted -> {
                int third = (int) (arraySize * 0.33);
                Arrays.sort(data, 0, third);
                yield data;
            }
            case TwoThirdSorted -> {
                int twoThird = (int) (arraySize * 0.66);
                Arrays.sort(data, 0, twoThird);
                yield data;
            }
        };
    }


    protected abstract AlgorithmType getAlgorithmType();

    protected abstract void sort(int[] data);
    protected abstract void sort(char[] data);
    protected abstract void sort(double[] data);

}
