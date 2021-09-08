import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters_253 {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters_253 test = new LongestSubstringWithoutRepeatingCharacters_253();
        int a = test.longest("abbacbcd");
    }

    public int longest(String input) {
        if (input.length() == 0) {
            return 0;
        }
        HashSet<Character> visited = new HashSet<>();
        int globalMax = 0;
        int slow = 0;
        int len = 0;
        for (int fast = 0; fast < input.length(); fast++) {
            if (!visited.add(input.charAt(fast))) {
                while (visited.contains(input.charAt(fast))) {
                    visited.remove(input.charAt(slow++));
                    len--;
                }
                visited.add(input.charAt(fast));
            }
            len++;
            if (globalMax < len) {
                globalMax = len;
            }
        }
        return globalMax;
    }
}
