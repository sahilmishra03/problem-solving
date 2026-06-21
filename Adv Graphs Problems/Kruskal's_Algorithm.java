import java.util.ArrayList;
import java.util.Collections;

class Solution {
    int[] parent;
    int[] size;

    class Triplet {
        int i, j, wt;

        Triplet(int i, int j, int wt) {
            this.i = i;
            this.j = j;
            this.wt = wt;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        parent = new int[n];
        size = new int[n];
        ArrayList<Triplet> edgeList = new ArrayList<>();
        for (int i = 0; i < n; i = i + 1) {
            for (int j = i + 1; j < n; j = j + 1) {
                int mDist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edgeList.add(new Triplet(i, j, mDist));
            }
        }

        Collections.sort(edgeList, (a, b) -> a.wt - b.wt);

        for (int i = 0; i < parent.length; i = i + 1) {
            parent[i] = i;
            size[i] = 1;
        }

        int resSum = 0;

        for (int i = 0; i < edgeList.size(); i = i + 1) {
            Triplet front = edgeList.get(i);

            if (front.i != front.j) {
                if (union(front.i, front.j)) {
                    resSum += front.wt;
                }
            }
        }

        return resSum;
    }

    private boolean union(int a, int b) {
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
        } else {
            return false;
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