import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
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
        int[] finalRes = new int[res.size()];
        for (int i = 0; i < finalRes.length; i++) {
            finalRes[i]=res.get(i);
        }
        return finalRes;
    }
}