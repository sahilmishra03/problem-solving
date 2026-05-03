import java.util.PriorityQueue;

class Solution {
    class Triplet {
        int i, j, c;

        Triplet(int i, int j, int c) {
            this.i = i;
            this.j = j;
            this.c = c;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i = i + 1) {
            for (int j = 0; j < m; j = j + 1) {
                if (grid[i][j] == 0) {
                    res[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        PriorityQueue<Triplet> q = new PriorityQueue<>((a, b) -> a.c - b.c);
        if (grid[0][0] == 0) {
            q.add(new Triplet(0, 0, 1));
            res[0][0] = 1;
        }

        while (!q.isEmpty()) {
            Triplet front = q.remove();
            int row = front.i;
            int col = front.j;
            int cost = front.c;
            if (cost > res[row][col])
                continue;

            //Up
            if (row - 1 >= 0) {
                if (grid[row - 1][col] == 0) {
                    int cs = cost + 1;
                    if (res[row - 1][col] > cs) {
                        res[row - 1][col] = cs;
                        q.add(new Triplet(row - 1, col, cs));
                    }
                }
            }
            //Down
            if (row + 1 < n) {
                if (grid[row + 1][col] == 0) {
                    int cs = cost + 1;
                    if (res[row + 1][col] > cs) {
                        res[row + 1][col] = cs;
                        q.add(new Triplet(row + 1, col, cs));
                    }
                }
            }
            //Left
            if (col - 1 >= 0) {
                if (grid[row][col - 1] == 0) {
                    int cs = cost + 1;
                    if (res[row][col - 1] > cs) {
                        res[row][col - 1] = cs;
                        q.add(new Triplet(row, col - 1, cs));
                    }
                }
            }
            //Right
            if (col + 1 < m) {
                if (grid[row][col + 1] == 0) {
                    int cs = cost + 1;
                    if (res[row][col + 1] > cs) {
                        res[row][col + 1] = cs;
                        q.add(new Triplet(row, col + 1, cs));
                    }
                }
            }

            //Right-Up
            if (row - 1 >= 0 && col + 1 < m) {
                if (grid[row - 1][col + 1] == 0) {
                    int cs = cost + 1;
                    if (res[row - 1][col + 1] > cs) {
                        res[row - 1][col + 1] = cs;
                        q.add(new Triplet(row - 1, col + 1, cs));
                    }
                }
            }
            //Right-Down
            if (row + 1 < n && col + 1 < m) {
                if (grid[row + 1][col + 1] == 0) {
                    int cs = cost + 1;
                    if (res[row + 1][col + 1] > cs) {
                        res[row + 1][col + 1] = cs;
                        q.add(new Triplet(row + 1, col + 1, cs));
                    }
                }
            }
            //Left-Up
            if (row - 1 >= 0 && col - 1 >= 0) {
                if (grid[row - 1][col - 1] == 0) {
                    int cs = cost + 1;
                    if (res[row - 1][col - 1] > cs) {
                        res[row - 1][col - 1] = cs;
                        q.add(new Triplet(row - 1, col - 1, cs));
                    }
                }
            }
            //Left-Down
            if (row + 1 < n && col - 1 >= 0) {
                if (grid[row + 1][col - 1] == 0) {
                    int cs = cost + 1;
                    if (res[row + 1][col - 1] > cs) {
                        res[row + 1][col - 1] = cs;
                        q.add(new Triplet(row + 1, col - 1, cs));
                    }
                }
            }
        }

        if (res[n - 1][m - 1] == Integer.MAX_VALUE) {
            return -1;
        }

        return res[n - 1][m - 1];
    }
}