import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i = i + 1) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i = i + 1) {
            ArrayList<Integer> v1 = adj.get(edges[i][0]);
            v1.add(edges[i][1]);

            ArrayList<Integer> v2 = adj.get(edges[i][1]);
            v2.add(edges[i][0]);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        vis[source] = true;

        while (!q.isEmpty()) {
            int front = q.remove();

            for (int i = 0; i < adj.get(front).size(); i++) {
                if (vis[adj.get(front).get(i)] == false) {
                    q.add(adj.get(front).get(i));
                    vis[adj.get(front).get(i)] = true;
                }
            }
        }

        for (int i = 0; i < vis.length; i++) {
            if (i == destination && vis[i] == true) {
                return true;
            }
        }

        return false;
    }
}