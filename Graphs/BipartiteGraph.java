package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class BipartiteGraph {
    public boolean isBipartite(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        int[] vis = new int[V];
        for (int i = 0; i < vis.length; i++) {
            if (vis[i] == 0) {
                if(!bfs(i, adj, vis)){
                    return false;
                }
            }
        }

        return true;
    }

    private boolean bfs(int i, ArrayList<ArrayList<Integer>> adj, int[] vis) {
        vis[i]=1;
        Queue<Integer> q = new LinkedList<>();
        q.add(i);

        while (!q.isEmpty()) {
            int front = q.remove();
            for (int j = 0; j < adj.get(front).size(); j++) {
                int child = adj.get(front).get(j);
                if (vis[child]==0) {
                    if(vis[front]==1){
                        vis[child]=2;
                        q.add(child);
                    }else{
                        vis[child]=1;
                        q.add(child);
                    }
                }

                if (vis[child]!=0 && child!=front && vis[child]==vis[front]) {
                    return false;
                }
            }
        }

        return true;
    }
}