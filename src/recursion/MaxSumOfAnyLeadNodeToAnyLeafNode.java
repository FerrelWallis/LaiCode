package recursion;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MaxSumOfAnyLeadNodeToAnyLeafNode {
    //Given a binary tree in which each node contains an int number.
    //
    //Find the maximum possible sum from any leaf node to another leaf node.
    //
    //The maximum sum path may or may not go through root.
    //
    //Expected time complexity is O(n).

    // recursion
    //base case: 本身叶子节点返回node.key, 如果本身为null返回0 (但是后续不会用上)
    // 1. 问左右子树他们到其所有叶子节点路径之和最大的值，ask left and right for their maxSum of path of leafnode
    //      leftpath , rightpath
    // 2. 当该节点左右子树都存在叶节点时（即cur.left != null && cur.right != null）,
    //      max = Math.max(max, node.key + leftpath + rightpath)
    // 3. 返回较大的一条路径之和 cur.val + max（leftpath,rightpath）

    //time = O(height) space O(1)

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-1);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(-5);
        root.left.left.right = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(10);
        root.right.left.right = new TreeNode(1);
        MaxSumOfAnyLeadNodeToAnyLeafNode test = new MaxSumOfAnyLeadNodeToAnyLeafNode();
        System.out.println(test.maxSum(root));
    }

    public int maxSum(TreeNode root) {
        int[] max = new int[1];
        helper(root, max);
        return max[0];
    }

    public int helper(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return root.key;
        }
        int leftPath = helper(root.left, max);
        int rightPath = helper(root.right, max);
        if (root.left != null && root.right != null) {
            max[0] = Math.max(max[0], leftPath + rightPath + root.key);
        }
        if (root.left != null && root.right != null) {
            return Math.max(leftPath, rightPath) + root.key;
        } else {
            return (root.left == null ? rightPath : leftPath) + root.key;
        }
    }


}
