package BT;

import java.util.*;

public class Video25 {
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static ArrayList<Integer> res;

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(25);
        root.right = new Node(75);
        root.left.left = new Node(72);
        root.left.right = new Node(37);
        root.right.left = new Node(62);
        root.right.right = new Node(87);
        root.left.right.left = new Node(30);
        root.right.left.right = new Node(70);

        path = new ArrayList<>();
        nodeToRootPath(root, 62);

        for (int i = 0; i < path.size(); i++) {
            Node blocker = null;
            if (i > 0) {
                path.get(i - 1);
            }

            kLevelDownWithBlocker(root, i, blocker);
        }
    }

    public static void kLevelDownWithBlocker(Node root, int k, Node blocker) {
        if (root == null || root == blocker || k <= 0) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node n = q.remove();
                if (n == blocker) {
                    continue;
                }

                if (n != blocker && count == k) {
                    res.add(n.data);
                }

                if (n.left != null && n.left != blocker) {
                    q.add(n.left);
                }

                if (n.left != null && n.left != blocker) {
                    q.add(n.left);
                }
            }

            count++;
        }
    }

    static ArrayList<Node> path;

    public static boolean nodeToRootPath(Node root, int data) {
        if (root == null) {
            return false;
        }

        if (root.data == data) {
            path.add(root);
            return true;
        }

        boolean left = nodeToRootPath(root.left, data);
        if (left) {
            path.add(root);
            return true;
        }
        boolean right = nodeToRootPath(root.right, data);
        if (right) {
            path.add(root);
            return true;
        }
        return false;
    }
}
