import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        int[] indegree = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                ArrayList<Integer> ls = adj.get(graph[i][j]);
                ls.add(i);
                indegree[i]++;
            }
        }

        boolean[] vis = new boolean[graph.length];
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
        Collections.sort(res);
        return res;
    }
}