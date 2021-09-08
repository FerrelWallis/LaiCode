import java.util.Set;

public class MaxProductOfCuttingRope_87 {
    //Given a rope with positive integer-length n, how to cut the rope into m integer-length parts with
    //length p[0], p[1], ...,p[m-1], in order to get the maximal product of p[0]*p[1]* ... *p[m-1]?
    //m is determined by you and must be greater than 0 (at least one cut must be made).
    //Return the max product you can have.

    //Assumptions
    //n >= 2

    //Examples
    //n = 12, the max product is 3 * 3 * 3 * 3 = 81(cut the rope into 4 pieces with length of each is 3).

    //左大段 右小段思想
    //M[i] 表示长度为i的rope 能切出的最大maxproduct
    //base case: M[0] = 0(invalid因为至少要切一刀)  M[1] = 0（invalid因为至少要切一刀）
    //induction rule：
    // 2 meter rope: case 1：—— | ——  左大段有一刀不切的情况和切割后的maxproduct max(1, M[1]) * 右小段1
    // 3 meter rope: case 1: —— | —— —— 左大段max(1, M[1]) * 右小段2
    //               case 2：—— —— | —— 左大段max(2,M[2]) * 右小段1
    public int maxProduct(int n) {
        int[] M = new int[n + 1];
        M[0] = 0;
        M[1] = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                M[i] = Math.max(M[i], Math.max(i - j, M[i - j]) * j);
            }
        }
        return M[n];
    }


    //变种题 given a word can it be composed by concatenating words from a given dictionary?
    //"bobcatrob"
    //base case: M[0] = true  M[1] = M[0] && "b"
    //induction rule：size = 2 "bo" case 1: M[1] && "o"
    //                              case 2: M[0] && "bo"
    //                          M[2] = case 1 || case 2
    //                size = 3 "bob" case 1: "bob"
    public boolean checkCompose(String input, Set<String> dict) {
        boolean[] valid = new boolean[input.length() + 1];
        valid[0] = true;
        for(int i = 1; i <= input.length(); i++) {
            for (int j = 0; j < i; j++) {
                valid[i] |= (valid[j] && dict.contains(input.substring(j,i)));
                if (valid[i]) {
                    break;
                }
            }
        }
        return valid[input.length()];
    }



}
