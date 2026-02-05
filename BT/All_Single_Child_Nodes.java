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

class All_Single_Child_Nodes {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        printSingleChildNode(root);
    }

    public static void printSingleChildNode(Node root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right != null) {
            
            System.out.println(root.data);
        }

        if (root.left != null && root.right == null) {
            System.out.println(root.data);
        }

        printSingleChildNode(root.left);
        printSingleChildNode(root.right);
    }
}