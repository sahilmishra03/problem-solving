package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearestCellHaving1 {
    public static class Douplet {
        int row;
        int col;

        Douplet(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        // code here
        int n = grid.length;
        int m = grid[0].length;
        int[][] ans = new int[n][m];
        Queue<Douplet> q = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    q.add(new Douplet(i, j));
                }
            }
        }

        while (!q.isEmpty()) {
            Douplet front = q.remove();
            int row = front.row;
            int col = front.col;

            // UP
            if (row - 1 >= 0 && grid[row - 1][col] == 0 && ans[row - 1][col] == 0) {
                grid[row - 1][col] = grid[row][col] + 1;
                q.add(new Douplet(row - 1, col));
            }

            // DOWN
            if (row + 1 < n && grid[row + 1][col] == 0 && ans[row + 1][col] == 0) {
                grid[row + 1][col] = grid[row][col] + 1;
                q.add(new Douplet(row + 1, col));
            }

            // LEFT
            if (col - 1 >= 0 && grid[row][col - 1] == 0 && ans[row][col - 1] == 0) {
                grid[row][col - 1] = grid[row][col] + 1;
                q.add(new Douplet(row, col - 1));
            }

            // RIGHT
            if (col + 1 < m && grid[row][col + 1] == 0 && ans[row][col + 1] == 0) {
                grid[row][col + 1] = grid[row][col] + 1;
                q.add(new Douplet(row, col + 1));
            }
        }

        ArrayList<ArrayList<Integer>> finalRes = new ArrayList<>();

        for (int i = 0; i < ans.length; i++) {
            ArrayList<Integer> ls = new ArrayList<>();
            for (int j = 0; j < ans[i].length; j++) {
                ls.add(ans[i][j]);
            }
            finalRes.add(ls);
        }

        return finalRes;
    }
}
