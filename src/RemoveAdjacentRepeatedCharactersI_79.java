public class RemoveAdjacentRepeatedCharactersI_79 {
    //Remove adjacent, repeated characters in a given string, leaving only one character for each group of such characters.
    //
    //Assumptions
    //
    //Try to do it in place.
    //Examples
    //
    //“aaaabbbc” is transferred to “abc”
    //Corner Cases
    //
    //If the given string is null, returning null or an empty string are both valid.

    public String deDup(String input) {
        if (input == null || input.length() == 0) {
            return null;
        }
        char[] in = input.toCharArray();
        int slow = 1;
        for (int fast = 1; fast < in.length; fast++) {
            if (in[fast] != in[slow - 1]) {
                in[slow++] = in[fast];
            }
        }
        return new String(in, 0, slow);
    }

}
