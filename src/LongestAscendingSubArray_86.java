public class LongestAscendingSubArray_86 {
    //Given an unsorted array, find the length of the longest subarray in which the numbers are in ascending order.
    //
    //Assumptions
    //
    //The given array is not null
    //Examples
    //
    //{7, 2, 3, 1, 5, 8, 9, 6}, longest ascending subarray is {1, 5, 8, 9}, length is 4.
    //
    //{1, 2, 3, 3, 4, 4, 5}, longest ascending subarray is {1, 2, 3}, length is 3.

    //base case: M[0] = 1
    //induction rule: 1. array[i] > array[i - 1]  M[i] = M[i - 1] + 1
    //                2.          <=              M[i] = M[i - 1]
    public int longest(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int pre = 1;
        int max = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                pre += 1;
            } else {
                pre = 1;
            }
            max = Math.max(max, pre);
        }
        return max;
    }

}
