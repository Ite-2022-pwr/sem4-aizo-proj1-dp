package pl.pwr.ite.aizo.service;

import pl.pwr.ite.aizo.algorithm.HeapSort;
import pl.pwr.ite.aizo.algorithm.InsertionSort;
import pl.pwr.ite.aizo.algorithm.QuickSort;
import pl.pwr.ite.aizo.algorithm.ShellSort;
import pl.pwr.ite.aizo.model.*;

import java.util.List;

public class Sorter {

    private final HeapSort heapSort = new HeapSort();
    private final InsertionSort insertionSort = new InsertionSort();
    private final QuickSort quickSort = new QuickSort();
    private final ShellSort shellSort = new ShellSort();

    public List<SortResult> heapSort() {
        return this.heapSort(DefaultSortOptions.DEFAULT_INTEGER);
    }

    public List<SortResult> heapSort(SortOptions sortOptions) {
        return heapSort.sort(sortOptions);
    }

    public List<SortResult> insertionSort() {
        return this.insertionSort(DefaultSortOptions.DEFAULT_INTEGER);
    }

    public List<SortResult> insertionSort(SortOptions sortOptions) {
        return insertionSort.sort(sortOptions);
    }

    public List<SortResult> quickSort() {
        return this.quickSort(DefaultSortOptions.DEFAULT_QUICK_SORT_INTEGER);
    }

    public List<SortResult> quickSort(QuickSortOptions sortOptions) {
        return quickSort.sort(sortOptions);
    }

    public List<SortResult> shellSort() {
        return this.shellSort(DefaultSortOptions.DEFAULT_SHELL_INTEGER);
    }

    public List<SortResult> shellSort(ShellSortOptions sortOptions) {
        return shellSort.sort(sortOptions);
    }
}
