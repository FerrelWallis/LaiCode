package recursion;

import utils.TreeNode;

public class MaxSumOfAnyNodeToAnyNode {

    public static void main(String[] args) {
        MaxSumOfAnyNodeToAnyNode test = new MaxSumOfAnyNodeToAnyNode();
        TreeNode root = new TreeNode(-91);
        root.left = new TreeNode (83);
        root.right = new TreeNode(66);
        test.maxPathSum(root);
    }

    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        helper(root, max);
        return max[0];
    }

    public int helper(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int leftpath = helper(root.left, max);
        int rightpath = helper(root.right, max);
        if (leftpath < 0) {
            leftpath = 0;
        }
        if (rightpath < 0) {
            rightpath = 0;
        }
        max[0] = Math.max(max[0], leftpath + rightpath + root.key);
        return root.key + Math.max(leftpath, rightpath);
    }


}
