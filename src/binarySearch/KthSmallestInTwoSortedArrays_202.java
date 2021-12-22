package binarySearch;

public class KthSmallestInTwoSortedArrays_202 {

    //a: 1 2 ( 8 9 13 15 22)
    //      k/2
    //  k/2
    //      k/2
    //
    //b: 3 4 5 (10 17 16)
    //      k/2
    //          k/2
    //k: 6
    //1. delete the k/2 elements in the smaller array (a[k/2], b[k/2])
    //2. k = k - k/2 = 3
    // k/2 = 1  1 < 10 dele (0 k/2) from a
    //k = k - k/2 = 2
    // k/2 = 1 2 < 10 dele (2) from a
    // k = k - k / 2 = 1
    // head of two array and see which is smaller
    //8 < 10
    //6th smallest = 8

    //a: (1 2 8) 9 13 15 22
    //b: (3 4 5) 10 17 16
    //        6th
    //k: 6

    //1. a is empty => return b[sb + k - 1]
    //2. b is empty => return a[sa + k - 1]
    //3. k = 1 => return min(a[sa], b[sb])
    //4. if eles in one array is smaller than k / 2
    // (9 13) 15 22   k = 4
    //    4th
    // (10 ?)
    // delete k / 2 eles in a  and k = k - k / 2
    //5. if ele in both array are larger than k / 2
    // compare the k/2th ele in each part and delete the k/2 eles in the smaller part
    //a: (1 2 8) 9 13 15 22
    //b: (3 4 5) 10 17 16
    public int findKthSmallest(int[] a, int[] b, int k) {
        return helper(a, 0, b, 0, k);
    }

    public int helper(int[] a, int sa, int[] b, int sb, int k) {
        if (sa >= a.length) {
            return b[sb + k - 1];
        } else if (sb >= b.length) {
            return a[sa + k - 1];
        } else if (k == 1) {
            return Math.min(a[sa], b[sb]);
        }
        int amid = (sa + k / 2 - 1 >= a.length) ? Integer.MAX_VALUE : a[sa + k / 2 - 1];
        int bmid = (sb + k / 2 - 1 >= b.length) ? Integer.MAX_VALUE : b[sb + k / 2 - 1];
        if (amid <= bmid) {
            return helper(a, sa + k / 2, b, sb, k - k / 2);
        } else  {
            return helper(a, sa, b, sb + k / 2, k - k / 2);
        }
    }
}
