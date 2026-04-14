class Solution {
    public int findDelayTime(int V, int[][] edges, int src) {
        // code here
        int[] res = new int[V];
        for (int i = 0; i < res.length; i++) {
            res[i] = Integer.MAX_VALUE;
        }

        res[src] = 0;

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < edges.length; j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                int wt = edges[j][2];

                if (res[u] != Integer.MAX_VALUE && res[u] + wt < res[v]) {
                    res[v]=res[u] + wt;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < res.length; i++) {
            if (res[i]==Integer.MAX_VALUE) {
                return -1;
            }

            max=Math.max(max, res[i]);
        }

        return max;
    }
}