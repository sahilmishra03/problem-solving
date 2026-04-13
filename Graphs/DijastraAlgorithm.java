import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public class Pair {
        int node;
        int cost;

        Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < times.length; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < times.length; i++) {
            adj.get(times[i][0]).add(new Pair(times[i][1], times[i][2]));
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(n, k));
        int[] res = new int[n];
        for (int i = 0; i < res.length; i++) {
            res[i] = Integer.MAX_VALUE;
        }
        res[k] = 0;

        while (!q.isEmpty()) {
            Pair front = q.remove();
            if (res[front.node] < front.cost) {
                continue;
            }

            for (int i = 0; i < adj.get(front.node).size(); i++) {
                int cal = adj.get(front.node).get(i).cost + front.cost;
                if (res[adj.get(front.node).get(i).node] > cal) {
                    res[adj.get(front.node).get(i).node] = cal;
                    q.add(new Pair(adj.get(front.node).get(i).node, cal));
                }
            }
        }

        int resFinal = Integer.MIN_VALUE;
        for (int i = 0; i < res.length; i++) {
            resFinal = Math.max(resFinal, res[i]);
        }

        return resFinal;
    }
}