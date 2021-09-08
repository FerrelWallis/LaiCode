package dfs;

public class KeepDistanceForIdenticalElement_264 {
    //Given an integer k, arrange the sequence of integers [1, 1, 2, 2, 3, 3, ...., k - 1, k - 1, k, k],
    //such that the output integer array satisfy this condition:
    //Between each two i's, they are exactly i integers (for example: between the two 1s, there is one number,
    //between the two 2's there are two numbers).
    //If there does not exist such sequence, return null.

    //Assumptions: k is guaranteed to be > 0
    //Examples: k = 3, The output = { 2, 3, 1, 2, 1, 3 }.

    //levels? k
    //branches? depends on how many position current element can be put
    //assume k = 3      positons 2k = 6
    //level 0 3         3xxx3x      x3xxx3
    //                    |            !
    //level 1 2         3x2x32      23x2x3
    //                    |            |
    //level 2 1         312132      231213

    public int[] keepDistance(int k) {
        int[] ans = new int[2 * k];
        return dfs(ans, k) ? ans : null;
    }

    private boolean dfs(int[] ans, int index) {
        if (index == 0) {
            return true;
        }
        for (int i = 0; i < ans.length - 1 - index; i++) {
            if (ans[i] == 0 && ans[i + 1 + index] == 0) {
                ans[i] = index;
                ans[i + 1 + index] = index;
                if (dfs(ans, index - 1)) {
                    return true;
                }
                ans[i] = 0;
                ans[i + 1 + index] = 0;
            }
        }
        return false;
    }

}
