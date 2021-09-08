import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SpiralOrderTraverseI_121 {
    //Traverse an N * N 2D array in spiral order clock-wise starting from the top left corner.
    //Return the list of traversal sequence.

    //Assumptions
    //The 2D array is not null and has size of N * N where N >= 0

    //Examples
    //{ {1,  2,  3},
    //  {4,  5,  6},
    //  {7,  8,  9} }
    //the traversal sequence is [1, 2, 3, 6, 9, 8, 7, 4, 5]

    public static void main(String[] args) {
        SpiralOrderTraverseI_121 test = new SpiralOrderTraverseI_121();
        int[][] matrix = new int[][]{{1,2,3},{8,9,4},{7,6,5}};
        List<Integer> ans = test.spiral(matrix);
    }

    //方法一：recursion
    public List<Integer> spiral2(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return ans;
        }
        helper(ans, matrix, 0, matrix.length);
        return ans;
    }

    private void helper(List<Integer> ans, int[][] matrix, int offset, int size) {
        //base case
        if (size <= 1) {
            if (size == 1) {
                ans.add(matrix[offset][offset]);
            }
            return;
        }
        //top
        for (int i = 0; i < size - 1; i++) {
            ans.add(matrix[offset][offset + i]);
        }
        for (int i = 0; i < size - 1; i++) {
            ans.add(matrix[offset + i][offset + size - 1]);
        }
        for (int i = size - 1; i > 0; i--) {
            ans.add(matrix[offset + size - 1][offset + i]);
        }
        for (int i = size - 1; i > 0; i--) {
            ans.add(matrix[offset + i][offset]);
        }
        helper(ans, matrix, offset + 1, size - 2);
    }

    //方法二：tail recursion -> iteration

    //expected:<[40, 33, 19, 28, 56, 55, 99, -15, 18, 96, 2, 54, 68, -34, 19, 30, -10, -10, -82, -13, 51, -38, -49, -19, -58, -47, 70, -78, 62, -85, 5, 75, -83, 59, -77, 60, -38, -90, 43, -21, -15, 62, -93, 4, -67, -24, 26, 10, -12, -24, -71, 35, 91, -25, -44, -61, -63, -81, -56, 88, 57, -4, -59, -96, 77, -17, -55, 88, -76, 4, -50, 14, 77, -99, 59, 98, -1, 56, -44, 93, -47]>
    // but was:<[40, 33, 19, 28, 56, 55, 99, -15, 18, 96, 2, 54, 68, -34, 19, 30, -10, -10, -82, -13, 51, -38, -49, -19, -58, -47, 70, -78, 62, -85, 5, 75, -83, 59, -77, 60, -38, -90, 43, -21, -15, 62, -93, 4, -67, -24, 26, 10, -12, -24, -71, 35, 91, -25, -44, -61, -63, -81, -56, 88, 57, -4, -59, -96, 77, -17, -55, 88, -76, 4, -50, 14, 77, -99, 59, 98, -1, 56, -44, 93]
    public List<Integer> spiral(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix.length == 0) {
            return ans;
        }
        int start = 0;
        int end = matrix.length - 1;
        while (start < end) {
            for (int i = start; i < end; i++) {
                ans.add(matrix[start][i]);
            }
            for (int i = start; i < end; i++) {
                ans.add(matrix[i][end]);
            }
            for (int i = end; i > start; i--) {
                ans.add(matrix[end][i]);
            }
            for (int i = end; i > start; i--) {
                ans.add(matrix[i][start]);
            }
            start++;
            end--;
        }
        if (start == end) {
            ans.add(matrix[start][start]);
        }
        return ans;
    }

}
