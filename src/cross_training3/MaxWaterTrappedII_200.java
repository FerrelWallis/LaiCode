package cross_training3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MaxWaterTrappedII_200 {
    //Given a non-negative integer 2D array representing the heights of bars in a matrix.
    //Suppose each bar has length and width of 1. Find the largest amount of water that can be
    //trapped in the matrix. The water can flow into a neighboring bar if the neighboring bar's height
    //is smaller than the water's height. Each bar has 4 neighboring bars to the left, right, up and down side.

    //Assumptions: The given matrix is not null and has size of M * N, where M > 0 and N > 0,
    //all the values are non-negative integers in the matrix.

    //Examples
    //{ { 2, 3, 4, 2 },
    //  { 3, 1, 2, 3 },
    //  { 4, 3, 5, 4 } }

    //the amount of water can be trapped is 3,
    //at position (1, 1) there is 2 units of water trapped,
    //at position (1, 2) there is 1 unit of water trapped.
    public static void main(String[] args) {
        MaxWaterTrappedII_200 test = new MaxWaterTrappedII_200();
        test.maxTrapped(new int[][]{{5, 8, 7, 7}, {5, 2, 1, 5}, {7, 1, 7, 1}, {8, 9, 6, 9}, {9, 8, 9, 9}});
    }

    public int maxTrapped(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] visited = new boolean[n][m];
        PriorityQueue<Pair> minheap = new PriorityQueue<Pair>();
        loadBorder(minheap, visited, matrix);
        int sum = 0;
        while (!minheap.isEmpty()) {
            Pair cur = minheap.poll();
            List<Pair> neighbor = getNei(cur, matrix,  n, m);
            for (Pair nei : neighbor) {
                if (visited[nei.row][nei.col]) {
                    continue;
                }
                visited[nei.row][nei.col] = true;
                sum += Math.max(cur.value - nei.value, 0);
                nei.value = Math.max(cur.value, nei.value);
                minheap.offer(nei);
            }
        }
        return sum;
    }

    private List<Pair> getNei(Pair cur, int[][] matrix, int n, int m) {
        List<Pair> nei = new ArrayList<>();
        if (cur.row + 1 < n) {
            nei.add(new Pair(cur.row + 1, cur.col, matrix[cur.row + 1][cur.col]));
        }
        if (cur.row - 1 >= 0) {
            nei.add(new Pair(cur.row - 1, cur.col, matrix[cur.row - 1][cur.col]));
        }
        if (cur.col + 1 < m) {
            nei.add(new Pair(cur.row, cur.col + 1, matrix[cur.row][cur.col + 1]));
        }
        if (cur.col - 1 >= 0) {
            nei.add(new Pair(cur.row, cur.col - 1, matrix[cur.row][cur.col - 1]));
        }
        return nei;
    }

    private void loadBorder(PriorityQueue<Pair> minheap, boolean[][] visited, int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int r = 0; r < n; r++) {
            minheap.add(new Pair(r, 0, matrix[r][0]));
            minheap.add(new Pair(r, m - 1, matrix[r][m - 1]));
            visited[r][0] = true;
            visited[r][m - 1] = true;
        }
        for (int c = 0; c < m; c++) {
            minheap.add(new Pair(0, c, matrix[0][c]));
            minheap.add(new Pair(n - 1, c, matrix[n - 1][c]));
            visited[0][c] = true;
            visited[n - 1][c] = true;
        }
    }

    class Pair implements Comparator<Pair> {
        int row;
        int col;
        int value;

        public Pair(int r, int c, int v) {
            row = r;
            col = c;
            value = v;
        }

        @Override
        public int compare(Pair o1, Pair o2) {
            if (o1.value == o2.value) {
                return 0;
            }
            return o1.value < o2.value ? -1 : 1;
        }
    }

}
