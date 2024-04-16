package pl.pwr.ite.aizo.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SortResult {

    private int arraySize;

    private List<Long> sortTimes = new ArrayList<>();

    public Double getAverage() {
        return sortTimes.stream().mapToLong(l -> l).average().getAsDouble();
    }
}
