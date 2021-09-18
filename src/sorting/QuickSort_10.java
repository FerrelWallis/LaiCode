package sorting;

import java.util.ArrayList;
import java.util.List;

public class QuickSort_10 {

    public static void main(String[] args) {
        QuickSort_10 test = new QuickSort_10();
        test.quickSort(new int[]{388,-304,304,-350,26,366,190,85,468,-321,159,-29,269,360,454,-214,496,-472});

    }

    public int[] quickSort(int[] array) {
        if (array == null || array.length == 0) {
            return new int[]{};
        }
        quickSort(array, 0, array.length - 1);
        return array;
    }

    public void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = partition(array, left, right);
        quickSort(array, left, mid - 1);
        quickSort(array, mid + 1, right);
    }

    public int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = 0;
        int j = right - 1;
        while (i <= j) {
            if (arr[i] < pivot) {
                i++;
            } else if(arr[j] >= pivot) {
                j--;
            } else {
                swap(arr, i++, j--);
            }
        }
        swap(arr, i, right);
        return i;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
