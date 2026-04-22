import java.util.*;

class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> res = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        for (int i = 0; i < queries.length; i++) {
            if (bfs(queries[i][0],queries[i][1], adj)) {
                res.add(true);
            } else {
                res.add(false);
            }
        }

        return res;
    }

    private boolean bfs(int i, int target, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[adj.size()];
        Queue<Integer> q = new LinkedList<>();
        q.add(i);

        while (!q.isEmpty()) {
            int front = q.remove();
            for (int j = 0; j < adj.get(front).size(); j++) {
                if (vis[adj.get(front).get(j)]==false) {
                    if (adj.get(front).get(j)==target) {
                        return true;
                    }else{
                        vis[adj.get(front).get(j)]=true;
                        q.add(adj.get(front).get(j));
                    }
                }
            }
        }

        return false;
    }
}