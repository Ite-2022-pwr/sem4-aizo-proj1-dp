package pl.pwr.ite.aizo.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SortResult {

    private int arraySize;

    private SortDataType dataType;

    private AlgorithmType algorithmType;

    private PivotPosition pivotPosition;

    private ArrayType arrayType;

    private ShellAlgorithmType shellAlgorithmType;

    private List<Long> sortTimes = new ArrayList<>();

    public Double getAverageTime() {
        return sortTimes.stream().mapToLong(l -> l).average().getAsDouble();
    }
}
