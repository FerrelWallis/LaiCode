package recursion;
import utils.TreeNode;

public class MaximumPathSumBinaryTreeIII_140 {
    //Given a binary tree in which each node contains an integer number.
    //Find the maximum possible subpath sum(both the starting and ending node of the subpath
    //should be on the same path from root to one of the leaf nodes, and the subpath is allowed
    //to contain only one node).

    //Assumptions: The root of given binary tree is not null
    //Examples
    //   -5
    //  /    \
    //2      11
    //     /    \
    //    6     14
    //           /
    //        -3

    //The maximum path sum is 11 + 14 = 25
    //How is the binary tree represented?
    //We use the level order traversal sequence with a special symbol "#" denoting the null node.

    //For Example: The sequence [1, 2, 3, #, #, 4] represents the following binary tree:
    //    1
    //  /   \
    // 2     3
    //      /
    //    4

    //record the curmaxsum ending in current node from root--> dp
    //if prefix < 0 , curmaxsum = root.key
    //else curmaxSum = prefix + root.key
    //compare with globalmax
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] globalmax = new int[1];
        globalmax[0] = Integer.MIN_VALUE;
        preOrder(root, globalmax, 0);
        return globalmax[0];
    }

    private void preOrder(TreeNode root, int[] globalmax, int prefix) {
        if (root == null) {
            return;
        }
        int cur = prefix < 0 ? root.key : prefix + root.key;
        globalmax[0] = Math.max(globalmax[0], cur);
        preOrder(root.left, globalmax, cur);
        preOrder(root.right, globalmax, cur);
    }


}
