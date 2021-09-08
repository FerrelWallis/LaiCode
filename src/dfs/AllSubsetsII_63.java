package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSubsetsII_63 {
    //Given a set of characters represented by a String, return a list containing all subsets of the characters.
    //Notice that each subset returned will be sorted to remove the sequence.
    //Assumptions: There could be duplicate characters in the original set.

    //Examples
    //Set = "abc", all the subsets are ["", "a", "ab", "abc", "ac", "b", "bc", "c"]
    //Set = "abb", all the subsets are ["", "a", "ab", "abb", "b", "bb"]
    //Set = "abab", all the subsets are ["", "a", "aa","aab", "aabb", "ab","abb","b", "bb"]
    //Set = "", all the subsets are [""]
    //Set = null, all the subsets are []

    //how many levels? number of characters in the string
    //how many branches? 2
    //1. 因为subset要sorted，因此先将string sort
    //2. duplicate characters:如果决定不放某个元素，那么后面所有跟这个相同的元素都不放，确保这个index位置，仅可能出现一次该元素！！

    public static void main(String[] args) {
        AllSubsetsII_63 test = new AllSubsetsII_63();
        List<String> ans = test.subSets("abab");

        System.out.println(ans.toString());
    }

    public List<String> subSets(String input) {
        List<String> ans = new ArrayList<>();
        char[] in = input.toCharArray();
        Arrays.sort(in);
        StringBuilder sb = new StringBuilder();
        dfs(ans, in, sb, 0);
        return ans;
    }

    private void dfs(List<String> ans, char[] in, StringBuilder sb, int index) {
        if (index == in.length) {
            ans.add(sb.toString());
            return;
        }
        sb.append(in[index]);
        dfs(ans, in, sb, ++index);
        sb.deleteCharAt(sb.length() - 1);
        while (index < in.length && in[index] == in[index - 1]) {
            index++;
        }
        dfs(ans, in, sb, index);
    }

}
