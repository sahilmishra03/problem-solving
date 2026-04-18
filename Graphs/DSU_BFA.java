class Solution {
    int parent[];
    int size[];
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i!=j && isConnected[i][j]==1) {
                    union(i+1,j+1);
                }
            }
        }
        int count=0;
        for (int i = 1; i <parent.length; i++) {
            if (parent[i]==i) {
                count++;
            }
        }

        return count;
    }

    public void union(int i, int j) {
        int leaderA = find(i);
        int leaderB = find(j);

        if (leaderA!=leaderB) {
            if (size[leaderA] > size[leaderB]) {
                parent[leaderB] = leaderA;
                size[leaderA] += size[leaderB];
            } else {
                parent[leaderA] = leaderB;
                size[leaderB] += size[leaderA];
            }
        }
    }

    private int find(int i) {
        if (parent[i]==i) {
            return i;
        }

        return parent[i] = find(parent[i]);
    }
}