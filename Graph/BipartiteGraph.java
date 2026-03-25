package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
    public boolean isBipartite(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i = i + 1) {
            adj.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < edges.length; i = i + 1) {
            ArrayList<Integer> ls1 = adj.get(edges[i][0]);
            ls1.add(edges[i][1]);

            ArrayList<Integer> ls2 = adj.get(edges[i][1]);
            ls2.add(edges[i][0]);
        }

        int[] visited = new int[V];
        // 1 == GREEN
        // 2 == RED

        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                if(bfs(i, visited, adj)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean bfs(int i, int[] visited, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        visited[i] = 1;

        while (!q.isEmpty()) {
            int front = q.remove();

            for (int j = 0; j < adj.get(front).size(); j++) {
                int child = adj.get(front).get(j);
                if (visited[child] == 0) {
                    if (visited[front] == 1) {
                        visited[child] = 2;
                        q.add(child);
                    } else {
                        visited[child] = 1;
                        q.add(child);
                    }
                }else if (visited[child]==visited[front]) {
                    return false;
                }
            }
        }

        return true;
    }
}
