class Solution {
    int[] parent;
    int[] size;

    public int[] findRedundantConnection(int[][] edges) {
        // Number of Provinces(DSU-OPTIMIZATION-PATH COMPRESION)
        int n = edges.length;
        parent = new int[n + 1];
        size = new int[n + 1];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < edges.length; i++) {
            if(union(edges[i][0],edges[i][1])){
                return new int[]{edges[i][0],edges[i][1]};
            }
        }

        return new int[]{-1,-1};
    }

    private boolean union(int a, int b) {
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
        } else {
            return true;
        }

        return false;
    }

    private int find(int a) {
        if (parent[a] == a) {
            return a;
        }

        parent[a] = find(parent[a]);
        return parent[a];

    }
}