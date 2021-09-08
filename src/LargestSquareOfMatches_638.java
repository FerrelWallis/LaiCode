public class LargestSquareOfMatches_638 {
    //Determine the largest square surrounded by a bunch of matches (each match is either horizontal or vertical),
    //return the length of the largest square.

    //The input is a matrix of points. Each point has one of the following values:
    //0 - there is no match to its right or bottom.
    //1 - there is a match to its right.
    //2 - there is a match to its bottom.
    //3 - there is a match to its right, and a match to its bottom.

    //Assumptions
    //The given matrix is guaranteed to be of size M * N, where M, N >= 0

    //Examples
    //{{3, 1, 1, 3, 0, 1, 1, 0},
    // {2, 0, 0, 2, 0, 0, 0, 0},
    // {3, 1, 3, 0, 0, 0, 0, 0},
    // {2, 0, 2, 0, 0, 0, 0, 0},
    // {1, 1, 0, 0, 0, 0, 0, 0}}

    //This matrix represents the following bunch of matches:
    //The largest square has length of 2.

    //step 1: preprocess right & down O(n^2)
    //step 2: for for(枚举所有左上角,若为3 说明可以是左上角) {
    //                  for (枚举all possible edge k -> Math.min(right[i][j], down[i][j]) to 1) {
    //                              check right[i + k][j] >= k && check down[i][j + k] >= k then update max
    //                  }
    //        }

    public int largestSquareOfMatches(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        if (n == 0) {
            return 0;
        }
        //step1
        int[][] right = new int[n][m];
        int[][] down = new int[n][m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (matrix[i][j] == 1 || matrix[i][j] == 3) { // have right
                    right[i][j] = getPreNumber(right, i, j + 1, n, m) + 1;
                }
                if (matrix[i][j] == 2 || matrix[i][j] == 3) {
                    down[i][j] = getPreNumber(down, i + 1, j, n, m) + 1;
                }
            }
        }
        //step 2
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 3) {
                    for (int k = Math.min(right[i][j], down[i][j]); k > max; k--) {
                        if (right[i + k][j] >= k && down[i][j + k] >= k) {
                            max = k;
                        }
                    }
                }
            }
        }
        return max;
    }

    private int getPreNumber(int[][] matrix, int i, int j, int n, int m) {
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return 0;
        }
        return matrix[i][j];
    }
}
