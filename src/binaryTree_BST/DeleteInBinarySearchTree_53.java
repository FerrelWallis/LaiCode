package binaryTree_BST;

public class DeleteInBinarySearchTree_53 {

    //          11
    //       /       \
    //      5         15
    //     / \        / \
    //    1   9      13  18
    //       / \
    //      7   10

    //delete target
    //1. target no child => dele
    //2. left child => put target.left to the pos of target
    //3. right child => put target.right to the pos of traget
    //4. both child => find the smallest ele in the target.right
    //1) right subtree doesn't have left child => target.right to take over target.left
    //2) right subtree has left child =>
    // find smallest ele(left most ele) to take over both traget.left target.right
    // need to pay attention that left most ele may has right child

    //1. find target
    //base case: when root == null => return null
    //1. if root.val == val => return delete(root)
    //2. if root.val > val => root.left = deleteTree(root.left, target) return root
    //3. if root.val < val => root.right = deleteTree(root.right, target) return root
    public TreeNode deleteTree(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        if (root.key == target) {
            return delete(root);
            //return a new root of current tree and report to the parent node
        } else if (root.key > target) {
            root.left = deleteTree(root.left, target);
            return root;
        } else {
            root.right = deleteTree(root.right, target);
            return root;
        }
    }

    public TreeNode delete(TreeNode root) {
        if (root.left == null && root.right == null) {
            return null;
        } else if (root.left == null || root.right == null) {
            return root.left == null ? root.right : root.left;
        }
        //find smallest ele in right subtree
        if (root.right.left == null) {
            root.right.left = root.left;
            return root.right;
        } else {
            TreeNode smallest = findSmallest(root.right);
            smallest.left = root.left;
            smallest.right = root.right;
            return smallest;
        }
    }

    public TreeNode findSmallest(TreeNode root) {
        TreeNode pre = root;
        TreeNode cur = root.left;
        while (cur.left != null) {
            pre = cur;
            cur = cur.left;
        }
        pre.left = cur.right;
        return cur;
    }



}
