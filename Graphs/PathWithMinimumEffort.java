import java.util.PriorityQueue;

class Solution {
    public class Pair {
        int i, j, efforts;

        Pair(int i, int j, int efforts) {
            this.i = i;
            this.j = j;
            this.efforts = efforts;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                res[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> a.efforts - b.efforts);
        q.add(new Pair(0, 0, 0));
        res[0][0] = 0;

        while (!q.isEmpty()) {
            Pair front = q.remove();
            if (res[front.i][front.j] < front.efforts) {
                continue;
            }
            // Up
            if (front.i - 1 >= 0) {
                int efforts = Math.abs(heights[front.i][front.j] - heights[front.i - 1][front.j]);
                int maxEffort = Math.max(front.efforts, efforts);
                if (maxEffort < res[front.i - 1][front.j]) {
                    res[front.i - 1][front.j] = maxEffort;
                    q.add(new Pair(front.i - 1, front.j, maxEffort));
                }
            }
            // Down
            if (front.i + 1 < n) {
                int efforts = Math.abs(heights[front.i][front.j] - heights[front.i + 1][front.j]);
                int maxEffort = Math.max(front.efforts, efforts);
                if (maxEffort < res[front.i + 1][front.j]) {
                    res[front.i + 1][front.j] = maxEffort;
                    q.add(new Pair(front.i + 1, front.j, maxEffort));
                }
            }
            // Left
            if (front.j - 1 >= 0) {
                int efforts = Math.abs(heights[front.i][front.j] - heights[front.i][front.j - 1]);
                int maxEffort = Math.max(front.efforts, efforts);
                if (maxEffort < res[front.i][front.j - 1]) {
                    res[front.i][front.j - 1] = maxEffort;
                    q.add(new Pair(front.i, front.j - 1, maxEffort));
                }
            }
            // Right
            if (front.j + 1 < m) {
                int efforts = Math.abs(heights[front.i][front.j] - heights[front.i][front.j + 1]);
                int maxEffort = Math.max(front.efforts, efforts);
                if (maxEffort < res[front.i][front.j + 1]) {
                    res[front.i][front.j + 1] = maxEffort;
                    q.add(new Pair(front.i, front.j + 1, maxEffort));
                }
            }
        }

        return res[n - 1][m - 1];
    }
}