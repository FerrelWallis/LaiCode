import java.util.TreeMap;

public class StoreNumberOfNodesInLeftSubtree_646 {
    //Given a binary tree, count the number of nodes in each node’s left subtree, and store it in the numNodesLeft field.
    //Examples
    //                  1(6)
    //
    //               /          \
    //
    //           2(3)        3(0)
    //
    //          /      \
    //
    //      4(1)     5(0)
    //
    //    /        \        \
    //
    //6(0)     7(0)   8(0)
    //The numNodesLeft is shown in parentheses.

    //1. what you want from lsub rsub
    //2. what to do in current level
    //3. what to report to parent

    //time O(node of tree) space O(height)
    public void numNodesLeft(TreeNodeLeft root) {
        helper(root);
    }

    private int helper(TreeNodeLeft root) {
        if (root == null) {
            return 0;
        }
        int lnum = helper(root.left);
        int rnum = helper(root.right);
        root.numNodesLeft = lnum;
        return lnum + rnum + 1; //report给parent的时候不要忘记把本身加上！！！
    }

    public class TreeNodeLeft {
        public int key;
        public TreeNodeLeft left;
        public TreeNodeLeft right;
        public int numNodesLeft;
        public TreeNodeLeft(int key) {
            this.key = key;
        }
    }

}
