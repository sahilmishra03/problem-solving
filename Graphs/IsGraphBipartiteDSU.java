package Graphs;

class IsGraphBipartiteDSU {
    int parent[];
    int size[];
    boolean parity[];

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        parent = new int[n + 1];
        size = new int[n + 1];
        parity = new boolean[n + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            size[i] = 1;
            parity[i] = false;
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (graph[i][j] > i) {
                    if (find(i) == find(graph[i][j]) && parity[i] == parity[graph[i][j]]) {
                        return false;
                    } else {
                        union(i, graph[i][j]);
                    }
                }
            }
        }

        return true;
    }

    public void union(int i, int j) {
        int leaderA = find(i);
        int leaderB = find(j);

        if (leaderA != leaderB) {
            if (size[leaderA] > size[leaderB]) {
                parent[leaderB] = leaderA;
                size[leaderA] += size[leaderB];
                parity[j] = !parity[i];
            } else {
                parent[leaderA] = leaderB;
                size[leaderB] += size[leaderA];
                parity[i] = !parity[j];
            }
        }
    }

    private int find(int i) {
        if (parent[i] == i) {
            return i;
        }

        return parent[i] = find(parent[i]);
    }
}