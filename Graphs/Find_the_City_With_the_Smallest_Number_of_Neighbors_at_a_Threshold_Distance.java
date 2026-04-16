class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] adjMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjMatrix[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            adjMatrix[u][v] = wt;
            adjMatrix[v][u] = wt;
        }

        for (int k = 0; k < n; k++) { // Via k
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == k || j == k) {
                        continue;
                    }

                    if (adjMatrix[i][k] != Integer.MAX_VALUE && adjMatrix[k][j] != Integer.MAX_VALUE) {
                        adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][k] + adjMatrix[k][j]);
                    }
                }
            }
        }
        int minCity = -1;
        int minCount = -1;
        for (int i = 0; i < adjMatrix.length; i++) {
            int count=0;
            for (int j = 0; j < adjMatrix.length; j++) {
                if (i==j) {
                    continue;
                }

                if (adjMatrix[i][j]<=distanceThreshold) {
                    count++;
                }
            }

            if (minCount>=count) {
                minCity=i;
                minCount=count;
            }
        }
        
        return minCity;
    }
}