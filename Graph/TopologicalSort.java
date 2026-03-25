package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        int[] inDegree = new int[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i = i + 1) {
            adj.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < edges.length; i = i + 1) {
            ArrayList<Integer> ls = adj.get(edges[i][0]);
            ls.add(edges[i][1]);

            inDegree[edges[i][1]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int front = q.remove();
            res.add(front);

            for (int i = 0; i < adj.get(front).size(); i++) {
                inDegree[adj.get(front).get(i)]--;
                if (inDegree[adj.get(front).get(i)] == 0) {
                    q.add(adj.get(front).get(i));
                }
            }
        }

        return res;
    }
}
