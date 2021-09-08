public class FibonacciNumber_12 {
    //Get the Kth number in the Fibonacci Sequence. (K is 0-indexed, the 0th Fibonacci number is 0 and
    //the 1st Fibonacci number is 1).

    //Examples
    //0th fibonacci number is 0
    //1st fibonacci number is 1
    //2nd fibonacci number is 1
    //3rd fibonacci number is 2
    //6th fibonacci number is 8

    //Corner Cases
    //What if K < 0? in this case, we should always return 0.
    //Is it possible the result fibonacci number is overflowed? We can assume it will not be overflowed
    //when we solve this problem on this online judge, but we should also know that it is possible to get
    //an overflowed number, and sometimes we will need to use something like BigInteger.

    public long fibonacci(int k) {
        if (k < 0) {
            return 0;
        }
        long[] dp = new long[k + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= k; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[k];
    }

}
