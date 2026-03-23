package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {
    public static class Douplet {
        int row;
        int col;

        Douplet(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        int[][] grid = 
            {{0, 0, 0, 1},
            {0, 1, 1, 0},
            {0, 1, 1, 0},
            {0, 0, 0, 1},
            {0, 1, 1, 0}};

        int res = numberOfEnclaves(grid);

        System.out.println(res);
    }

    public static int numberOfEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (j == 0 || i == 0 || j == m-1 || i == n-1) {
                    if (grid[i][j] == 1) {
                        grid[i][j] = -1;
                    }
                }
            }
        }

        Queue<Douplet> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == -1) {
                    q.add(new Douplet(i, j));
                }
            }
        }

        while (!q.isEmpty()) {
            Douplet front = q.remove();
            int row = front.row;
            int col = front.col;

            // UP
            if (row - 1 >= 0 && grid[row - 1][col] == 1) {
                grid[row - 1][col] = -1;
                q.add(new Douplet(row - 1, col));
            }

            // DOWN
            if (row + 1 < n && grid[row + 1][col] == 1) {
                grid[row + 1][col] = -1;
                q.add(new Douplet(row + 1, col));
            }

            // LEFT
            if (col - 1 >= 0 && grid[row][col - 1] == 1) {
                grid[row][col - 1] = -1;
                q.add(new Douplet(row, col - 1));
            }

            // RIGHT
            if (col + 1 < m && grid[row][col + 1] == 1) {
                grid[row][col + 1] = -1;
                q.add(new Douplet(row, col + 1));
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }
}