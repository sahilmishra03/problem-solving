import java.util.PriorityQueue;

class Solution {
    class Triplet {
        int i, j, efforts;

        Triplet(int i, int j, int efforts) {
            this.i = i;
            this.j = j;
            this.efforts = efforts;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        PriorityQueue<Triplet> pq = new PriorityQueue<>((a, b) -> a.efforts - b.efforts);
        int[][] res = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = Integer.MAX_VALUE;
            }
        }
        pq.add(new Triplet(0, 0, 0));

        while (!pq.isEmpty()) {
            Triplet front = pq.remove();

            // Up
            if (front.i - 1 >= 0) {
                int cal = Math.abs(heights[front.i - 1][front.j] - heights[front.i][front.j]);
                int maxEfforts = Math.max(front.efforts, cal);

                if (res[front.i - 1][front.j] > maxEfforts) {
                    res[front.i - 1][front.j] = maxEfforts;
                    pq.add(new Triplet(front.i - 1, front.j, maxEfforts));
                }
            }
            // Down
            if (front.i + 1 < n) {
                int cal = Math.abs(heights[front.i + 1][front.j] - heights[front.i][front.j]);
                int maxEfforts = Math.max(front.efforts, cal);

                if (res[front.i + 1][front.j] > maxEfforts) {
                    res[front.i + 1][front.j] = maxEfforts;
                    pq.add(new Triplet(front.i + 1, front.j, maxEfforts));
                }
            }
            // Left
            if (front.j - 1 >= 0) {
                int cal = Math.abs(heights[front.i][front.j - 1] - heights[front.i][front.j]);
                int maxEfforts = Math.max(front.efforts, cal);

                if (res[front.i][front.j - 1] > maxEfforts) {
                    res[front.i][front.j - 1] = maxEfforts;
                    pq.add(new Triplet(front.i, front.j - 1, maxEfforts));
                }
            }
            // Right
            if (front.j + 1 < m) {
                int cal = Math.abs(heights[front.i][front.j + 1] - heights[front.i][front.j]);
                int maxEfforts = Math.max(front.efforts, cal);

                if (res[front.i][front.j + 1] > maxEfforts) {
                    res[front.i][front.j + 1] = maxEfforts;
                    pq.add(new Triplet(front.i, front.j + 1, maxEfforts));
                }
            }
        }

        return res[n-1][m-1];
    }
}