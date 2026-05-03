
import java.util.LinkedList;
import java.util.Queue;

class _1020_Number_of_Enclaves {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 || j == 0 || i == n - 1 || j == m - 1) && grid[i][j] == 1) {
                    bfs(i, j, grid, n, m);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    private void bfs(int i, int j, int[][] temp, int n, int m) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { i, j });
        temp[i][j] = 'T';
        while (!q.isEmpty()) {
            int[] front = q.remove();
            int row = front[0];
            int col = front[1];
            // Up
            if (row - 1 >= 0) {
                if (temp[row - 1][col] == 1) {
                    q.add(new int[] {
                            row - 1,
                            col
                    });
                    temp[row - 1][col] = 0;
                }
            }
            // Down
            if (row + 1 < n) {
                if (temp[row + 1][col] == 1) {
                    q.add(new int[] {
                            row + 1,
                            col
                    });
                    temp[row + 1][col] = 0;
                }
            }
            // Left
            if (col - 1 >= 0) {
                if (temp[row][col - 1] == 1) {
                    q.add(new int[] {
                            row,
                            col - 1
                    });
                    temp[row][col - 1] = 0;
                }
            }
            // Right
            if (col + 1 < m) {
                if (temp[row][col + 1] == 1) {
                    q.add(new int[] {
                            row,
                            col + 1
                    });
                    temp[row][col + 1] = 0;
                }
            }
        }
    }
}