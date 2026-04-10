import java.util.LinkedList;
import java.util.Queue;

class Solution1 {
    public boolean isBipartite(int[][] graph) {
        int vis[] = new int[graph.length];
        for (int i = 0; i < vis.length; i++) {
            vis[i] = -1;
        }

        for (int i = 0; i < vis.length; i++) {
            if (vis[i] == -1) {
                if (!bfs(i, graph, vis)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean bfs(int i, int[][] graph, int[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        vis[i] = 1;

        while (!q.isEmpty()) {
            int front = q.remove();
            for (int j = 0; j < graph[front].length; j++) {
                if (vis[graph[front][j]] == -1) {
                    if (vis[front] == 1) {
                        vis[graph[front][j]] = 2;
                        q.add(graph[front][j]);
                    } else {
                        vis[graph[front][j]] = 1;
                        q.add(graph[front][j]);
                    }
                } else {
                    if (vis[front] == vis[graph[front][j]]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}