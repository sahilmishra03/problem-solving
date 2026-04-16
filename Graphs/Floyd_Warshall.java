// User function template for JAVA

class Solution {
    public void floydWarshall(int[][] adjMatrix) {
        int n = adjMatrix.length;
        // Code here
        for (int k = 0; k < n; k++) { // Via k
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == k || j == k) {
                        continue;
                    }

                    if (adjMatrix[i][k] != 100000000 && adjMatrix[k][j] != 100000000) {
                        adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][k] + adjMatrix[k][j]);
                    }
                }
            }
        }
    }
}