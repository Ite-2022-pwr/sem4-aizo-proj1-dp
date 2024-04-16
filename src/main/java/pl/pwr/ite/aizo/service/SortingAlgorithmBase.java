package pl.pwr.ite.aizo.service;

import lombok.Getter;
import lombok.Setter;
import pl.pwr.ite.aizo.model.SortDataType;
import pl.pwr.ite.aizo.model.SortOptions;
import pl.pwr.ite.aizo.model.SortResult;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public abstract class SortingAlgorithmBase<E extends SortOptions> {

    private final Generator generator = new Generator();

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

        var sortTimes = new ArrayList<SortResult>();

        for(int i = 0; i < options.getArraySizes().length; i++) {
            var arraySize = options.getArraySizes()[i];

            var sort = new SortResult();
            sort.setArraySize(arraySize);

            for(int j = 0; j < options.getIterations(); j++) {
                Instant startTime;
                switch (options.getDataType()) {
                    case Integer -> {
                        var data = generator.generateInts(arraySize);
                        startTime = Instant.now();
                        sort(data);
                    }
                    case Character -> {
                        var data = generator.generateChars(arraySize);
                        startTime = Instant.now();
                        sort(data);
                    }
                    case Double -> {
                        var data = generator.generateDoubles(arraySize);
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

    protected abstract void sort(int[] data);
    protected abstract void sort(char[] data);
    protected abstract void sort(double[] data);
}
