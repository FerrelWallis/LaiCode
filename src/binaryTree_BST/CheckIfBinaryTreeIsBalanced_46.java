package binaryTree_BST;

public class CheckIfBinaryTreeIsBalanced_46 {

    //balanced: diff of hei of left & right subtree <= 1
    //1. root == null => true

    //recursion
    //1. what we can get from left right children?
    //      height of left right subtree
    //2. what we need to do in current level?
    //      check balance
    //      if lefthei or righthei == -1 => curentheight = -1
    //      else if abs(lefthei - righthei) > 1 => curentheight = -1
    //      else currentheight = max(lefthei,righthei) + 1
    //3. what we need to report to the parent node?
    //       if subtree is unbalanced => return -1
    //       else return height of the current tree

    //time O(n) space O(height)
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root) == -1 ? false : true;
    }

    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        int height = -1;
        if (left != -1 && right != -1 && Math.abs(left - right) <= 1) {
            height = Math.max(left, right) + 1;
        }
        return height;
    }


}
