
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class FindEventualSafeStatesRev {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = graph.length;
        int[] inDegree = new int[n];
        for (int i = 0; i < graph.length; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                adj.get(graph[i][j]).add(i);
                inDegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int front = q.remove();
            res.add(front);

            for (int i = 0; i < adj.get(front).size(); i++) {
                inDegree[adj.get(front).get(i)]--;
                if (inDegree[adj.get(front).get(i)] == 0) {
                    q.add(adj.get(front).get(i));
                }
            }
        }

        return res;
    }
}