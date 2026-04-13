import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DijistraAlgorithm {
    int node;
    int cost;

    DijistraAlgorithm(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<DijistraAlgorithm>> adj = new ArrayList<>();

        for (int i = 0; i < times.length; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < times.length; i++) {
            adj.get(times[i][0]).add(new DijistraAlgorithm(times[i][1], times[i][2]));
        }

        Queue<DijistraAlgorithm> q = new LinkedList<>();
        q.add(new DijistraAlgorithm(n, k));
        int[] res = new int[n];
        for (int i = 0; i < res.length; i++) {
            res[i] = Integer.MAX_VALUE;
        }
        res[k] = 0;

        while (!q.isEmpty()) {
            DijistraAlgorithm front = q.remove();
            if (res[front.node] < front.cost) {
                continue;
            }

            for (int i = 0; i < adj.get(front.node).size(); i++) {
                int cal = adj.get(front.node).get(i).cost + front.cost;
                if (res[adj.get(front.node).get(i).node] > cal) {
                    res[adj.get(front.node).get(i).node] = cal;
                    q.add(new DijistraAlgorithm(adj.get(front.node).get(i).node, cal));
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