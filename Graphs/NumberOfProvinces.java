import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visisted = new boolean[n];
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 1 && visisted[i] == false) {
                    bfs(i, isConnected, visisted);
                    count++;
                }
            }
        }

        return count;
    }

    private void bfs(int i, int[][] isConnected, boolean[] visisted) {
        visisted[i] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(i);

        while (!q.isEmpty()) {
            int front = q.remove();
            for (int k = 0; k < isConnected[front].length; k++) {
                if (isConnected[i][k] == 1 && visisted[k] == false) {
                    q.add(k);
                    visisted[k] = true;
                }
            }
        }
    }
}