package binarySearch;

public class SearchInSortedMatrixI_267 {
    //1 2 3
    //4 5 6
    //=> 1 2 3 4 5 6
    //n m
    //0 ~ n * m - 1
    public int[] search(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int left = 0;
        int right = n * m - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midrow = mid / m;
            int midcol = mid % m;
            if (matrix[midrow][midcol] == target) {
                return new int[]{midrow, midcol};
            } else if (matrix[midrow][midcol] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return new int[] {-1, -1};
    }
}
