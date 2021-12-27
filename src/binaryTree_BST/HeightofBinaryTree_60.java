package binaryTree_BST;

public class HeightofBinaryTree_60 {

    //recursion
    //1.if root = null return 0

    //base case if curroot == null => return 0

    //1. what we can get from left and right children
    //      height of left and right subtree
    //2. what we need to do in current level?
    //      height of current = max(leftheight, rightheight) + 1
    //3. what we need to report to the parent node?
    //      return height pf current

    //time O(n) space  O(logn) balanced / O(n) link
    public int findHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = findHeight(root.left);
        int right = findHeight(root.right);
        return Math.max(left, right) + 1;
    }

}
