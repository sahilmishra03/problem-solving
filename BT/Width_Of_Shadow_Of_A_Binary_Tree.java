package BT;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class Width_Of_Shadow_Of_A_Binary_Tree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(7);
        root.left.right = new Node(9);
        root.right.left = new Node(10);
        root.right.right = new Node(11);
        root.left.left.left = new Node(8);
        root.right.right.right = new Node(12);
        root.right.right.right.right = new Node(13);
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        getWidthOfShadow(root, 0);

        System.out.println(max - min + 1);
    }

    static int max;
    static int min;

    public static void getWidthOfShadow(Node root, int hl) {
        if (root == null) {
            return;
        }

        max = Math.max(hl, max);
        min = Math.min(hl, min);

        getWidthOfShadow(root.left, hl - 1);
        getWidthOfShadow(root.right, hl + 1);
    }
}