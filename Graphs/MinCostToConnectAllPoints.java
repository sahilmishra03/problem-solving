import java.util.PriorityQueue;

class Solution {
    class Triplet {
        int node, parent, wt;

        Triplet(int node, int parent, int wt) {
            this.node = node;
            this.parent = parent;
            this.wt = wt;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<Triplet> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        boolean[] vis = new boolean[points.length];
        pq.add(new Triplet(0, -1, 0));
        int sum = 0;
        while (!pq.isEmpty()) {
            Triplet front = pq.poll();
            int node = front.node, parent = front.parent, wt = front.wt;
            if (vis[node] == true) {
                continue;
            }
            sum += front.wt;
            vis[node] = true;
            for (int i = 0; i < points.length; i++) {
                if (i == parent || i == node) {
                    continue;
                }
                if (vis[i] == true) {
                    continue;
                }

                int x1 = points[front.node][0], y1 = points[front.node][1],
                        x2 = points[i][0], y2 = points[i][1];

                int mDist = Math.abs(x1 - x2) + Math.abs(y1 - y2);

                pq.add(new Triplet(i,node,mDist));
            }
        }

        return sum;
    }
}