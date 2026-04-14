import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    class Triplet {
        int node, cost, stops;

        Triplet(int node, int cost, int stops) {
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public class Pair {
        int node, cost;

        Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        int[] res = new int[n];
        PriorityQueue<Triplet> pq = new PriorityQueue<>((a, b) -> a.stops - b.stops);

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < flights.length; i++) {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }

        for (int i = 0; i < n; i++) {
            res[i] = Integer.MAX_VALUE;
        }

        pq.add(new Triplet(src, 0, 0));
        res[src] = 0;

        while (!pq.isEmpty()) {
            Triplet front = pq.remove();
            if (front.stops > k) {
                continue;
            }

            for (int i = 0; i < adj.get(front.node).size(); i++) {
                Pair val = adj.get(front.node).get(i);
                int cal = front.cost + val.cost;

                if (res[val.node] > cal) {
                    res[val.node] = cal;
                    pq.add(new Triplet(val.node, cal, front.stops + 1));
                }
            }
        }

        return res[dst];
    }
}