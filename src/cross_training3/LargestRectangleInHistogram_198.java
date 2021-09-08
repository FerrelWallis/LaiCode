package cross_training3;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleInHistogram_198 {
    //Given a non-negative integer array representing the heights of a list of adjacent bars.
    //Suppose each bar has a width of 1. Find the largest rectangular area that can be formed in the histogram.
    //Assumptions: The given array is not null or empty

    //Examples
    //{ 2, 1, 3, 3, 4 }, the largest rectangle area is 3 * 3 = 9(starting from index 2 and ending at index 4)

    //stack 保持单调递增，左边是当前height的左边界，当遇到比当前小的，把stack中比其小的pop出来算他们的面积，他们的右边界就是这个小的数
    //linear scan and look back
    //clarify: non-negative, not null, not empty
    //high level : linear scan the array, and maintain an ascending stack
    // when cur > stack.peek  stack.offer(cur++) which means peek is the left border of current height
    // when cur < stack.peek  stack.poll() and calculate the area of poll height, cur is the right border and peek is left border
    public int largest(int[] bars) {
        Deque<Integer> ascStack = new ArrayDeque<>();
        int max = 0;
        for (int i = 0; i <= bars.length; i++) {
            int curheight = i == bars.length ? 0 : bars[i];
            while (!ascStack.isEmpty() && bars[ascStack.peekFirst()] > curheight) {
                int height = bars[ascStack.pollFirst()];
                int left = ascStack.isEmpty() ? -1 : ascStack.peekFirst();
                max = Math.max(max, height * (i - left - 1));
            }
            ascStack.offerFirst(i);
        }
        return max;
    }

}
