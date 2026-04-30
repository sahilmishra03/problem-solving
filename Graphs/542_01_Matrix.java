package Graphs;

import java.util.LinkedList;
import java.util.Queue;

class _542_01_Matrix {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] res = new int[n][m];
        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    res[i][j] = 0;
                    vis[i][j] = true;
                    q.add(new int[] { i, j, 0 });
                }
            }
        }

        while (!q.isEmpty()) {
            int[] front = q.remove();
            int row = front[0];
            int col = front[1];
            int weight = front[2];

            // Up
            if (row - 1 >= 0) {
                if (mat[row - 1][col] == 1 && !vis[row - 1][col]) {
                    res[row - 1][col] = weight + 1;
                    q.add(new int[] {
                            row - 1,
                            col,
                            weight + 1
                    });

                    vis[row - 1][col] = true;
                }
            }
            // Down
            if (row + 1 < n) {
                if (mat[row + 1][col] == 1 && !vis[row + 1][col]) {
                    res[row + 1][col] = weight + 1;
                    q.add(new int[] {
                            row + 1,
                            col,
                            weight + 1
                    });

                    vis[row + 1][col] = true;
                }
            }
            // Left
            if (col - 1 < n) {
                if (mat[row][col - 1] == 1 && !vis[row][col - 1]) {
                    res[row][col - 1] = weight + 1;
                    q.add(new int[] {
                            row,
                            col - 1,
                            weight + 1
                    });

                    vis[row][col - 1] = true;
                }
            }
            // Right
            if (col + 1 < n) {
                if (mat[row][col + 1] == 1 && !vis[row][col + 1]) {
                    res[row][col + 1] = weight + 1;
                    q.add(new int[] {
                            row,
                            col + 1,
                            weight + 1
                    });

                    vis[row][col + 1] = true;
                }
            }
        }

        return res;
    }
}