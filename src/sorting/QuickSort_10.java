package sorting;

import java.util.ArrayList;
import java.util.List;

public class QuickSort_10 {

    //  3 5 1 10 8 7 13 11
    // 1. pick a pivot
    // 2. parition the array into 2 part according to the pivot
    //      smaller pivot larger
    //  3 5 1 10 8 7 13 11   pivot = 11
    //                i
    //             j
    //  (          ) 11 ( )
    //  [0, i) : all ele < pivot
    //  [i, j] : all ele waiting to be check
    //  (j, size - 2] : all ele >= pivot

    //1. if array[i] < p => i++
    //2. if array[j] >= p => j--
    //3. array[i] >= p && array[j] < p => swap i, j eles then i++, j--
    //until i > j
    //swap(array, i, p)
    //when only 1 ele in range, stop drill down
    //

    public int[] quickSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        helper(array, 0, array.length - 1);
        return array;
    }
    public void helper(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pindex = right;
        int i = left;
        int j = pindex - 1;
        while (i <= j) {
            if (array[i] < array[pindex]) {
                i++;
            } else if (array[j] >= array[pindex]) {
                j--;
            } else {
                swap(array, i++, j--);
            }
        }
        swap(array, i, pindex);
        helper(array, left, i - 1);
        helper(array, i + 1, right);
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }



}
