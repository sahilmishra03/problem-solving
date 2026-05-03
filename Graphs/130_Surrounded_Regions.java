
import java.util.LinkedList;
import java.util.Queue;

class _130_Surrounded_Regions {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 || j == 0 || i == n - 1 || j == m - 1)&&board[i][j]=='O') {
                    bfs(i, j, board, n, m);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void bfs(int i, int j, char[][] temp, int n, int m) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { i, j });
        temp[i][j] = 'T';
        while (!q.isEmpty()) {
            int[] front = q.remove();
            int row = front[0];
            int col = front[1];
            // Up
            if (row - 1 >= 0) {
                if (temp[row - 1][col] == 'O') {
                    q.add(new int[] {
                            row - 1,
                            col
                    });
                    temp[row - 1][col] = 'T';
                }
            }
            // Down
            if (row + 1 < n) {
                if (temp[row + 1][col] == 'O') {
                    q.add(new int[] {
                            row + 1,
                            col
                    });
                    temp[row + 1][col] = 'T';
                }
            }
            // Left
            if (col - 1 >= 0) {
                if (temp[row][col - 1] == 'O') {
                    q.add(new int[] {
                            row,
                            col - 1
                    });
                    temp[row][col - 1] = 'T';
                }
            }
            // Right
            if (col + 1 < m) {
                if (temp[row][col + 1] == 'O') {
                    q.add(new int[] {
                            row,
                            col + 1
                    });
                    temp[row][col + 1] = 'T';
                }
            }
        }
    }
}