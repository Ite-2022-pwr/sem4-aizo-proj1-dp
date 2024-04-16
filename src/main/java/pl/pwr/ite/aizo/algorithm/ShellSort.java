package pl.pwr.ite.aizo.algorithm;

import pl.pwr.ite.aizo.model.ShellSortOptions;
import pl.pwr.ite.aizo.service.SortingAlgorithmBase;

public class ShellSort extends SortingAlgorithmBase<ShellSortOptions> {

    public void sort(int[] data) {
        int length = data.length;
//        int gap = length / 2;
        int gap = getSortOptions().getGap();

        for(; gap > 0; gap /= 2) {
            for(int i = gap; i < length; i++) {
                int temp = data[i];
                int j;
                for(j = i; j >= gap && data[j - gap] > temp; j -= gap) {
                    data[j] = data[j - gap];
                }
                data[j] = temp;
            }
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
