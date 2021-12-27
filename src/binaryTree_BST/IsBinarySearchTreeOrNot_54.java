package binaryTree_BST;

public class IsBinarySearchTreeOrNot_54 {

    //BST: all nodes in left subtree are < root val < all noeds in right subtree
    //no duplicate, no max min integer val
    //root == null => return true

    //recursion
    //base case: root == null return true
    //             10           [MIN, MAX]
    //          /       \
    //[MIN,10] 8         13 [10, MAX]
    //        /   \    /   \
    //      6      9  11    16
    //[MIN,8] [8, 10] [10, 13] [13, MAX]

    //the law of range of left right child value
    //range of left child: [left, parent.val]
    //range of right child: [parent.val, right]
    public boolean isBST(TreeNode root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean checkBST(TreeNode root, int left, int right) {
        if (root == null) {
            return true;
        }
        if (root.key <= left || root.key >= right) {
            return false;
        }
        return checkBST(root.left, left, root.key) && checkBST(root.right, root.key, right);
    }


}
