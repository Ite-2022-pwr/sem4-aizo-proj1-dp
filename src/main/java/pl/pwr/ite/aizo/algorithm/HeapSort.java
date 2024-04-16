package pl.pwr.ite.aizo.algorithm;

import pl.pwr.ite.aizo.model.SortOptions;
import pl.pwr.ite.aizo.service.SortingAlgorithmBase;

public class HeapSort extends SortingAlgorithmBase<SortOptions> {

    @Override
    public void sort(int[] data) {
        int length = data.length;
        for(int i = length / 2; i >= 0; i--) {
            heap(data, length, i);
        }
        for(int i = length - 1; i > 0; i--) {
            int temp = data[0];
            data[0] = data[i];
            data[i] = temp;

            heap(data, i, 0);
        }
    }

    private void heap(int[] data, int length, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if(left < length && data[left] > data[largest]) {
            largest = left;
        }

        if(right < length && data[right] > data[largest]) {
            largest = right;
        }

        if(largest != i) {
            int swap = data[i];
            data[i] = data[largest];
            data[largest] = swap;

            heap(data, length, largest);
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
