public class LowestCommonAncestorI_126 {
    //Given two nodes in a binary tree, find their lowest common ancestor.
    //
    //Assumptions
    //
    //There is no parent pointer for the nodes in the binary tree
    //
    //The given two nodes are guaranteed to be in the binary tree
    //
    //Examples
    //
    //        5
    //
    //      /   \
    //
    //     9     12
    //
    //   /  \      \
    //
    //  2    3      14
    //
    //The lowest common ancestor of 2 and 14 is 5
    //
    //The lowest common ancestor of 2 and 9 is 9

    //base case: root = a || root == b || root == null -> return root
    //case 1: a b 是直接隶属
    //      case 1.1: 一边为null, 一边非null 返回not null
    //      case 1.2: 两边为null 返回null
    //      case 1.3：两边非null不存在
    //case 2：a b 不是直接隶属
    //      case 2.1: 一边为null, 一边非null 返回not null
    //      case 2.2: 两边为null 返回null
    //      case 2.3: 两边非null return root

    //time O(node of the tree) space O(height)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null || root == a || root == b) { //base case
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, a, b);
        TreeNode right = lowestCommonAncestor(root.right, a, b);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
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
