package dp;

public class MaxProductOfCuttingRope_87 {
    //Given a rope with positive integer-length n, how to cut the rope into
    // m integer-length parts with length p[0], p[1], ...,p[m-1], in order
    // to get the maximal product of p[0]*p[1]* ... *p[m-1]? m is determined
    // by you and must be greater than 0 (at least one cut must be made).
    // Return the max product you can have.

    public int maxProduct(int length) {
        int[] dp = new int[length + 1];
        for (int i = 1; i <= length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 1; j < i; j++) {
                max = Math.max(max, (i - j) * Math.max(j, dp[j]));
            }
            dp[i] = max;
        }
        return dp[length];
    }


}
