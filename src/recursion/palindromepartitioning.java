package recursion;

import java.util.Arrays;

public class palindromepartitioning {
    //Given a string, a partitioning of the string is a palindrome partitioning if every partition is a palindrome.
    //
    //For example, “aba |b | bbabb |a| b| aba” is a palindrome partitioning of “ababbbabbababa”.
    //
    //Determine the fewest cuts needed for palindrome partitioning of a given string.
    //
    //For example,
    //
    //minimum 3 cuts are needed for “ababbbabbababa”. The three cuts are “a | babbbab | b | ababa”.
    //
    //If a string is palindrome, then minimum 0 cuts are needed.
    //
    //Return the minimum cuts.

    //dp 方法： cut 可以用左大段 右小段
    //eg : ababbbabbababa  int M[i] 表示长度为i的substring是否符合 palindrome partitioning的最小cut数量
    //base case: M[0] = 0 "" M[1] = 0 "a"
    // i = 2  "ab" M[2] = case 1 : M[0] && "ab" valid    M[i] = 1 + M[0]
    //                    case 2 : M[1] && "b" valid     M[i] = 1 + M[1]
    //      M[2] = Math.min(case1, case2)

    //time = O(n^3) space = O(n)
    public static void main(String[] args) {
        palindromepartitioning test = new palindromepartitioning();
        System.out.println(test.minCut("ababbbabbabab"));
    }

    public int minCut(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        int n = input.length();
        int[] M = new int[n + 1];
        M[0] = 0;
        M[1] = 0;
        for (int i = 2; i <= n; i++) { //length of substring
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) { //左大段长度
                if(checkPalindrome(input.substring(j, i))) {
                    min = Math.min(min, 1 + M[j]);
                }
            }
            M[i] = min;
        }
        return M[n];
    }

    public boolean checkPalindrome(String string) {
        int i = 0;
        int j = string.length() - 1;
        while (i < j) {
            if (string.charAt(i) != string.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
