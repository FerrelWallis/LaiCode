public class LongestCrossOf1s_104 {
    //Given a matrix that contains only 1s and 0s, find the largest cross which contains only 1s,
    //with the same arm lengths and the four arms joining at the central point.
    //Return the arm length of the largest cross.

    //Assumptions
    //The given matrix is not null, has size of N * M, N >= 0 and M >= 0.

    //Examples
    //{ {0, 0, 0, 0},
    //  {1, 1, 1, 1},
    //  {0, 1, 1, 1},
    //  {1, 0, 1, 1} }
    //the largest cross of 1s has arm length 2.

    //看十字的关键在于中心点向四个方向延申的min，需要枚举中心点
    //对每个中心点，作四个方向的longest consecutive 1s
    //Step 1: preprocess：get the arm lengths in the 4 direction of every intersection.   O(4 * m * n)
    //      Base Case: row -> n col -> m
    //           right arm -> M1[i][0] = matrix[i][0]
    //           left arm -> M2[m - 1][0] = matrix[m - 1][0]
    //           bottom arm -> M3[0][j] = matrix[0][j]
    //           top arm -> M4[n - 1][0] = matrix[n - 1][0]
    //      Induction rule：right -> M1[i][j] = M1[i][j - 1] + 1 (if matrix[i][j] == 1) else M1[i][j] = 0
    //                      left -> M2[i][j] = M2[i][j + 1] + 1 (if matrix[i][j] == 1) else M2[i][j] = 0
    //                      bottom -> M3[i][j] = M3[i - 1][j] + 1 (if matrix[i][j] == 1) else M3[i][j] = 0
    //                      up -> M4[i][j] = M4[i + 1][j] + 1 (if matrix[i][j] == 1) else M4[i][j] = 0
    //Step 2: get the min arm length in the 4 dicrection of every intersection.    O(m * n)

    //total time = O(m * n) space = O(m * n)

    public static void main(String[] args) {
        int[][] ma = new int[][]{{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,1,0,0}};
        LongestCrossOf1s_104 test = new LongestCrossOf1s_104();
        test.largest(ma);
    }

    public int largest(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        if (n == 0) {
            return 0;
        }
        int[][] right = new int[n][m];
        int[][] left = new int[n][m];
        int[][] bottom = new int[n][m];
        int[][] up = new int[n][m];
        //step 1: preprocess
        //left -> right
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    right[i][j] = matrix[i][j];
                } else {
                    right[i][j] = matrix[i][j] == 0 ? 0 : right[i][j - 1] + 1;
                }
            }
        }
        //right -> left
        for (int i = 0; i < n; i++) {
            for (int j = m - 1; j >= 0; j--) {
                if (j == m - 1) {
                    left[i][j] = matrix[i][j];
                } else {
                    left[i][j] = matrix[i][j] == 0 ? 0 : right[i][j + 1] + 1;
                }
            }
        }
        //top -> bottom
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0) {
                    bottom[i][j] = matrix[i][j];
                } else {
                    bottom[i][j] = matrix[i][j] == 0 ? 0 : bottom[i - 1][j] + 1;
                }
            }
        }
        //bottom -> top
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                if (i == n - 1) {
                    up[i][j] = matrix[i][j];
                } else {
                    up[i][j] = matrix[i][j] == 0 ? 0 : up[i + 1][j] + 1;
                }
            }
        }
        int max = 0;
        //Step 2: find min arm in the 4 dirct of all intersection
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int minarm = Math.min(right[i][j], Math.min(left[i][j], Math.min(bottom[i][j], up[i][j])));
                max = Math.max(max, minarm);
            }
        }
        return max;
    }

}
