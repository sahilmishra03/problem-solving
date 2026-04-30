package BT;

// Node class for integer data
public class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

// Node class for character data
class CharNode {
    char data;
    CharNode left;
    CharNode right;

    public CharNode(char data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
