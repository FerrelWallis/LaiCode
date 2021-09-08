public class SearchInSortedMatrixI_267 {

    public static void main(String[] args) {
        int[][] m = new int[][]{{1,2,3,4,5,6},{8,9,10,13,15,17},{19,22,25,26,28,30}};
        SearchInSortedMatrixI_267 test = new SearchInSortedMatrixI_267();
        int[] re = test.search2(m, 26);
        System.out.println(re[0]+" "+re[1]);
    }

    public int[] search2(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length; // n行 m列
        int left = 0, right = n - 1;
        while(left < right - 1) {
            int mid = left + (right - left) / 2;
            if(matrix[mid][0] == target) {
                return new int[]{mid, 0};
            } else if(matrix[mid][0] < target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        int row;
        if(matrix[right][0] > target) row = left;
        else row = right;
        System.out.println(row);
        left = 0;
        right = m - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(matrix[row][mid] == target) {
                return new int[]{row, mid};
            } else if(matrix[row][mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }

    public int[] search(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length; //n是行，m是列
        int left = 0, right = n * m - 1; //转成一维时的index
        while(left <= right) {
            int mid = left + (right - left) / 2; //一维时的mid
            int row = mid / m, col = mid % m;  //将一维的mid转成二维对应的row & col
            if(matrix[row][col] == target) {
                return new int[]{row,col};
            } else if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[]{-1,-1};
    }



}
