class Solution1 {
    int[] parent;

    public int findCircleNum(int[][] isConnected) {
        // Number of Provinces
        int n = isConnected.length;
        parent = new int[n + 1];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected.length; j++) {
                if (i == j) {
                    continue;
                }
                if (isConnected[i][j] == 1) {
                    union(i + 1, j + 1);
                }
            }
        }

        int count = 0;
        for (int i = 1; i < parent.length; i++) {
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
            parent[leaderB] = leaderA;
        }
    }

    private int find(int a) {
        if (parent[a] == a) {
            return a;
        }

        return find(parent[a]);
    }
}

class Solution2 {
    int[] parent;
    int[] size;

    public int findCircleNum(int[][] isConnected) {
        // Number of Provinces(DSU-OPTIMIZATION)
        int n = isConnected.length;
        parent = new int[n + 1];
        size = new int[n + 1];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected.length; j++) {
                if (i == j) {
                    continue;
                }
                if (isConnected[i][j] == 1) {
                    union(i + 1, j + 1);
                }
            }
        }

        int count = 0;
        for (int i = 1; i < parent.length; i++) {
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
            if (size[leaderA] > size[leaderB]) {
                parent[leaderB] = leaderA;
                size[leaderA] += size[leaderB];
            } else {
                parent[leaderB] = leaderA;
                size[leaderB] += size[leaderA];
            }
        }
    }

    private int find(int a) {
        if (parent[a] == a) {
            return a;
        }

        return find(parent[a]);
    }
}

class Solution {
    int[] parent;
    int[] size;

    public int findCircleNum(int[][] isConnected) {
        // Number of Provinces(DSU-OPTIMIZATION-PATH COMPRESION)
        int n = isConnected.length;
        parent = new int[n + 1];
        size = new int[n + 1];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected.length; j++) {
                if (i == j) {
                    continue;
                }
                if (isConnected[i][j] == 1) {
                    union(i + 1, j + 1);
                }
            }
        }

        int count = 0;
        for (int i = 1; i < parent.length; i++) {
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
            if (size[leaderA] > size[leaderB]) {
                parent[leaderB] = leaderA;
                size[leaderA] += size[leaderB];
            } else {
                parent[leaderB] = leaderA;
                size[leaderB] += size[leaderA];
            }
        }
    }

    private int find(int a) {
        if (parent[a] == a) {
            return a;
        }

        parent[a] = find(parent[a]);
        return parent[a];
    }
}