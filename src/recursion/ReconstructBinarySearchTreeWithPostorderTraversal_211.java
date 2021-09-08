package recursion;

import utils.TreeNode;

public class ReconstructBinarySearchTreeWithPostorderTraversal_211 {
    //Given the postorder traversal sequence of a binary search tree, reconstruct the original tree.

    //Assumptions
    //The given sequence is not null
    //There are no duplicate keys in the binary search tree
    //Examples

    //postorder traversal = {1, 4, 3, 11, 8, 5}
    //the corresponding binary search tree is
    //        5
    //      /    \
    //    3        8
    //  /   \        \
    //1      4        11

    //How is the binary tree represented?
    //We use the pre order traversal sequence with a special symbol "#" denoting the null node.

    //For Example: The sequence [1, 2, #, #, 3, 4, #, #, #] represents the following binary tree:
    //    1
    //  /   \
    // 2     3
    //      /
    //    4

    //postorder + bst(inorder is is ascending order)
    //post左右根 因此最右边肯定是当前root，给定一个全局变量index从右往左撸，挂到parent的右边，直到遇到比之前root小的值，return null
    //                                                 index从右往左继续撸，挂到parent的左边，直到index == 0 return null
    public TreeNode reconstruct(int[] post) {
        int[] index = new int[1];
        index[0] = post.length - 1;
        return helper(post, index, Integer.MIN_VALUE);
    }

    private TreeNode helper(int[] post, int[] index, int min) {
        if (index[0] < 0 || post[index[0]] < min) {
            return null;
        }
        int rootval = post[index[0]--];
        TreeNode root = new TreeNode(rootval);
        root.right = helper(post, index, rootval);
        root.left = helper(post, index, min);
        return root;
    }

}
