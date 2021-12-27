package sorting;

public class MergeSort_9 {
    //1.partition
    //           4 2 8 6 13 1 16 10         time O(1 + 2 + 4 +... + n / 2) = O(n)
    //        4 2 8 6     13 1 16 10           1
    //      4 2    8 6   13 1    16 10         2
    //   4   2    8   6   13   1   16   10     4
    //                                        ...
    //                                        n / 2
    //  space complexity = heap + stack = O(1) + O(logn) = O(logn)

    //2. merge                                levels of rec = logn
    //   4   2    8   6   13   1   16   10    O(n)
    //    \/        \/      \/       \/
    //   2 4       6 8      1 13    10 16     O(n)
    //         \/                \/
    //      2 4 6 8          1 10 13 16       O(n)
    //                 \/
    //           1 2 4 6 8 10 13 16          time Com: O(n*logn)  space com: O(n + logn)
    public int[] mergeSort(int[] array) {
        int[] helper = new int[array.length];
        partition(array, helper, 0, array.length - 1);
        return array;
    }

    public void partition(int[] array, int[] helper, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;
        partition(array, helper, left, mid);
        partition(array, helper, mid + 1, right);
        merge(array, helper, left, mid, right);
    }

    public void merge(int[] array, int[] helper, int left, int mid, int right) {
        for (int i = 0; i < array.length; i++) {
            helper[i] = array[i];
        }
        int l = left;
        int r = mid + 1;
        for (int i = left; l <= mid && i <= right; i++) {
            if (r > right || helper[l] <= helper[r]) {
                array[i] = helper[l++];
            } else {
                array[i] = helper[r++];
            }
        }
    }




}
