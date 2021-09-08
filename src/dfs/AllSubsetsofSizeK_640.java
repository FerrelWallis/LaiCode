package dfs;

import java.util.ArrayList;
import java.util.List;

public class AllSubsetsofSizeK_640 {
    //Given a set of characters represented by a String, return a list containing all subsets of the characters whose size is K.

    //Assumptions: There are no duplicate characters in the original set.

    //​Examples
    //Set = "abc", K = 2, all the subsets are [“ab”, “ac”, “bc”].
    //Set = "", K = 0, all the subsets are [""].
    //Set = "", K = 1, all the subsets are [].

    //permutation dfs
    //n levels n is the number of characters in the string
    public List<String> subSetsOfSizeK(String input, int k) {
        char[] in = input.toCharArray();
        List<String> ans = new ArrayList<>();
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
        dfs(ans, sb, in, index + 1, k);
        sb.deleteCharAt(sb.length() - 1);
        dfs(ans, sb, in, index + 1, k);
    }


}
