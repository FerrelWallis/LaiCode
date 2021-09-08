import java.util.Arrays;
import java.util.HashSet;

public class RemoveCertainCharacters_395 {
    //Remove given characters in input string, the relative order of other characters should be remained.
    //Return the new string after deletion.
    //
    //Assumptions
    //
    //The given input string is not null.
    //The characters to be removed is given by another string, it is guaranteed to be not null.
    //Examples
    //
    //input = "abcd", t = "ab", delete all instances of 'a' and 'b', the result is "cd".

    //挡板思想 time O(m + n) space O(m + n)
    public String remove(String input, String del) {

        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < del.length(); i++) {
            set.add(del.charAt(i));
        }
        char[] in = input.toCharArray();
        int i = 0;
        for (int j = 0; j < in.length; j++) {
            if (!set.contains(in[j])) {
                in[i++] = in[j];
            }
        }
        return new String(in, 0, i);
    }




}
