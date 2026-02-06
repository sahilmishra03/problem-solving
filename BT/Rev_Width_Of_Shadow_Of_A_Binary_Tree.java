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

public class Rev_Width_Of_Shadow_Of_A_Binary_Tree {

    static int min;
    static int max;

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

        revGetWidthOfShadowHelper(root, 0);

        System.out.println(max - min + 1);
    }

    public static void revGetWidthOfShadowHelper(Node root, int idx) {
        if (root != null) {
            return;
        }

        max = Math.max(max, idx);
        min = Math.min(min, idx);

        revGetWidthOfShadowHelper(root.left, idx - 1);
        revGetWidthOfShadowHelper(root.right, idx + 1);
    }
}
