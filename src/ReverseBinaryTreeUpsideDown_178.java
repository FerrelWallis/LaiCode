public class ReverseBinaryTreeUpsideDown_178 {
    //Given a binary tree where all the right nodes are leaf nodes, flip it upside down and turn it into
    //a tree with left leaf nodes as the root.
    //
    //Examples
    //
    //        1
    //
    //      /    \
    //
    //    2        5
    //
    //  /   \
    //
    //3      4
    //
    //is reversed to
    //
    //        3
    //
    //      /    \
    //
    //    2        4
    //
    //  /   \
    //
    //1      5


    //time O(height) space O(height)
    public TreeNode reverse(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        TreeNode newroot = reverse(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return newroot;
    }

    //iterative way
    public TreeNode reverse2(TreeNode root) {
        TreeNode preleft = null;
        TreeNode preright = null;
        while (root != null) {
            TreeNode next = root.left;
            TreeNode right = root.right;
            root.left = preleft;
            root.right = preright;
            preright = right;
            preleft = root;
            root = next;
        }
        return preleft;
    }


    public class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int key) {
            this.key = key;
        }
    }
}
