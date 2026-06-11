import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {
    class Pair {
        int node;
        int time;

        public Pair(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }
    
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] time : times) {
            adj.get(time[0]).add(new Pair(time[1], time[2]));
        }

        int[] dist = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[k] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        pq.offer(new Pair(k, 0));
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int node = current.node;
            int time = current.time;

            if (time > dist[node]) {
                continue;
            }

            for(int i=0;i<adj.get(node).size();i++) {
                Pair neighbor = adj.get(node).get(i);
                int newTime = time + neighbor.time;
                if (newTime < dist[neighbor.node]) {
                    dist[neighbor.node] = newTime;
                    pq.offer(new Pair(neighbor.node, newTime));
                }
            }
        }

        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            maxTime = Math.max(maxTime, dist[i]);
        }
        return maxTime;
    }
}