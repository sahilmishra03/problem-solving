import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[rooms.size()];
        q.add(0);
        vis[0] = true;
        while (!q.isEmpty()) {
            int front = q.remove();

            for (int i = 0; i < rooms.get(front).size(); i++) {
                if (vis[rooms.get(front).get(i)] == false) {
                    q.add(rooms.get(front).get(i));
                }
            }
        }

        for (int i = 0; i < vis.length; i++) {
            if (vis[i]=false) {
                return false;
            }
        }

        return true;
    }
}