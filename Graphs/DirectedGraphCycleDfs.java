import java.util.ArrayList;
import java.util.Collections;

class Solution {
    ArrayList<Integer> res;

    public boolean isCyclic(int V, int[][] edges) {
        // code here
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            ArrayList<Integer> ls = adj.get(edges[i][0]);
            ls.add(edges[i][1]);
        }
        boolean[] vis = new boolean[V];
        res = new ArrayList<>();

        for (int i = 0; i < vis.length; i++) {
            if (vis[i] == false) {
                dfs(adj, vis, i);
            }
        }

        Collections.sort(res, Collections.reverseOrder());
        
        if (res.size()==V) {
            return false;
        }
        return true;
    }

    private void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int i) {
        vis[i] = true;
        for (int j = 0; j < adj.get(i).size(); j++) {
            dfs(adj, vis, adj.get(i).get(j));
        }

        res.add(i);
    }
}