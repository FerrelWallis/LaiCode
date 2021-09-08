import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class CommonNumbersOfTwoSortedArraysArrayversion_652 {
    //Find all numbers that appear in both of two sorted arrays (the two arrays are all sorted in ascending order).
    //
    //Assumptions
    //
    //In each of the two sorted arrays, there could be duplicate numbers.
    //Both two arrays are not null.
    //Examples
    //
    //A = {1, 1, 2, 2, 3}, B = {1, 1, 2, 5, 6}, common numbers are [1, 1, 2]

    //双指针
    //case 1: A[i] == B[j] add i++, j++
    //case 2: A[i] > B[j] j++
    //case 3: A[i] < B[j] i++
    public List<Integer> common(int[] A, int[] B) {
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < A.length && j < B.length) {
            if (A[i] == B[j]) {
                ans.add(A[i]);
                i++;
                j++;
            } else if (A[i] < B[j]) {
                i++;
            } else {
                j++;
            }
        }
        return ans;
    }

    //hashmap
    public List<Integer> common2(int[] A, int[] B) {
        HashMap<Integer, Integer> mapA = new LinkedHashMap<>();
        HashMap<Integer, Integer> mapB = new LinkedHashMap<>();
        for (int a : A) {
            Integer count = mapA.get(a);
            if (count == null) {
                mapA.put(a, 1);
            } else {
                mapA.put(a, count + 1);
            }
        }
        for (int b : B) {
            Integer count = mapB.get(b);
            if (count == null) {
                mapB.put(b, 1);
            } else {
                mapB.put(b, count + 1);
            }
        }
        //繁琐的确认，因为可能有duplicate元素
        List<Integer> ans = new ArrayList<>();
        for (HashMap.Entry<Integer, Integer> ma : mapA.entrySet()) {
            Integer countB = mapB.get(ma.getKey());
            if (countB != null) {
                int c = Math.min(countB, ma.getValue());
                for(int i = 0; i < c; i++) {
                    ans.add(ma.getKey());
                }
            }
        }
        return ans;
    }


}
