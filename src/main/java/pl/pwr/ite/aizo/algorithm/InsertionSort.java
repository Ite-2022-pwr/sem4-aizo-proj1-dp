package pl.pwr.ite.aizo.algorithm;

import pl.pwr.ite.aizo.model.SortOptions;
import pl.pwr.ite.aizo.service.SortingAlgorithmBase;

public class InsertionSort extends SortingAlgorithmBase<SortOptions> {

    public void sort(int[] data) {
        int length = data.length;
        for(int i = 1; i < length; i++) {
            int key = data[i];
            int j = i - 1;

            while(j >= 0 && data[j] > key) {
                data[j + 1] = data[j];
                j = j - 1;
            }
            data[j + 1] = key;
        }
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
