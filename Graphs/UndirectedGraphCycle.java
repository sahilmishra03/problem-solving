import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution1 {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        boolean[] vis = new boolean[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i = i + 1) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i = i + 1) {
            ArrayList<Integer> v1 = adj.get(edges[i][0]);
            v1.add(edges[i][1]);

            ArrayList<Integer> v2 = adj.get(edges[i][1]);
            v2.add(edges[i][0]);
        }

        for (int i = 0; i < vis.length; i++) {
            if (vis[i] == false) {
                if (bfs(i, -1, adj, vis)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean bfs(int i, int par, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { i, par });
        vis[i] = true;

        while (!q.isEmpty()) {
            int front[] = q.remove();
            for (int j = 0; j < adj.get(front[0]).size(); j++) {
                int val = adj.get(front[0]).get(j);

                if (vis[val] == false) {
                    q.add(new int[] {
                            val,
                            front[0]
                    });
                }

                if (vis[val] == true && front[1] != val) {
                    return true;
                }
            }
        }

        return false;
    }
}

class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        boolean[] vis = new boolean[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i = i + 1) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i = i + 1) {
            ArrayList<Integer> v1 = adj.get(edges[i][0]);
            v1.add(edges[i][1]);

            ArrayList<Integer> v2 = adj.get(edges[i][1]);
            v2.add(edges[i][0]);
        }

        for (int i = 0; i < vis.length; i++) {
            if (vis[i] == false) {
                if (dfs(i, -1, adj, vis)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int i, int par, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[i] = true;

        for (int j = 0; j < adj.get(i).size(); j++) {
            int val = adj.get(i).get(j);

            if (vis[val] == false) {
                if(dfs(val, i, adj, vis)){
                    return true;
                }
            } else if (vis[val] == true && par != val) {
                return true;
            }
        }

        return false;
    }
}