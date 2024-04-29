package pl.pwr.ite.aizo.algorithm;

import pl.pwr.ite.aizo.model.AlgorithmType;
import pl.pwr.ite.aizo.model.QuickSortOptions;
import pl.pwr.ite.aizo.service.SortingAlgorithmBase;

public class QuickSort extends SortingAlgorithmBase<QuickSortOptions> {

    @Override
    public void sort(int[] data) {
        quickSort(data, 0, data.length - 1);
    }

    private void quickSort(int[] data, int first, int last) {
        var pivot = choosePivot(data, first, last);
        int i = first;
        int j = last;

        while (i <= j) {
            while (data[i] < pivot) {
                i++;
            }
            while (data[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(data, i, j);
                i++;
                j--;
            }
        }

        if(first < j) {
            quickSort(data, first, j);
        }
        if(i < last) {
            quickSort(data, i, last);
        }
    }

    private void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    private int choosePivot(int[] data, int first, int last) {
        return switch (getSortOptions().getPivotPosition()) {
            case Left -> data[first];
            case Right -> data[last];
            case Middle -> data[(first + last) / 2];
            case Random -> data[generator.randomInt(first, last)];
        };
    }

    @Override
    protected void sort(char[] data) {
        quickSort(data, 0, data.length - 1);
    }

    private void quickSort(char[] data, int first, int last) {
        var pivot = choosePivot(data, first, last);
        int i = first;
        int j = last;

        while (i <= j) {
            while (data[i] < pivot) {
                i++;
            }
            while (data[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(data, i, j);
                i++;
                j--;
            }
        }

        if(first < j) {
            quickSort(data, first, j);
        }
        if(i < last) {
            quickSort(data, i, last);
        }
    }

    private void swap(char[] data, int i, int j) {
        char temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    private char choosePivot(char[] data, int first, int last) {
        return switch (getSortOptions().getPivotPosition()) {
            case Left -> data[first];
            case Right -> data[last];
            case Middle -> data[(first + last) / 2];
            case Random -> data[generator.randomInt(first, last)];
        };
    }

    @Override
    protected void sort(double[] data) {
        quickSort(data, 0, data.length - 1);
    }

    private void quickSort(double[] data, int first, int last) {
        var pivot = choosePivot(data, first, last);
        int i = first;
        int j = last;

        while (i <= j) {
            while (data[i] < pivot) {
                i++;
            }
            while (data[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(data, i, j);
                i++;
                j--;
            }
        }

        if(first < j) {
            quickSort(data, first, j);
        }
        if(i < last) {
            quickSort(data, i, last);
        }
    }

    private void swap(double[] data, int i, int j) {
        double temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    private double choosePivot(double[] data, int first, int last) {
        return switch (getSortOptions().getPivotPosition()) {
            case Left -> data[first];
            case Right -> data[last];
            case Middle -> data[(first + last) / 2];
            case Random -> data[generator.randomInt(first, last)];
        };
    }

    @Override
    protected AlgorithmType getAlgorithmType() {
        return AlgorithmType.Quick;
    }
}
