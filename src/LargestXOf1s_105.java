public class LargestXOf1s_105 {
    //Given a matrix that contains only 1s and 0s, find the largest X shape which contains only 1s,
    //with the same arm lengths and the four arms joining at the central point.
    //Return the arm length of the largest X shape.

    //Assumptions
    //The given matrix is not null, has size of N * M, N >= 0 and M >= 0.

    //Examples
    //{ {0, 0, 0, 0},
    //  {1, 1, 1, 1},
    //  {0, 1, 1, 1},
    //  {1, 0, 1, 1} }
    //the largest X of 1s has arm length 2.

    // n -> row m -> col
    //step 1: four direct preprocess
    //        base case: lefttop[0][j] = matrix[0][j] & lefttop[i][0] = matrix[i][0]
    //                   righttop[0][j] = matrix[0][j] & righttop[i][m - 1] = matrix[i][m - 1]
    //                   leftbot[n - 1][j] = matrix[n - 1][j] & leftbot[i][0] = matrix[i][0]
    //                   rightbot[n - 1][j] = matrix[n - 1][j] && rightbot[i][m - 1] = matrix[i][m - 1]
    //        Induction rule: if matrix[i][j] == 1  lefttop[i][j] = lefttop[i - 1][j - 1] + 1
    //                                              righttop[i][j] = righttop[i - 1][j + 1] + 1
    //                                              leftbot[i][j] = leftbot[i + 1][j - 1] + 1
    //                                              rightbot[i][j] = rightbot[i + 1][j + 1] + 1
    public int largest(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        if (n == 0) {
            return  0;
        }
        int[][] leftup = findLeftRightUp(matrix, n, m);
        int[][] rightdown = findLeftRightDown(matrix, n, m);
        return merge(leftup, rightdown, n, m);
    }

    private int merge(int[][] m1, int[][] m2, int n, int m) {
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                m1[i][j] = Math.min(m1[i][j], m2[i][j]);
                max = Math.max(max, m1[i][j]);
            }
        }
        return max;
    }

    private int[][] findLeftRightUp(int[][] matrix, int n, int m) {
        int[][] leftup = new int[n][m];
        int[][] rightup = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    leftup[i][j] = getNumber(leftup, i - 1, j - 1, n, m) + 1;
                    rightup[i][j] = getNumber(rightup, i - 1, j + 1, n, m) + 1;
                }
            }
        }
        merge(leftup, rightup, n, m);
        return leftup;
    }

    private int[][] findLeftRightDown(int[][] matrix, int n, int m) {
        int[][] leftdown = new int[n][m];
        int[][] rightdown = new int[n][m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                    leftdown[i][j] = getNumber(leftdown, i + 1, j - 1, n, m) + 1;
                    rightdown[i][j] = getNumber(rightdown, i + 1, j + 1, n, m) + 1;
                }
            }
        }
        merge(leftdown, rightdown, n, m);
        return leftdown;
    }

    private int getNumber(int[][] matrix, int i, int j, int n, int m) {
        if (i < 0 || j < 0 || i > n - 1 || j > m - 1) {
            return 0;
        } else {
            return matrix[i][j];
        }
    }

}
