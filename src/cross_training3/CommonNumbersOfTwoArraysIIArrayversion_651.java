package cross_training3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonNumbersOfTwoArraysIIArrayversion_651 {
    //Find all numbers that appear in both of two unsorted arrays.

    //Assumptions
    //Both of the two arrays are not null.
    //In any of the two arrays, there could be duplicate numbers.

    //Examples
    //A = {1, 2, 3, 2}, B = {3, 4, 2, 2, 2}, return [2, 2, 3] (there are both two 2s in A and B)

    //谁小移谁
    //1. sort两个array
    //i,j指针，如果两个元素相等，i++,j++, add to list
    //        如果a[i] < b[j] i++
    //        如果a[i] > b[j] j++
    public List<Integer> common(int[] a, int[] b) {
        List<Integer> ans = new ArrayList<>();
        if (a.length == 0 || b.length == 0) {
            return ans;
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int i = 0;
        int j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                ans.add(a[i]);
                i++;
                j++;
            } else if (a[i] < b[j]) {
                i++;
            } else {
                j++;
            }
        }
        return ans;
    }
}
