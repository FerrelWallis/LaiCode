public class LargestSubMatrixSum_106 {
    //Given a matrix that contains integers, find the submatrix with the largest sum.
    //Return the sum of the submatrix.
    //
    //Assumptions
    //The given matrix is not null and has size of M * N, where M >= 1 and N >= 1

    //Examples
    //{ {1, -2, -1, 4},
    //  {1, -1,  1, 1},
    //  {0, -1, -1, 1},
    //  {0,  0,  1, 1} }
    //the largest submatrix sum is (-1) + 4 + 1 + 1 + (-1) + 1 + 1 + 1 = 7.

    //step1: preprocess拍扁区域 M[i][j] = sum(matrix[0...i][j])
    //step2: 1）枚举submatrix的top和bottom，获取sum[j] = M[bottom][j] - M[top][j] 表示该submatrix每一列的sum值
    //       2）将sum[0,j]作为largest subarray sum的input获取最大值
    public int largest(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        if (n == 0) {
            return 0;
        }
        //step 1
        int[][] sumprefix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sumprefix[i][j] = i == 0 ? matrix[i][j] : sumprefix[i - 1][j];
            }
        }
        //step 2
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int[] sum = new int[m];
                for (int t = 0; t < m; t++) {
                    sum[t] = sumprefix[j][t] - (i == 0 ? 0 : sumprefix[i - 1][t]);
                }
                max = Math.max(max, largestSubarraySum(sum));
            }
        }
        return max;
    }

    private int largestSubarraySum(int[] sum) {
        int max = sum[0];
        int pre = sum[0];
        for (int i = 1; i < sum.length; i++) {
            pre = pre < 0 ? sum[i] : pre + sum[i];
            max = Math.max(max, pre);
        }
        return max;
    }


}
