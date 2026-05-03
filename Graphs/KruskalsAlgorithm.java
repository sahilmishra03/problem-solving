
import java.util.PriorityQueue;

class KruskalsAlgorithm {
    public class Edge {
        int u, v, wt;

        Edge(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }

    int parent[];
    int size[];

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int x1 = points[i][0], y1 = points[i][1],
                        x2 = points[j][0], y2 = points[j][1];

                int wt = Math.abs(x1 - x2) + Math.abs(y2 - y1);

                pq.add(new Edge(i, j, wt));
            }
        }
        int minCost = 0;
        while (!pq.isEmpty()) {
            Edge front = pq.remove();
            if (find(front.u) != find(front.v)) {
                minCost += front.wt;
                union(front.u, front.v);
            }
        }

        return minCost;
    }

    public void union(int i, int j) {
        int leaderA = find(i);
        int leaderB = find(j);

        if (leaderA != leaderB) {
            if (size[leaderA] > size[leaderB]) {
                parent[leaderB] = leaderA;
                size[leaderA] += size[leaderB];
            } else {
                parent[leaderA] = leaderB;
                size[leaderB] += size[leaderA];
            }
        }
    }

    private int find(int i) {
        if (parent[i] == i) {
            return i;
        }

        return parent[i] = find(parent[i]);
    }
}