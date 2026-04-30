package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class DirectedGraphCycle {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        int[] inDegree = new int[V];
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            inDegree[edges[i][1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i]==0) {
                q.add(i);
            }
        }
        ArrayList<Integer> rs = new ArrayList<>();
        while (!q.isEmpty()) {
            int front = q.remove();
            rs.add(front);

            for (int i = 0; i < adj.get(front).size(); i++) {
                inDegree[adj.get(front).get(i)]--;
                if (inDegree[adj.get(front).get(i)]==0) {
                    q.add(adj.get(front).get(i));
                }
            }
        }

        if (rs.size()<V) {
            return true;
        }

        return false;
    }
}