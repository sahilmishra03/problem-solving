// User function Template for Java

class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        // code here
        int[] res = new int[V];
        for (int i = 0; i < res.length; i++) {
            res[i] = 100000000;
        }

        for (int i = 0; i < V - 1; i++) {
            for (int j = 0; j < edges.length; j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                int wt = edges[j][2];

                if (res[u] != 100000000 && res[u] + wt < res[v]) {
                    res[v] = res[u] + wt;
                }
            }
        }
        res[src]=0;
        for (int j = 0; j < edges.length; j++) {
            int u = edges[j][0];
            int v = edges[j][1];
            int wt = edges[j][2];

            if (res[u] != 100000000 && res[u] + wt < res[v]) {
                return new int[] { -1 };
            }
        }

        return res;
    }
}
