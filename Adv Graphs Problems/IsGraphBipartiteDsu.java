class Solution {
    int[] parent;
    int[] size;
    boolean[] parity;

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        parent = new int[n];
        size = new int[n];
        parity = new boolean[n];

        for (int i = 0; i < graph.length; i++) {
            parent[i] = i;
            size[i] = 1;
            parity[i] = false;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (i < graph[i][j]) {
                    if (!union(i, graph[i][j])) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private boolean union(int a, int b) {
        int leaderA = find(a);
        int leaderB = find(b);

        if (leaderA != leaderB) {
            if (size[leaderA] >= size[leaderB]) {
                parent[leaderB] = leaderA;
                size[leaderA] += size[leaderB];
                parity[b] = !parity[a];
            } else {
                parent[leaderA] = leaderB;
                size[leaderB] += size[leaderA];
                parity[a] = !parity[b];
            }
        } else {
            if (parity[a]==parity[b]) {
                return false;
            }
        }

        return true;
    }

    private int find(int a) {
        if (parent[a] == a) {
            return a;
        }

        return parent[a] = find(parent[a]);
    }
}