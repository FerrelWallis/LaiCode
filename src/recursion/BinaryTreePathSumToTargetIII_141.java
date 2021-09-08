package recursion;

import utils.TreeNode;

import java.util.HashSet;

public class BinaryTreePathSumToTargetIII_141 {
    //Given a binary tree in which each node contains an integer number.
    //Determine if there exists a path (the path can only be from one node to itself or
    //to any of its descendants), the sum of the numbers on the path is the given target number.

    //Examples
    //    5
    //  /    \
    //2      11
    //     /    \
    //    6     14
    //  /
    // 3

    //If target = 17, There exists a path 11 + 6, the sum of the path is target.
    //If target = 20, There exists a path 11 + 6 + 3, the sum of the path is target.
    //If target = 10, There does not exist any paths sum of which is target.
    //If target = 11, There exists a path only containing the node 11.
    //How is the binary tree represented?
    //We use the level order traversal sequence with a special symbol "#" denoting the null node.

    //For Example:
    //The sequence [1, 2, 3, #, #, 4] represents the following binary tree:
    //    1
    //  /   \
    // 2     3
    //      /
    //    4

    //recursion + dp path prefix
    //Hashset to store a node's all prefix
    //cursum = prefix + root.key

    //time O(n) space O()
    public static void main(String[] args) {
        BinaryTreePathSumToTargetIII_141 test = new BinaryTreePathSumToTargetIII_141();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(-8);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        root.left.right = new TreeNode(10);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(-5);
        System.out.println(test.exist(root, 6));
    }

    public boolean exist(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        HashSet<Integer> prefix = new HashSet<Integer>();
        prefix.add(0); //因为本身也算
        return preOrder(root, prefix, 0, target);
    }

    private boolean preOrder(TreeNode root, HashSet<Integer> allprefix, int prefix, int target) {
        int cursum = prefix + root.key;
        if (allprefix.contains(cursum - target)) {
            return true;
        }
        boolean addflag = allprefix.add(cursum);
        if (root.left != null && preOrder(root.left, allprefix, cursum, target)) {
            return true;
        }
        if (root.right != null && preOrder(root.right, allprefix, cursum, target)) {
            return true;
        }
        if (addflag) {
            allprefix.remove(cursum);
        }
        return false;
    }


}
