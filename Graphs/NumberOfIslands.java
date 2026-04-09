import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int numIslands(char[][] grid) {
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        int count=0;
        for (int i = 0; i < vis.length; i++) {
            for (int j = 0; j < vis[i].length; j++) {
                if (vis[i][j] == false && grid[i][j] == '1') {
                    bfs(i, j, grid, vis);
                    count++;
                }
            }
        }

        return count;
    }

    private void bfs(int i, int j, char[][] grid, boolean[][] vis) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {
                i,
                j
        });

        vis[i][j] = true;

        while (!q.isEmpty()) {
            int[] front = q.remove();
            int row = front[0];
            int col = front[0];

            // Up
            if (row - 1 >= 0) {
                if (grid[row - 1][col] == '1' && vis[row - 1][col] == false) {
                    q.add(new int[] {
                            row - 1,
                            col
                    });

                    vis[row - 1][col] = true;
                }
            }

            // Down
            if (row + 1 < n) {
                if (grid[row + 1][col] == '1' && vis[row + 1][col] == false) {
                    q.add(new int[] {
                            row + 1,
                            col
                    });

                    vis[row + 1][col] = true;
                }
            }

            // Left
            if (col - 1 >= 0) {
                if (grid[row][col - 1] == '1' && vis[row][col - 1] == false) {
                    q.add(new int[] {
                            row,
                            col - 1
                    });

                    vis[row][col - 1] = true;
                }
            }

            // Right
            if (col + 1 < m) {
                if (grid[row][col + 1] == '1' && vis[row][col + 1] == false) {
                    q.add(new int[] {
                            row,
                            col + 1
                    });

                    vis[row][col + 1] = true;
                }
            }
        }
    }
}