package recursion;

import sun.reflect.generics.tree.Tree;
import utils.TreeNode;

public class FlattenBinaryTreetoLinkedList_523 {
    //Given a binary tree, flatten it to a linked list in-place.
    //For example,Given
    //         1
    //        / \
    //       2   5
    //      / \   \
    //     3   4   6
    //The flattened tree should look like:
    //   1
    //    \
    //     2
    //      \
    //       3
    //        \
    //         4
    //          \
    //           5
    //            \
    //             6

    //preorder 解决
    //根左右
    //prev.right = root
    //root.left = null
    //drill down root.left
    //drill down root.right
    //因为这里root的left和right可能会在flatten过程中改变，因此在flatten之前先记录一下left,right
    public TreeNode flatten(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode[] prev = new TreeNode[1];
        helper(root, prev);
        return root;
    }

    private void helper(TreeNode root, TreeNode[] prev) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (prev[0] != null) {
            prev[0].right = root;
        }
        root.left = null;
        helper(root.left, prev);
        helper(root.right, prev);
    }


}
