public class LargestSquareSurroundedByOne_637 {
    //Determine the largest square surrounded by 1s in a binary matrix (a binary matrix only contains 0 and 1),
    //return the length of the largest square.

    //Assumptions
    //The given matrix is guaranteed to be of size M * N, where M, N >= 0

    //Examples
    //{{1, 0, 1, 1, 1},
    // {1, 1, 1, 1, 1},
    // {1, 1, 0, 1, 0},
    // {1, 1, 1, 1, 1},
    // {1, 1, 1, 0, 0}}

    //The largest square surrounded by 1s has length of 3.

    //step 1: preprocess 获取每个点的right arm 和 down arm  int[][] right int[][] down (longest consecutive 1s)
    //step 2: for for loop make all element as the lefttop corner of a square {
    //                  for(all possible length of edge k -> min(right[i][j], down[i][j]) ~ 1) {
    //                          check the down arm of down[i][j + k - 1] >= k
    //                          &&
    //                          check the right arm of right[i + k - 1][j] >= k
    //                          then   max = Math.max(max, k);
    //                  }
    //        }
    public int largestSquareSurroundedByOne(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        if (n == 0) {
            return 0;
        }
        int[][] right = new int[n][m];
        int[][] down = new int[n][m];
        for (int i = n - 1; i >= 0; i--) {
            for(int j = m - 1; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                    right[i][j] = getPreNumber(right, i, j + 1, n, m) + 1;
                    down[i][j] = getPreNumber(down, i + 1, j, n, m) + 1;
                }
            }
        }
        //step2
        int max = 0;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j++) {
                for (int k = Math.min(right[i][j], down[i][j]); k > max; k--) {
                    if (right[i + k - 1][j] >= k && down[i][j + k - 1] >= k) {
                        max = k;
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
