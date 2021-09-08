package dp;

public class MinimumCutsForPalindromes_143 {
    //Given a string, a partitioning of the string is a palindrome partitioning if every substring
    //of the partition is a palindrome. Determine the fewest cuts needed for a palindrome partitioning
    //of a given string.

    //Assumptions: The given string is not null
    //Examples: “a | babbbab | bab | aba” is a palindrome partitioning of “ababbbabbababa”.
    //The minimum number of cuts needed is 3.

    //左大段 右小段 a | babbab
    //dp[i] 表示长度为0~i的input最小切割数
    //base case dp[0] = 0  dp[1] = 0
    // "ab" case 1   a | b  b is palin  case1 = dp[1] + 1;   dp[2] = 1
    // "aba" case 1  a | ba bs isnot palin  case 1 = MAXIN
    //       case 2  ab | a  a is palin  case 2 = dp[2] + 1  dp[3] = MIN(case1, case2)

    public int minCuts(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        int[] dp = new int[input.length() + 1];
        //base case
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= input.length(); i++) { //dp 当前input长度
            int mincase = Integer.MAX_VALUE;
            if (ispalin(input.substring(0, i))) {
                mincase = 0;
            } else {
                for (int j = 1; j < i; j++) { //左大段长度
                    if (ispalin(input.substring(j, i))) {
                        mincase = Math.min(mincase, dp[j] + 1);
                    }
                }
            }
            dp[i] = mincase;
        }
        return dp[input.length()];
    }

    private boolean ispalin(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


}
