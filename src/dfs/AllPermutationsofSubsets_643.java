package dfs;

import java.util.ArrayList;
import java.util.List;

public class AllPermutationsofSubsets_643 {

    //Given a string with no duplicate characters, return a list with all permutations of the string and all its subsets.
    //Examples
    //Set = “abc”, all permutations are [“”, “a”, “ab”, “abc”, “ac”, “acb”, “b”, “ba”, “bac”, “bc”, “bca”,
    //                                  “c”, “cb”, “cba”, “ca”, “cab”].
    //Set = “”, all permutations are [“”].
    //Set = null, all permutations are [].

    //permutation dfs swap-swap
    //how many levels? n levels n is the number of characters in the input
    //how many branches? the number of letters which haven't been used
    public List<String> allPermutationsOfSubsets(String input) {
        List<String> ans = new ArrayList<>();
        if (input == null) {
            return ans;
        }
        char[] in = input.toCharArray();
        dfs(ans, in, 0);
        return ans;
    }

    public void dfs(List<String> ans, char[] in, int index) {
        ans.add(new String(in, 0, index));
        for (int i = index; i < in.length; i++) {
            swap(in, index, i);
            dfs(ans, in, index + 1);
            swap(in, index, i);
        }
    }

    private void swap(char[] in, int i, int j) {
        char temp = in[i];
        in[i] = in[j];
        in[j] = temp;
    }


}
