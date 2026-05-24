class Solution {
    int[] parent;
    int[] size;
    boolean[] parity;

    private void union(int a, int b) {
        int leaderA = find(a);
        int leaderB = find(b);

        if (leaderA != leaderB) {
            if (size[leaderA] > size[leaderB]) {
                parent[leaderB] = leaderA;
                size[leaderA] += size[leaderB];
                parity[b] = !parity[a];
            } else {
                parent[leaderB] = leaderA;
                size[leaderB] += size[leaderA];
                parity[a] = !parity[b];
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

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] > i) {
                    if (find(graph[i][j]) == find(i) && parity[graph[i][j]] == parity[i]) {
                        return false;
                    } else {
                        union(graph[i][j], i);
                    }
                }
            }
        }

        return true;
    }
}