package dfs;

public class TwoSubsetsWithMinDifference_263 {
    //Given a set of n integers, divide the set in two subsets of n/2 sizes each such that the difference of the sum of two subsets is as minimum as possible.
    //
    //Return the minimum difference(absolute value).
    //
    //Assumptions:
    //
    //The given integer array is not null and it has length of >= 2.
    //Examples:
    //
    //{1, 3, 2} can be divided into {1, 2} and {3}, the minimum difference is 0

    //subset problem
    //1. compute the total sum
    //2. dfs sub set record the sum which are most mindiff to (total sum / 2)
    public int minDifference(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int a : array) {
            sum += a;
        }
        int[] mindiff = new int[1];
        mindiff[0] = Integer.MAX_VALUE;
        dfs(array, mindiff, sum,0, 0, 0);
        return mindiff[0];
    }

    private void dfs(int[] array, int[] mindiff, int sum, int presum, int index, int count) {
        if (count == array.length / 2) {
            int left = sum - presum;
            int diff = Math.abs(left - presum);
            mindiff[0] = mindiff[0] > diff ? diff : mindiff[0];
            return;
        }
        dfs(array, mindiff, sum, presum + array[index], index + 1, count + 1);
        dfs(array, mindiff, sum, presum, index + 1, count);
    }

}
