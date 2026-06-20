class Solution {
    int[] parent;
    int[] size;

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        parent = new int[n + 1];
        size = new int[n + 1];

        for (int i = 0; i < parent.length; i = i + 1) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < n; i = i + 1) {
            for (int j = 0; j < n; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    union(i + 1, j + 1);
                }
            }
        }

        int count = 0;
        for (int i = 1; i < parent.length; i = i + 1) {
            if (parent[i] == i) {
                count++;
            }
        }

        return count;
    }

    private void union(int a, int b) {
        int leaderA = find(a);
        int leaderB = find(b);

        if (leaderA != leaderB) {
            if (size[leaderA] >= size[leaderB]) {
                parent[leaderB] = leaderA;
                size[leaderA] += size[leaderB];
            } else {
                parent[leaderA] = leaderB;
                size[leaderB] += size[leaderA];
            }
        }
    }

    private int find(int a) {
        if (parent[a] == a) {
            return a;
        }

        return parent[a]=find(parent[a]);
    }
}