public class LongestConsecutive1s_103 {
    //Given an array containing only 0s and 1s, find the length of the longest subarray of consecutive 1s.

    //Assumptions
    //The given array is not null

    //Examples
    //{0, 1, 0, 1, 1, 1, 0}, the longest consecutive 1s is 3.

    //M[i] 表示0~i(必须包含i)最长连续1的长度
    //base case: M[0] = a[0]
    //Induction rule: M[i] = M[i - 1] + 1 if(a[i] == 1)
    //                M[i] = 0            else a[i] == 0
    //optimize: M[i] is only related to M[i - 1] so use a int variable prev to record previous sum
    //          base case: prev = a[0]
    //time O(length) space O(1)
    public int longest(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int max = array[0];
        int prev = array[0];
        for (int i = 1; i < array.length; i++) {
            prev = array[i] == 0 ? 0 : prev + 1;
            max = Math.max(max, prev);
        }
        return max;
    }

}
