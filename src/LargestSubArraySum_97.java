public class LargestSubArraySum_97 {
    //base case: sum[0] = array[0]
    //induction rule: sum[i] = sum[i - 1] + array[i] if sum[i - 1] > 0
    //                sum[i] = array[i] if(sum[i - 1] <= 0)
    public int largestSum(int[] array) {
        int[] sum = new int[array.length];
        sum[0] = array[0];
        int globalMax = sum[0];
        for (int i = 1; i < array.length; i++) {
            sum[i] = (sum[i - 1] <= 0 ? 0 : sum[i - 1]) + array[i];
            globalMax = Math.max(globalMax, sum[i]);
        }
        return globalMax;
    }

    //空间优化
    //lastsum : sum[i - 1]
    public int largestSum2(int[] array) {
        int lastsum = array[0];
        int globalMax = array[0];
        for (int i = 1; i < array.length; i++) {
            lastsum = (lastsum <= 0 ? 0 : lastsum) + array[i];
            globalMax = Math.max(globalMax, lastsum);
        }
        return globalMax;
    }
}
