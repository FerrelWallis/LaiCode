package recursion;

import utils.TreeNode;

import java.util.HashMap;
import java.util.HashSet;

public class ReconstructBinaryTreeWithPreorderAndInorder_213 {
    //Given the preorder and inorder traversal sequence of a binary tree, reconstruct the original tree.

    //Assumptions
    //The given sequences are not null and they have the same length
    //There are no duplicate keys in the binary tree

    //Examples
    //preorder traversal = {5, 3, 1, 4, 8, 11}
    //inorder traversal = {1, 3, 4, 5, 8, 11}
    //the corresponding binary tree is
    //        5
    //      /    \
    //    3        8
    //  /   \        \
    //1      4        11

    //How is the binary tree represented?
    //We use the pre order traversal sequence with a special symbol "#" denoting the null node.

    //For Example:
    //The sequence [1, 2, #, 3, 4, #, #, #] represents the following binary tree:
    //    1
    //  /   \
    // 2     3
    //      /
    //    4

    //preoder + inorder
    //1. preorder 的第一个元素肯定就是root
    //2. 将root在inorder中找到对应index，其左边node的数量（左边界到index的数量）即为该root左子树节点的数量
    //3. 将找到的leftnum放到preorder中，root往后数leftnum个就是preorder中root左子树的节点

    //建立一个HashMap记录inorder的value和index， 记录preorder和inorder的左右边界
    //time O(n) space O(n)
    public TreeNode reconstruct(int[] in, int[] pre) {
        HashMap<Integer, Integer> inorder = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            inorder.put(in[i],i);
        }
        return consHelper(in, 0, in.length - 1, pre, 0, pre.length, inorder);
    }

    private TreeNode consHelper(int[] in, int inleft, int inright, int[] pre, int preleft, int preright, HashMap<Integer, Integer> inorder) {
        if (inleft > inright) {
            return null;
        }
        int rootval = pre[preleft];
        TreeNode root = new TreeNode(rootval);
        int inRootIndex = inorder.get(rootval);
        int leftnum = inRootIndex - inleft;
        root.left = consHelper(in, inleft, inRootIndex - 1, pre, preleft + 1, preleft + leftnum, inorder);
        root.right = consHelper(in, inRootIndex + 1, inright, pre, preleft + leftnum + 1, preright, inorder);
        return root;
    }

}
