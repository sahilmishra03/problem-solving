class Solution {
    int parent[];
    int size[];

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            if (u != v) {
                if (!union(u, v)) {
                    return edges[i];
                }
            }
        }

        return new int[] {
                -1, -1
        };
    }

    public boolean union(int i, int j) {
        int leaderA = find(i);
        int leaderB = find(j);

        if (leaderA != leaderB) {
            if (size[leaderA] > size[leaderB]) {
                parent[leaderB] = leaderA;
                size[leaderA] += size[leaderB];
                return true;
            } else {
                parent[leaderA] = leaderB;
                size[leaderB] += size[leaderA];
                return true;
            }
        }

        return false;
    }

    private int find(int i) {
        if (parent[i] == i) {
            return i;
        }

        return parent[i] = find(parent[i]);
    }
}