import java.util.*;
class Solution {
    class Triple {
        int x;
        int y;
        int effort;

        public Triple(int x, int y, int effort) {
            this.x = x;
            this.y = y;
            this.effort = effort;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int[][] res = new int[heights.length][heights[0].length];
        for(int i=0;i<res.length;i++) {
            for(int j=0;j<res[0].length;j++) {
                res[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Triple> pq = new PriorityQueue<>((a, b) -> a.effort - b.effort);
        pq.add(new Triple(0, 0, 0));
        res[0][0] = 0;

        while (!pq.isEmpty()) {
            Triple front = pq.poll();
            int x = front.x;
            int y = front.y;
            int effort = front.effort;
            if(res[x][y] < effort) {
                continue;
            }

            //Up
            if(x-1>=0){
                int newEffort = Math.max(effort, Math.abs(heights[x][y] - heights[x-1][y]));
                if(res[x-1][y] > newEffort) {
                    res[x-1][y] = newEffort;
                    pq.add(new Triple(x-1, y, newEffort));
                }
            }
            //Down
            if(x+1<heights.length){
                int newEffort = Math.max(effort, Math.abs(heights[x][y] - heights[x+1][y]));
                if(res[x+1][y] > newEffort) {
                    res[x+1][y] = newEffort;
                    pq.add(new Triple(x+1, y, newEffort));
                }
            }
            //Left
            if(y-1>=0){
                int newEffort = Math.max(effort, Math.abs(heights[x][y] - heights[x][y-1]));
                if(res[x][y-1] > newEffort) {
                    res[x][y-1] = newEffort;
                    pq.add(new Triple(x, y-1, newEffort));
                }
            }
            //Right
            if(y+1<heights[0].length){
                int newEffort = Math.max(effort, Math.abs(heights[x][y] - heights[x][y+1]));
                if(res[x][y+1] > newEffort) {
                    res[x][y+1] = newEffort;
                    pq.add(new Triple(x, y+1, newEffort));
                }
            }
        }
        return res[heights.length-1][heights[0].length-1];
    }
}