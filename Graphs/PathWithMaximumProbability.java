import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public class Pair {
        int node;
        double prob;

        Pair(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], succProb[i]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], succProb[i]));
        }

        double[] res = new double[n];
        for (int i = 0; i < res.length; i++) {
            res[i] = 0.0;
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start_node, 1));
        res[start_node] = 1;

        while (!q.isEmpty()) {
            Pair front = q.remove();
            if (res[front.node] > front.prob) {
                continue;
            }

            for (int i = 0; i < adj.get(front.node).size(); i++) {
                double cal = adj.get(front.node).get(i).prob * front.prob;

                if (res[adj.get(front.node).get(i).node] < cal) {
                    res[adj.get(front.node).get(i).node] = cal;
                    q.add(new Pair(adj.get(front.node).get(i).node, cal));
                }
            }
        }

        if (res[end_node]==Integer.MAX_VALUE) {
            return -1;
        }

        return res[end_node];
    }
}