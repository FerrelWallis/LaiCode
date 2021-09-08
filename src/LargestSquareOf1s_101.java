public class LargestSquareOf1s_101 {
    //Determine the largest square of 1s in a binary matrix (a binary matrix only contains 0 and 1),
    //return the length of the largest square.
    //
    //Assumptions
    //
    //The given matrix is not null and guaranteed to be of size N * N, N >= 0
    //Examples
    //
    //{ {0, 0, 0, 0},
    //
    //  {1, 1, 1, 1},
    //
    //  {0, 1, 1, 1},
    //
    //  {1, 0, 1, 1}}
    //
    //the largest square of 1s has length of 2

    //base case: the first row M[0][j] & first col M[i][0] = matrix[0/i][j/0]
    //induction rule: M[i][j] = min(M[i][j - 1], M[i - 1][j], M[i - 1][j - 1]) + 1
    public int largest(int[][] matrix) {
        //corner case
        int n = matrix.length;
        if (n == 0) {
            return 0;
        }
        int max = 0;
        int[][] large = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    large[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 1) {
                    large[i][j] = Math.min(Math.min(large[i - 1][j], large[i][j - 1]), large[i - 1][j - 1]) + 1;
                }
                max = Math.max(max, large[i][j]);
            }
        }
        return max;
    }

}
