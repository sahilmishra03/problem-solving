import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    ArrayList<Integer> res;

    public boolean isCyclic(int V, int[][] edges) {
        // code here
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            ArrayList<Integer> ls = adj.get(edges[i][0]);
            ls.add(edges[i][1]);

            indegree[edges[i][1]]++;
        }

        boolean[] vis = new boolean[V];
        res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                vis[i] = true;
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int front = q.remove();
            res.add(front);

            for (int i = 0; i < adj.get(front).size(); i++) {
                int adjNodes = adj.get(front).get(i);

                indegree[adjNodes]--;

                if (indegree[adjNodes] == 0) {
                    q.add(adjNodes);
                    vis[adjNodes] = true;
                }
            }
        }

        if (res.size()==V) {
            return false;
        }

        return true;
    }
}