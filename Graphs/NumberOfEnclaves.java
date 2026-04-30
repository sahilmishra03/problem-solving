package Graphs;

import java.util.LinkedList;
import java.util.Queue;

class NumberOfEnclaves {
    public class Pair {
        int i, j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int numEnclaves(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1 && grid[i][j]==1) {
                    q.add(new Pair(i, j));
                }
            }
        }

        while (!q.isEmpty()) {
            Pair front = q.remove();
            grid[front.i][front.j] = -1;
            int row = front.i;
            int col = front.j;
            // Up
            if (row - 1 >= 0) {
                if (grid[row - 1][col] == 1) {
                    q.add(new Pair(
                            row - 1,
                            col));
                    grid[row - 1][col] = -1;
                }
            }
            // Down
            if (row + 1 < n) {
                if (grid[row + 1][col] == 1) {
                    q.add(new Pair(
                            row + 1,
                            col));
                    grid[row + 1][col] = -1;
                }
            }
            // Left
            if (col - 1 >= 0) {
                if (grid[row][col - 1] == 1) {
                    q.add(new Pair(
                            row,
                            col - 1));
                    grid[row][col - 1] = -1;
                }
            }
            // Right
            if (col + 1 < m) {
                if (grid[row][col + 1] == 1) {
                    q.add(new Pair(
                            row,
                            col + 1));
                    grid[row][col + 1] = -1;
                }
            }
        }
        int count = 0;
        for (int j = 0; j < n; j++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (grid[j][j2] == 1) {
                    count++;
                }
            }
        }

        return count;
    }
}
