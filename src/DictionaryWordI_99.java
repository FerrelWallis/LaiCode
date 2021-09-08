import java.util.HashSet;

public class DictionaryWordI_99 {
    //Given a word and a dictionary, determine if it can be composed by concatenating words from the given dictionary.
    //
    //Assumptions
    //
    //The given word is not null and is not empty
    //The given dictionary is not null and is not empty and all the words in the dictionary are not null or empty
    //Examples
    //
    //Dictionary: {“bob”, “cat”, “rob”}
    //
    //Word: “robob” return false
    //
    //Word: “robcatbob” return true since it can be composed by "rob", "cat", "bob"

    //左大段，右小段思想
    //M[i] 表示 word长度为i的substring是否可由dict中的words concatenate组成
    //base case: M[0] = true
    //induction rule: M[i] case 1: M[0] && substring(0-i) 当前全部是否为dict中的word
    //                     case 2: M[1] && substring(1-i) 左大段是否满足条件 && 右小段是否在dict中
    //                     ...
    //                     case i: M[i - 1] && substring(i-1 - i)
    //                M[i] = case 1 || case 2 || ... || case i
    public boolean canBreak(String word, String[] dict) {
        boolean[] valid = new boolean[1 + word.length()];
        valid[0] = true;
        HashSet<String> dictSet = mkSet(dict);
        for (int i = 1; i <= valid.length; i++) {
            for (int j = 0; j < i; j++) {
                if (valid[j] && dictSet.contains(word.substring(j, i))) {
                    valid[i] = true;
                    break;
                }
            }
        }
        return valid[word.length()];
    }

    private HashSet<String> mkSet(String[] dict) {
        HashSet<String> dictSet = new HashSet<>();
        for (String w : dict) {
            dictSet.add(w);
        }
        return dictSet;
    }
}
