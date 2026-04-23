import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public class Triplet {
        int i, j, dis;

        Triplet(int i, int j, int dis) {
            this.i = i;
            this.j = j;
            this.dis = dis;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] vis = new boolean[n][m];
        int[][] dis = new int[n][m];

        Queue<Triplet> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    q.add(new Triplet(i, j, 0));
                    vis[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            Triplet front = q.remove();
            int row = front.i;
            int col = front.j;
            int distance = front.dis;
            dis[row][col] = distance;

            // Up
            if (row - 1 >= 0) {
                if (mat[row - 1][col] == 1 && vis[row - 1][col] == false) {
                    q.add(new Triplet(row - 1, col, distance + 1));
                    vis[row - 1][col] = true;
                }
            }
            // Down
            if (row + 1 < n) {
                if (mat[row + 1][col] == 1 && vis[row + 1][col] == false) {
                    q.add(new Triplet(row + 1, col, distance + 1));
                    vis[row + 1][col] = true;
                }
            }
            // Left
            if (col - 1 >= 0) {
                if (mat[row][col - 1] == 1 && vis[row][col - 1] == false) {
                    q.add(new Triplet(row, col - 1, distance + 1));
                    vis[row][col - 1] = true;
                }
            }
            // Right
            if (col + 1 < m) {
                if (mat[row][col + 1] == 1 && vis[row][col + 1] == false) {
                    q.add(new Triplet(row, col + 1, distance + 1));
                    vis[row][col + 1] = true;
                }
            }
        }

        return dis;
    }
}