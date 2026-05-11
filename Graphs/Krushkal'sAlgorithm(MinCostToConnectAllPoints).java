import java.util.*;

class Solution {
    int[] parent;
    int[] size;
    public class Triplet {
        int u, v, wt;

        Triplet(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        ArrayList<Triplet> ls = new ArrayList<>();
        int n = points.length;
        parent = new int[n];
        size = new int[n];
        
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        for(int i=0;i<points.length;i=i+1){
            for(int j=i+1;j<points.length;j=j+1){
                int x1 = points[i][0], y1 = points[i][1],
                        x2 = points[j][0], y2 = points[j][1];

                int mDist = Math.abs(x1 - x2) + Math.abs(y1 - y2);

                ls.add(new Triplet(i,j,mDist));
            }
        }

        Collections.sort(ls,(a,b)->a.wt-b.wt);
        int minCost=0;
        for(int i=0;i<ls.size();i=i+1){
            if(union(ls.get(i).u,ls.get(i).v)){
                minCost+=ls.get(i).wt;
            }
        }

        return minCost;
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