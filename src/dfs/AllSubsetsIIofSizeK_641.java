package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSubsetsIIofSizeK_641 {
    //Given a set of characters represented by a String, return a list containing all subsets of
    //the characters whose size is K. Notice that each subset returned will be sorted for deduplication.
    //Assumptions: There could be duplicate characters in the original set.

    //Examples
    //Set = "abc", K = 2, all the subsets are [“ab”, “ac”, “bc”].
    //Set = "abb", K = 2, all the subsets are [“ab”, “bb”].
    //Set = "abab", K = 2, all the subsets are [“aa”, “ab”, “bb”].
    //Set = "", K = 0, all the subsets are [""].
    //Set = "", K = 1, all the subsets are [].
    //Set = null, K = 0, all the subsets are [].

    //permutation dfs
    //level? n number of characters in the string
    //branches? 2 放或不放
    //如果该位置该元素决定不放的话，就该位置所有相同的元素都不放，避免重复

    public List<String> subSetsIIOfSizeK(String input, int k) {
        List<String> ans = new ArrayList<>();
        if (input == null) {
            return ans;
        }
        char[] in = input.toCharArray();
        Arrays.sort(in);
        StringBuilder sb = new StringBuilder();
        dfs(ans, sb, in, 0, k);
        return ans;
    }

    private void dfs(List<String> ans, StringBuilder sb, char[] in, int index, int k) {
        if (index == in.length || sb.length() == k) {
            if (sb.length() == k) {
                ans.add(sb.toString());
            }
            return;
        }
        sb.append(in[index]);
        dfs(ans, sb, in, ++index, k);
        sb.deleteCharAt(sb.length() - 1);
        while (index < in.length && in[index] == in[index - 1]) {
            index++;
        }
        dfs(ans, sb, in, index, k);
    }


}
