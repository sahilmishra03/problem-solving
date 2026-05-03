
import java.util.LinkedList;
import java.util.Queue;

class NumberOfClosedIslands {
    public int closedIsland(int[][] grid) {
        int[][] temp = grid;
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 || j == 0 || i == n - 1 || j == m - 1) && temp[i][j] == 0) {
                    bfs1(i, j, temp, n, m);
                }
            }
        }
        int count = 0;
        boolean[][] vis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (temp[i][j] == 0 && vis[i][j]==false) {
                    bfs2(i, j, vis, temp, n, m);
                    count++;
                }
            }
        }

        return count;
    }

    private void bfs1(int i, int j, int[][] temp, int n, int m) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {
                i, j
        });

        temp[i][j] = -1;
        while (!q.isEmpty()) {
            int[] front = q.remove();
            int u = front[0];
            int v = front[1];
            // Up
            if (u - 1 >= 0) {
                if (temp[u - 1][v] == 0) {
                    q.add(new int[] {
                            u - 1, v
                    });

                    temp[u - 1][v] = -1;
                }
            }
            // Down
            if (u + 1 < n) {
                if (temp[u + 1][v] == 0) {
                    q.add(new int[] {
                            u + 1, v
                    });

                    temp[u + 1][v] = -1;
                }
            }
            // Left
            if (v - 1 >= 0) {
                if (temp[u][v - 1] == 0) {
                    q.add(new int[] {
                            u, v - 1
                    });

                    temp[u][v - 1] = -1;
                }
            }
            // Right
            if (v + 1 < m) {
                if (temp[u][v + 1] == 0) {
                    q.add(new int[] {
                            u, v + 1
                    });

                    temp[u][v + 1] = -1;
                }
            }
        }
    }

    private void bfs2(int i, int j, boolean[][] vis, int[][] temp, int n, int m) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {
                i, j
        });

        vis[i][j] = true;

        while (!q.isEmpty()) {
            int[] front = q.remove();
            int u = front[0];
            int v = front[1];
            // Up
            if (u - 1 >= 0) {
                if (temp[u - 1][v] == 0 && vis[u - 1][v] == false) {
                    q.add(new int[] {
                            u - 1, v
                    });

                    vis[u - 1][v] = true;
                }
            }
            // Down
            if (u + 1 < n) {
                if (temp[u + 1][v] == 0 && vis[u + 1][v] == false) {
                    q.add(new int[] {
                            u + 1, v
                    });

                    vis[u + 1][v] = true;
                }
            }
            // Left
            if (v - 1 >= 0) {
                if (temp[u][v - 1] == 0 && vis[u][v - 1] == false) {
                    q.add(new int[] {
                            u, v - 1
                    });

                    vis[u][v - 1] = true;
                }
            }
            // Right
            if (v + 1 < m) {
                if (temp[u][v + 1] == 0 && vis[u][v + 1] == false) {
                    q.add(new int[] {
                            u, v + 1
                    });

                    vis[u][v + 1] = true;
                }
            }
        }
    }
}