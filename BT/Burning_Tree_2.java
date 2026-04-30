package BT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Burning_Tree_2 {
    static ArrayList<CharNode> path;
    static ArrayList<ArrayList<Character>> res;
    static HashMap<Integer, ArrayList<Character>> map;
    static int min;
    static int max;

    public static void main(String[] args) {
        CharNode root = new CharNode('a');
        root.left = new CharNode('b');
        root.right = new CharNode('c');
        root.left.left = new CharNode('d');
        root.left.right = new CharNode('e');
        root.right.left = new CharNode('f');
        root.right.right = new CharNode('g');
        root.right.left.left = new CharNode('h');
        root.right.left.right = new CharNode('i');
        root.right.left.right.left = new CharNode('j');
        root.right.left.right.right = new CharNode('k');
        root.right.left.right.left.left = new CharNode('n');
        root.right.left.right.left.right = new CharNode('o');
        root.right.left.right.right.left = new CharNode('l');
        root.right.left.right.right.right = new CharNode('m');
        root.right.left.right.right.left.left = new CharNode('1');
        root.right.left.right.right.left.right = new CharNode('2');

        path = new ArrayList<>();
        res = new ArrayList<>();
        map = new HashMap<>();
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        nodeToRootPath(root, 'i');
        for (int i = 0; i < path.size(); i = i + 1) {
            CharNode blocker = null;
            if (i > 0) {
                blocker = path.get(i - 1);
            }
            levelOrderTraversal(path.get(i), i, blocker);
        }

        for (int i = min; i <= max; i = i + 1) {
            res.add(map.get(i));
        }

        System.out.println(res);
    }

    private static void levelOrderTraversal(CharNode root, int time, CharNode blocker) {
        int currTime = time;
        if (root == null || root == blocker) {
            return;
        }

        Queue<CharNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i = i + 1) {
                CharNode n = q.remove();
                if (n == blocker) {
                    continue;
                }
                if (!map.containsKey(currTime) && n != blocker) {
                    map.put(currTime, new ArrayList<Character>());
                }

                if (n != blocker) {
                    ArrayList<Character> list = map.get(currTime);
                    list.add(n.data);
                }

                if (n.left != null && n.left != blocker) {
                    q.add(n.left);
                }

                if (n.right != null && n.right != blocker) {
                    q.add(n.right);
                }
            }
            max = Math.max(currTime, max);
            min = Math.min(currTime, min);
            currTime++;
        }
    }

    public static boolean nodeToRootPath(CharNode root, char target) {
        if (root == null) {
            return false;
        }

        if (root.data == target) {
            path.add(root);
            return true;
        }

        boolean left = nodeToRootPath(root.left, target);
        if (left) {
            path.add(root);
            return true;
        }

        boolean right = nodeToRootPath(root.right, target);
        if (right) {
            path.add(root);
            return true;
        }

        return false;
    }
}
