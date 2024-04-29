package pl.pwr.ite.aizo.algorithm;

import pl.pwr.ite.aizo.model.AlgorithmType;
import pl.pwr.ite.aizo.model.ShellAlgorithmType;
import pl.pwr.ite.aizo.model.ShellSortOptions;
import pl.pwr.ite.aizo.service.SortingAlgorithmBase;

public class ShellSort extends SortingAlgorithmBase<ShellSortOptions> {

    public void sort(int[] data) {
        int length = data.length;
        int gap = getGap(length);

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
        int length = data.length;
        int gap = getGap(length);

        for(; gap > 0; gap /= 2) {
            for(int i = gap; i < length; i++) {
                char temp = data[i];
                int j;
                for(j = i; j >= gap && data[j - gap] > temp; j -= gap) {
                    data[j] = data[j - gap];
                }
                data[j] = temp;
            }
        }
    }

    @Override
    protected void sort(double[] data) {
        int length = data.length;
        int gap = getGap(length);

        for(; gap > 0; gap /= 2) {
            for(int i = gap; i < length; i++) {
                double temp = data[i];
                int j;
                for(j = i; j >= gap && data[j - gap] > temp; j -= gap) {
                    data[j] = data[j - gap];
                }
                data[j] = temp;
            }
        }
    }

    private int getGap(int length) {
        int gap = 1;
        if(getSortOptions().getShellAlgorithmType().equals(ShellAlgorithmType.Shell)) {
            gap = length / 2;
        } else if (getSortOptions().getShellAlgorithmType().equals(ShellAlgorithmType.Knuth)) {
            while (gap < length / 3) {
                gap = 3 * gap + 1;
            }
        }
        return gap;
    }

    @Override
    protected AlgorithmType getAlgorithmType() {
        return AlgorithmType.Shell;
    }
}
