package cross_training3;

public class MaxWaterTrappedI_199 {
    //Given a non-negative integer array representing the heights of a list of adjacent bars.
    //Suppose each bar has a width of 1. Find the largest amount of water that can be trapped in the histogram.

    //Assumptions: The given array is not null

    //Examples
    //{ 2, 1, 3, 2, 4 }, the amount of water can be trapped is 1 + 1 = 2
    //(at index 1, 1 unit of water can be trapped and index 3, 1 unit of water can be trapped)

    //方法一：left right最高bar dp
    //记录每个bar左右最高的柱子
    public int maxTrapped(int[] array) {
        int[] left = new int[array.length];
        int[] right = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (i == 0 || array[i] >= left[i - 1]) {
                left[i] = array[i];
            } else {
                left[i] = left[i - 1];
            }
            int j = array.length - 1 - i;
            if (j == array.length - 1 || array[j] >= right[j + 1]) {
                right[j] = array[j];
            } else {
                right[j] = right[j + 1];
            }
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            int water = Math.min(left[i], right[i]) - array[i];
            sum += water;
        }
        return sum;
    }

    //方法2：greedy
    //i = 0, j = length - 1
    //leftmax = 0; rightmax = 0
    public int maxTrapped2(int[] array) {
        int leftmax = 0;
        int rightmax = 0;
        int i = 0;
        int j = array.length - 1;
        int max = 0;
        while (i <= j) {
            leftmax = Math.max(leftmax, array[i]);
            rightmax = Math.max(rightmax, array[j]);
            if (leftmax < rightmax) {
                max += (leftmax - array[i]);
                i++;
            } else {
                max += (rightmax - array[i]);
                j--;
            }
        }
        return max;
    }


}
