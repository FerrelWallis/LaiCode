import java.util.ArrayList;
import java.util.List;

public class SpiralOrderTraverseII_122 {
    //Traverse an M * N 2D array in spiral order clock-wise starting from the top left corner.
    //Return the list of traversal sequence.

    //Assumptions
    //The 2D array is not null and has size of M * N where M, N >= 0
    //Examples
    //
    //{ {1,  2,  3,  4},
    //  {5,  6,  7,  8},
    //  {9, 10, 11, 12} }
    //
    //the traversal sequence is [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]

    public List<Integer> spiral(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int left = 0;
        int right = matrix[0].length - 1;
        int up = 0;
        int down = matrix.length - 1;
        while (right - left > 0 && down - up > 0) {
            for (int i = left; i < right; i++) {
                ans.add(matrix[up][i]);
            }
            for (int i = up; i < down; i++) {
                ans.add(matrix[i][right]);
            }
            for (int i = right; i > left; i--) {
                ans.add(matrix[down][i]);
            }
            for (int i = down; i > up; i--) {
                ans.add(matrix[i][left]);
            }
            left++;
            right--;
            up++;
            down--;
        }
        //有3种情况：1.没有剩余 2. 剩余one row 3. 剩余one col
        if (right == left) { //col
            for (int i = up; i <= down; i++) {
                ans.add(matrix[i][left]);
            }
        } else if (up == down) { //row
            for (int i = left; i <= right; i++) {
                ans.add(matrix[up][i]);
            }
        }
        return ans;
    }

}
