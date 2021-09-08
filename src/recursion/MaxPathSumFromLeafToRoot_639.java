package recursion;

import utils.TreeNode;

public class MaxPathSumFromLeafToRoot_639 {
    //Given a binary tree in which each node contains an integer number.
    //Find the maximum possible path sum from a leaf to root.

    //Assumptions: The root of given binary tree is not null.
    //Examples
    //         10
    //       /      \
    //    -2        7
    //  /     \
    //8      -4

    //The maximum path sum is 10 + 7 = 17.

    //prefixsum
    //max = Math.max(max, prefixsum + root.key);

    //time O(n) space O(height)
    public int maxPathSumLeafToRoot(TreeNode root) {
        int[] globalmax = new int[1];
        globalmax[0] = Integer.MIN_VALUE;
        helper(root, globalmax, 0);
        return globalmax[0];
    }

    private void helper(TreeNode root, int[] globalmax, int prefixSum) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            globalmax[0] = Math.max(globalmax[0], prefixSum + root.key);
            return;
        }
        helper(root.left, globalmax, prefixSum + root.key);
        helper(root.right, globalmax, prefixSum + root.key);
    }


}
