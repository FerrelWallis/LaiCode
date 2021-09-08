package dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class AllValidPermutationsOfParenthesesIII_642 {
    //Get all valid permutations of l pairs of (), m pairs of <> and n pairs of {},
    //subject to the priority restriction: {} higher than <> higher than ().

    //Assumptions: l, m, n >= 0
    //             l + m + n >= 0

    //Examples
    //    l = 1, m = 1, n = 0, all the valid permutations are ["()<>", "<()>", "<>()"].
    //    l = 2, m = 0, n = 1, all the valid permutations are [“()(){}”, “(){()}”, “(){}()”, “{()()}”, “{()}()”, “{}()()”].

    public List<String> validParenthesesIII(int l, int m, int n) {
        List<String> ans = new ArrayList<>();
        int levels = 2 * l + 2 * m + 2 * n;
        if (levels == 0) {
            return ans;
        }
        char[] parenthese = new char[]{'(',')','<','>','{','}'};
        int[] pnum = new int[]{l, l, m, m, n, n};
        Deque<Integer> leftstack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        dfs(ans, sb, leftstack, parenthese, pnum, levels, 0);
        return ans;
    }

    private void dfs(List<String> ans, StringBuilder sb, Deque<Integer> leftstack, char[] parenthese, int[] pnum, int levels, int index) {
        if (index == levels) {
            ans.add(sb.toString());
            return;
        }
        for (int i = 0; i < 6; i++) {
            if (i % 2 == 0) { // left
                if (pnum[i] > 0 && (leftstack.isEmpty() || leftstack.peek() > i)) {
                    sb.append(parenthese[i]);
                    leftstack.offerFirst(i);
                    pnum[i]--;
                    dfs(ans, sb, leftstack, parenthese, pnum, levels, index + 1);
                    sb.deleteCharAt(sb.length() - 1);
                    leftstack.pollFirst();
                    pnum[i]++;
                }
            } else { //right
                if (!leftstack.isEmpty() && leftstack.peek() == i - 1) {
                    sb.append(parenthese[i]);
                    leftstack.pollFirst();
                    pnum[i]--;
                    dfs(ans, sb, leftstack, parenthese, pnum, levels, index + 1);
                    sb.deleteCharAt(sb.length() - 1);
                    leftstack.offerFirst(i - 1);
                    pnum[i]++;
                }
            }
        }
    }


}
