public class StringAbbreviationMatching_292 {
    //Word “book” can be abbreviated to 4, b3, b2k, etc. Given a string and an abbreviation, return if the string matches the abbreviation.
    //
    //Assumptions:
    //
    //The original string only contains alphabetic characters.
    //Both input and pattern are not null.
    //Pattern would not contain invalid information like "a0a","0".
    //Examples:
    //
    //pattern “s11d” matches input “sophisticated” since “11” matches eleven chars “ophisticate”.
    public boolean match(String input, String pattern) {
        if(pattern.length() > input.length()) {
            return false;
        }
        return helper(input, pattern, 0, 0);
    }

    private boolean helper(String input, String pattern, int i, int j) {
        if (i >= input.length() || j >= pattern.length()) {
            if(i == input.length() && j == pattern.length()) {
                return true;
            }
            return false;
        }
        if (Character.isLetter(pattern.charAt(j))) {
            if(input.charAt(i) != pattern.charAt(j)) {
                return false;
            }
            return helper(input, pattern, i + 1, j + 1);
        } else {
            int count = pattern.charAt(j++) - '0';
            while (j < pattern.length() && Character.isDigit(pattern.charAt(j))) {
                count = count * 10 + (pattern.charAt(j++) - '0');
            }
            return helper(input, pattern, i + count, j);
        }
    }
}
