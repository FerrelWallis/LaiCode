package recursion;

import utils.TreeNode;

public class MaximumPathSumBinaryTreeII_139 {
    //Given a binary tree in which each node contains an integer number.
    //Find the maximum possible sum from any node to any node (the start node and the end node can be the same).

    //Assumptions : The root of the given binary tree is not null
    //Examples
    //   -1
    //  /    \
    //2      11
    //     /    \
    //    6    -14

    //one example of paths could be -14 -> 11 -> -1 -> 2
    //another example could be the node 11 itself
    //The maximum path sum in the above binary tree is 6 + 11 + (-1) + 2 = 18
    //How is the binary tree represented?
    //We use the level order traversal sequence with a special symbol "#" denoting the null node.

    //For Example: The sequence [1, 2, 3, #, #, 4] represents the following binary tree:
    //    1
    //  /   \
    // 2     3
    //      /
    //    4

    //recursion 人字形三部曲
    //1. leftmaxpath rightmaxpath
    //2. if(left < 0) left = 0 else left = left
    //   if(right < 0) right = 0 else right = right
    //   max = max(max, root + left + right)
    //3. return max(left, right) + root.key

    //time O(n) space O(height)
    public int maxSumAny2Any(TreeNode root) {
        int[] globalmax = new int[1];
        helper(root, globalmax);
        return globalmax[0];
    }

    private int helper(TreeNode root, int[] globalmax) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left, globalmax);
        int right = helper(root.right, globalmax);
        left = left < 0 ? 0 : left;
        right = right < 0 ? 0 : right;
        globalmax[0] = Math.max(globalmax[0], left + right + root.key);
        return Math.max(left, right) + root.key;
    }




}
