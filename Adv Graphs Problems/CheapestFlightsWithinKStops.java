import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {
    class Pair {
        int node;
        int cost;

        public Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    class Triplet {
        int node;
        int cost;
        int stops;

        public Triplet(int node, int cost, int stops) {
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            adj.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }

        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[src] = 0;

        // Priority queue to store triplets (node, cost, stops)
        PriorityQueue<Triplet> pq = new PriorityQueue<>((a, b) -> a.stops - b.stops);
        pq.add(new Triplet(src, 0, 0));

        while (!pq.isEmpty()) {
            Triplet current = pq.poll();
            int node = current.node;
            int cost = current.cost;
            int stops = current.stops;

            if (stops == k + 1) {
                continue;
            }

            for (int i = 0; i < adj.get(node).size(); i++) {
                Pair neighbor = adj.get(node).get(i);
                int nextNode = neighbor.node;
                int nextCost = neighbor.cost;

                if (cost + nextCost < dist[nextNode]) {
                    dist[nextNode] = cost + nextCost;
                    pq.add(new Triplet(nextNode, cost + nextCost, stops + 1));
                }
            }
        }

        if (dist[dst] != Integer.MAX_VALUE) {
            return dist[dst];
        }

        return -1;
    }
}