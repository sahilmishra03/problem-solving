
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Undirected_Graph_Cycle_Rev {
    public class Pair {
        int num, parent;

        Pair(int num, int parent) {
            this.num = num;
            this.parent = parent;
        }
    }

    public boolean isCycle(int V, int[][] edges) {
        // Code here
        boolean[] vis = new boolean[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        for (int i = 0; i < vis.length; i++) {
            if (vis[i] == false) {
                if (bfs(adj, vis, i)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean bfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int i) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, -1));
        vis[i] = true;
        while (!q.isEmpty()) {
            Pair front = q.remove();

            for (int j = 0; j < adj.get(front.num).size(); j++) {
                if (vis[adj.get(front.num).get(j)] == false) {
                    vis[adj.get(front.num).get(j)] = true;
                    q.add(new Pair(adj.get(front.num).get(j), front.num));
                }else if (adj.get(front.num).get(j) != front.parent) {
                    return true;
                }
            }
        }

        return false;
    }
}