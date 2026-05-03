
import java.util.LinkedList;
import java.util.Queue;

class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        bfs(image, sr, sc, color);
        return image;
    }

    private void bfs(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { sr, sc });
        int val = image[sr][sc];
        image[sr][sc] = color;
        int n = image.length;
        int m = image[0].length;
        while (!q.isEmpty()) {
            int[] front = q.remove();
            int row = front[0];
            int col = front[1];
            // Up
            if (row - 1 >= 0) {
                if (image[row - 1][col] == val) {
                    q.add(new int[] {
                            row - 1,
                            col
                    });
                    image[row - 1][col] = color;
                }
            }
            // Down
            if (row + 1 < n) {
                if (image[row + 1][col] == val) {
                    q.add(new int[] {
                            row + 1,
                            col
                    });
                    image[row + 1][col] = color;
                }
            }
            // Left
            if (col - 1 >= 0) {
                if (image[row][col - 1] == val) {
                    q.add(new int[] {
                            row,
                            col - 1
                    });
                    image[row][col - 1] = color;
                }
            }
            // Right
            if (col + 1 < m) {
                if (image[row][col + 1] == val) {
                    q.add(new int[] {
                            row,
                            col + 1
                    });
                    image[row][col + 1] = color;
                }
            }
        }
    }
}