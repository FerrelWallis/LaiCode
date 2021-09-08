package cross_training3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonNumbersOfTwoArraysIArrayversion_650 {
    //Find all numbers that appear in both of the two unsorted arrays, return the common numbers in increasing order.
    //
    //Assumptions
    //
    //Both arrays are not null.
    //There are no duplicate numbers in each of the two arrays respectively.
    //Exmaples
    //
    //A = {1, 2, 3}, B = {3, 1, 4}, return [1, 3]
    //A = {}, B = {3, 1, 4}, return []

    //unsorted, no dup, not null,  return in ascending
    //M1.谁小移谁 （sort first）
    //M2. binary search(unsorted)

    // M2 binary search 假设在a里面找b中元素， a长度为n, b长度为m  O(m*log2(n))
    public List<Integer> common(int[] a, int[] b) {
        List<Integer> ans = new ArrayList<>();
        if (a.length == 0 || b.length == 0) {
            return ans;
        }
        if (b.length > a.length) {
            return common(b, a);
        }
        for (int bb : b) {
            if (binarySearch(a, bb)) {
                ans.add(bb);
            }
        }
        return ans;
    }

    private boolean binarySearch(int[] a, int target) {
        int left = 0;
        int right = a.length - 1;
        Arrays.sort(a);
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a[mid] == target) {
                return true;
            } else if (a[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

}
