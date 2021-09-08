package cross_training4;

import java.util.*;

public class MaximumValuesOfSizeKSlidingWindows_204 {
    //Given an integer array A and a sliding window of size K, find the maximum value of each window as
    //it slides from left to right.

    //Assumptions: The given array is not null and is not empty
    //K >= 1, K <= A.length

    //Examples: A = {1, 2, 3, 2, 4, 2, 1}, K = 3, the windows are {{1,2,3}, {2,3,2}, {3,2,4}, {2,4,2}, {4,2,1}},
    //and the maximum values of each K-sized sliding window are [3, 3, 4, 4, 4]

    //linear scan and look back problem
    //maintain an descending stack
    //case 1: new ele => peek of the stack -> pop out all of the ele which smaller than new ele
    //case 2: new ele < peek  -> push it into the stack
    public List<Integer> maxWindows(int[] array, int k) {
        Deque<Integer> stack = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (!stack.isEmpty() && stack.peekLast() == i - k) {
                stack.pollLast();
            }
            while (!stack.isEmpty() && array[stack.peekFirst()] <= array[i]) {
                stack.pollFirst();
            }
            stack.offerFirst(i);
            if (i >= k - 1) {
                ans.add(array[stack.peekLast()]);
            }
        }
        return ans;
    }

}
