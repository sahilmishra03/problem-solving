package BT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    char data;
    Node left;
    Node right;

    Node(char data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class Burning_Tree_2 {
    static ArrayList<Node> path;
    static ArrayList<ArrayList<Character>> res;
    static HashMap<Integer, ArrayList<Character>> map;
    static int min;
    static int max;

    public static void main(String[] args) {
        Node root = new Node('a');
        root.left = new Node('b');
        root.right = new Node('c');
        root.left.left = new Node('d');
        root.left.right = new Node('e');
        root.right.left = new Node('f');
        root.right.right = new Node('g');
        root.right.left.left = new Node('h');
        root.right.left.right = new Node('i');
        root.right.left.right.left = new Node('j');
        root.right.left.right.right = new Node('k');
        root.right.left.right.left.left = new Node('n');
        root.right.left.right.left.right = new Node('o');
        root.right.left.right.right.left = new Node('l');
        root.right.left.right.right.right = new Node('m');
        root.right.left.right.right.left.left = new Node('1');
        root.right.left.right.right.left.right = new Node('2');

        path = new ArrayList<>();
        res = new ArrayList<>();
        map = new HashMap<>();
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        nodeToRootPath(root, 'i');
        for (int i = 0; i < path.size(); i = i + 1) {
            Node blocker = null;
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

    private static void levelOrderTraversal(Node root, int time, Node blocker) {
        int currTime = time;
        if (root == null || root == blocker) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i = i + 1) {
                Node n = q.remove();
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

    public static boolean nodeToRootPath(Node root, char target) {
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
