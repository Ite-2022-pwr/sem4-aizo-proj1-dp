package pl.pwr.ite.aizo.algorithm;

import pl.pwr.ite.aizo.model.QuickSortOptions;
import pl.pwr.ite.aizo.service.SortingAlgorithmBase;

public class QuickSort extends SortingAlgorithmBase<QuickSortOptions> {

    public void sort(int[] data) {
        quickSort(data, 0, data.length - 1);
    }

    private void quickSort(int[] data, int first, int last) {
        if(first < last) {
            int pi = partition(data, first, last);
            quickSort(data, first, pi - 1);
            quickSort(data, pi + 1, last);
        }
    }

    private int partition(int[] data, int first, int last) {
        int pivot = data[last];
        int i = first - 1;
        for(int j = first; j <= last - 1; j++) {
            if(data[j] < pivot) {
                i++;
                swap(data, i, j);
            }
        }
        swap(data, i + 1, last);
        return i + 1;
    }

    private void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    @Override
    protected void sort(char[] data) {
        throw new UnsupportedOperationException("Sort not implemented.");
    }

    @Override
    protected void sort(double[] data) {
        throw new UnsupportedOperationException("Sort not implemented.");
    }
}
