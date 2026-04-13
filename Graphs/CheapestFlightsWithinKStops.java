import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {
    public class Triplet {
        int node,
                dist,
                stops;

        Triplet(int node, int dist, int stops) {
            this.node = node;
            this.dist = dist;
            this.stops = stops;
        }

    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < flights.length; i++) {
            adj.get(flights[i][0]).add(new int[] { flights[i][1], flights[i][2] });
        }

        PriorityQueue<Triplet> q = new PriorityQueue<>((a, b) -> a.stops - b.stops);
        q.add(new Triplet(src, 0, 0));

        int[] res = new int[n];

        for (int i = 0; i < res.length; i++) {
            res[i] = Integer.MAX_VALUE;
        }
        res[src] = 0;
        while (!q.isEmpty()) {
            Triplet front = q.remove();

            if (front.stops > k) {
                continue;
            }

            if (res[front.node] > front.dist) {
                continue;
            }

            for (int i = 0; i < adj.get(front.node).size(); i++) {
                int cal = adj.get(front.node).get(i)[1] + front.dist;

                if (cal < res[adj.get(front.node).get(i)[0]]) {
                    res[adj.get(front.node).get(i)[0]] = cal;
                    q.add(new Triplet(adj.get(front.node).get(i)[0], cal, front.stops + 1));
                }
            }
        }
        if (res[dst] == Integer.MAX_VALUE)
            return -1;
        return res[dst];
    }
}