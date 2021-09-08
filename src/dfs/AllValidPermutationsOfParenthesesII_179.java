package dfs;

import java.util.*;

public class AllValidPermutationsOfParenthesesII_179 {
    //Get all valid permutations of l pairs of (), m pairs of <> and n pairs of {}.
    //
    //Assumptions
    //
    //l, m, n >= 0
    //l + m + n > 0
    //Examples
    //
    //l = 1, m = 1, n = 0, all the valid permutations are ["()<>", "(<>)", "<()>", "<>()"]

    //permutation dfs
    //levels? l + m + n levels
    //branches? 6
    //用一个stack记录前面left parentheses的状态
    //i 表示当前使用的是第几种括号
    //        若i%2 == 1 表示是右括号
    //                  看stack.peek是否为 i-1（这里不用判断right是否比left大，因为如果stack中还有left就说明，right数量小于left数量）,
    //                  不是跳过，是就放入sb
    //        若i%2 == 0 表示是左括号
    //                  看是否有剩余可用
    public List<String> validParentheses(int l, int m, int n) {
        char[] parenthese = new char[]{'(',')','<','>','{','}'};
        int[] pnum = new int[]{l, l, m, m, n, n};
        int levels = 2 * l + 2 * m + 2 * n;
        List<String> ans = new ArrayList<>();
        Deque<Integer> leftstack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        dfs(ans, leftstack, sb, parenthese, pnum, levels, 0);
        return ans;
    }

    private void dfs(List<String> ans, Deque<Integer> leftstack, StringBuilder sb, char[] parenthese, int[] pnum, int levels, int index) {
        if (index == levels) {
            ans.add(sb.toString());
            return;
        }
        for (int i = 0; i < 6; i++) {
            if (i % 2 == 0) { //left
                if (pnum[i] > 0) {
                    sb.append(parenthese[i]);
                    pnum[i]--;
                    leftstack.offerFirst(i);
                    dfs(ans, leftstack, sb, parenthese, pnum, levels, index + 1);
                    sb.deleteCharAt(sb.length() - 1);
                    pnum[i]++;
                    leftstack.pollFirst();
                }
            } else { //right
                if (!leftstack.isEmpty() && leftstack.peekFirst() == i - 1) {
                    sb.append(parenthese[i]);
                    leftstack.pollFirst();
                    pnum[i]--;
                    dfs(ans, leftstack, sb, parenthese, pnum, levels, index + 1);
                    sb.deleteCharAt(sb.length() - 1);
                    leftstack.offerFirst(i - 1);
                    pnum[i]++;
                }
            }
        }

    }

}

