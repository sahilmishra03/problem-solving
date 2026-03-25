package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class UndirectedGraphCycle {
    public boolean isCycle(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i = i + 1) {
            adj.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < edges.length; i = i + 1) {
            ArrayList<Integer> ls1 = adj.get(edges[i][0]);
            ls1.add(edges[i][1]);

            ArrayList<Integer> ls2 = adj.get(edges[i][1]);
            ls2.add(edges[i][0]);
        }

        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (bfs(i, visited, adj)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean bfs(int i, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { i, -1 });
        visited[i] = true;

        while (!q.isEmpty()) {
            int[] front = q.remove();

            for (int j = 0; j < adj.get(front[0]).size(); j++) {
                int neighbor = adj.get(front[0]).get(j);

                if (neighbor == front[1]) {
                    continue;
                } else if (visited[neighbor]) {
                    return true;
                } else {
                    visited[neighbor] = true;
                    q.add(new int[] { neighbor, front[0] });
                }
            }
        }

        return false;
    }
}
