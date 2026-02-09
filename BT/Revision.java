package BT;

class Revision {
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
        getWidthOfShadow(root, 0);

        System.out.println(max - min + 1);
    }

    private static void getWidthOfShadow(Node root, int i) {
        if (root == null) {
            return;
        }
        min = Math.min(i, min);
        max = Math.max(i, max);
        getWidthOfShadow(root.left, i - 1);
        getWidthOfShadow(root.right, i + 1);
    }
}
