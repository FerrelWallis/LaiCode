public class RemoveAdjacentRepeatedCharactersIV_82 {
    //Repeatedly remove all adjacent, repeated characters in a given string from left to right.
    //
    //No adjacent characters should be identified in the final string.
    //
    //Examples
    //
    //"abbbaaccz" → "aaaccz" → "ccz" → "z"
    //"aabccdc" → "bccdc" → "bdc"

    public String deDup(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }
        char[] in = input.toCharArray();
        int slow = 1;
        for (int fast = 1; fast < in.length; fast++) {
            if (slow == 0 || in[fast] != in[slow - 1]) {
                in[slow++] = in[fast];
            } else {
                slow--;
                while (fast + 1 < in.length && in[fast] == in[fast + 1]) {
                    fast++;
                }
            }
        }
        return new String(in, 0, slow);
    }

}
