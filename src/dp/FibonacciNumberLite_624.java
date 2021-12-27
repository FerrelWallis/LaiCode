package dp;

public class FibonacciNumberLite_624 {

    //f(k) = f(k - 1) + f (k - 2)
    public int fibonacci(int k) {
        int[] dp = new int[k + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= k; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[k];
    }
}
