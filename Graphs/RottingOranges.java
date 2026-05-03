
import java.util.LinkedList;
import java.util.Queue;

class RottingOranges {
    public class Triplet {
        int i, j, time;

        Triplet(int i, int j, int time) {
            this.i = i;
            this.j = j;
            this.time = time;
        }
    }

    public int orangesRotting(int[][] grid) {
        Queue<Triplet> q = new LinkedList<>();
        int n = grid.length;
        int m = grid.length;
        int maxTime = Integer.MIN_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Triplet(i, j, 0));
                }
            }
        }

        while (!q.isEmpty()) {
            Triplet front = q.remove();
            int row = front.i;
            int col = front.j;
            int time = front.time;
            maxTime = Math.max(time, maxTime);
            // Up
            if (row - 1 >= 0) {
                if (grid[row - 1][col] == 1) {
                    q.add(new Triplet(
                            row - 1,
                            col,
                            time + 1));
                    grid[row - 1][col] = 2;
                }
            }
            // Down
            if (row + 1 < n) {
                if (grid[row + 1][col] == 1) {
                    q.add(new Triplet(
                            row + 1,
                            col, time + 1));
                    grid[row + 1][col] = 2;
                }
            }
            // Left
            if (col - 1 >= 0) {
                if (grid[row][col - 1] == 1) {
                    q.add(new Triplet(
                            row,
                            col - 1,
                            time + 1));
                    grid[row][col - 1] = 2;
                }
            }
            // Right
            if (col + 1 < m) {
                if (grid[row][col + 1] == 1) {
                    q.add(new Triplet(
                            row,
                            col + 1,
                            time + 1));
                    grid[row][col + 1] = 2;
                }
            }
        }

        if (maxTime==Integer.MIN_VALUE) {
            return 0;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j]==1) {
                    return -1;
                }
            }
        }

        return maxTime;
    }
}