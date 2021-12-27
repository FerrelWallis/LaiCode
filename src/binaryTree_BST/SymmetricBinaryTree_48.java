package binaryTree_BST;

public class SymmetricBinaryTree_48 {

    //         5
    //      /    \
    //    3        3
    //  /   \    /   \
    //1      4  4      1

    //1. need to have the root of two subtree that we wana to check
    //if root == null => return true
    //checkSys(root.left, root.right)

    //recursion
    //1. what we need to do in cur level?
    //   if root1.val != root2.val => return false
    //   else return isSy(root1.left, root2.right) && isSy(root1.right, root2.left)
    //2. what we need to report?
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            if (root1 == null && root2 == null) {
                return true;
            } else {
                return false;
            }
        }
        if (root1.key != root2.key) {
            return false;
        } else {
            return isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
        }
    }

}
