package BT;
public class Video32_38 {

    public static void main(String[] args) {
        CharNode root = new CharNode('a');
        root.left = new CharNode('b');
        root.right = new CharNode('c');
        root.left.left = new CharNode('d');
        root.left.right = new CharNode('e');
        root.right.left = new CharNode('f');
        root.right.right = new CharNode('g');

        inOrder(root);

        leftClonedTreeHelper(root);

        System.out.println();

        inOrder(root);

        leftClonedTreeBackHelper(root);

        System.out.println();

        inOrder(root);
    }

    public static CharNode leftClonedTreeBackHelper(CharNode root) {
        if (root == null) {
            return null;
        }

        CharNode lnr = leftClonedTreeBackHelper(root.left.left);
        CharNode rnr = leftClonedTreeBackHelper(root.right);

        root.left = lnr;
        root.right = rnr;

        return root;
    }

    public static CharNode leftClonedTreeHelper(CharNode root) {
        if (root == null) {
            return null;
        }

        CharNode lnr = leftClonedTreeHelper(root.left);
        CharNode rnr = leftClonedTreeHelper(root.right);

        CharNode nn = new CharNode(root.data);
        nn.left = lnr;
        root.left = nn;
        root.right = rnr;

        return root;
    }

    public static void inOrder(CharNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
}