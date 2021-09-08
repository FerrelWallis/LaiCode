public class EditDistance_100 {
    //Given two strings of alphanumeric characters, determine the minimum number of Replace,
    //Delete, and Insert operations needed to transform one string into the other.

    //Assumptions
    //Both strings are not null

    //Examples
    //string one: “sigh”, string two : “asith”

    //the edit distance between one and two is 2 (one insert “a” at front then replace “g” with “t”).

    //s1 = "asdf"  s2 = "sghjg"  M[4][5]
    //M[4][5] = case 1(replace): 1 + M[3][4]  "asdg" "sghjg" -->  "asd" "sghj"
    //          case 2(delete): 1 + M[3][5]   "asd" "sghjg"
    //          case 3(insert): 1 + M[4][4]   "asdfg" "sghjg" --> "asdf" "sghj"
    //M[4][5] = min(case 1, case 2, case 3)
    //base case: len of s1 == i   M[i][0] = i  第一行第一列
    //           len of s2 == j   M[0][j] = j
    //           M[0][0] = 0
    //induction rule: M[i][j] = min(M[i - 1][j] + 1,  delete
    //                              M[i][j - 1] + 1,  insert
    //                              if(s1.charAt(i - 1) == s2.charAt(j - 1)) M[i - 1][j - 1] else M[i - 1][j - 1] + 1)  replace
    public int editDistance(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] edit = new int[n + 1][m + 1];
        edit[0][0] = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0) {
                    edit[i][j] = j;
                } else if (j == 0) {
                    edit[i][j] = i;
                } else {
                    int replace = s1.charAt(i - 1) == s2.charAt(j - 1) ? edit[i - 1][j - 1] : edit[i - 1][j - 1] + 1;
                    int delete = edit[i - 1][j] + 1;
                    int insert = edit[i][j - 1] + 1;
                    edit[i][j] = Math.min(Math.min(replace, delete), insert);
                }
            }
        }
        return edit[n][m];
    }
}
