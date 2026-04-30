package Graphs;

import java.util.LinkedList;
import java.util.Queue;

class SurroundedRegions {
    public void solve(char[][] board) {
        char[][] temp = board;
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 || j == 0 || i == n - 1 || j == m - 1) && temp[i][j] == 'O') {
                    // Border
                    bfs(i, j, temp, n, m);
                }
            }
        }

        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp.length; j++) {
                if (temp[i][j]=='O') {
                    temp[i][j]='X';
                }
            }
        }

        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp.length; j++) {
                if (temp[i][j]=='T') {
                    temp[i][j]='O';
                }
            }
        }
        board=temp;
    }

    private void bfs(int i, int j, char[][] temp, int n, int m) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {
                i, j
        });

        temp[i][j] = 'T';

        while (!q.isEmpty()) {
            int[] front = q.remove();
            int u = front[0];
            int v = front[1];
            // Up
            if (u - 1 >= 0) {
                if (temp[u - 1][v] == 'O') {
                    q.add(new int[] {
                            u - 1, v
                    });

                    temp[u - 1][v] = 'T';
                }
            }
            // Down
            if (u + 1 < n) {
                if (temp[u + 1][v] == 'O') {
                    q.add(new int[] {
                            u + 1, v
                    });

                    temp[u + 1][v] = 'T';
                }
            }
            // Left
            if (v - 1 >= 0) {
                if (temp[u][v - 1] == 'O') {
                    q.add(new int[] {
                            u, v - 1
                    });

                    temp[u][v - 1] = 'T';
                }
            }
            // Right
            if (v + 1 < m) {
                if (temp[u][v + 1] == 'O') {
                    q.add(new int[] {
                            u, v + 1
                    });

                    temp[u][v + 1] = 'T';
                }
            }
        }
    }
}