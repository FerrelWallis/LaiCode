package recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueens_233 {
    //Get all valid ways of putting N Queens on an N * N chessboard so that no two Queens threaten each other.

    //Assumptions
    //N > 0
    //Return
    //A list of ways of putting the N Queens
    //Each way is represented by a list of the Queen's y index for x indices of 0 to (N - 1)

    //Example
    //N = 4, there are two ways of putting 4 queens:
    //[1, 3, 0, 2] --> the Queen on the first row is at y index 1, the Queen on the second row is at y index 3,
    //the Queen on the third row is at y index 0 and the Queen on the fourth row is at y index 2.

    //[2, 0, 3, 1] --> the Queen on the first row is at y index 2, the Queen on the second row is at y index 0,
    //the Queen on the third row is at y index 3 and the Queen on the fourth row is at y index 1.

    //方法一：DFS
    //how many levels? n levels each level represent possible position for 1 queen
    //how many branch? n branches, each branch represent in one level at most n possible position for 1 queen
    public List<List<Integer>> nqueens(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        if (n == 0) {
            return ans;
        }
        List<Integer> cur = new ArrayList<>();
        helper(ans, cur, 0, n);
        return ans;
    }

    private void helper(List<List<Integer>> ans, List<Integer> cur, int level, int n) {
        if (level == n) {
            ans.add(new ArrayList<>(cur));
        }
        for (int i = 0; i < n; i++) {
            if (valid(cur, level, i)) {
                cur.add(i);
                helper(ans, cur, level + 1, n);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private boolean valid(List<Integer> cur, int level, int col) {
        for (int i = 0; i < level; i++) {
            if (cur.get(i) == col || Math.abs(col - cur.get(i)) == level - i) {
                //因为如果当前queen的位置与之前的queen在一个斜对角上，必定是等腰三角形，因此row差（height） = col差（width）
                return false;
            }
        }
        return true;
    }




}
