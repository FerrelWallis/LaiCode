package binaryTree_BST;

public class SearchInBinarySearchTree_52 {

    //BST
    //key < root.key => search in left subtree
    //key > root.key => search in right subtree
    //key == root.key => return root

    //base case: root == null => return null

    //recursion
    public TreeNode search(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key == root.key) {
            return root;
        } else if (key < root.key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    //iterative
    public TreeNode search2(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        while (root != null && root.key != key) {
            root = key < root.key ? root.left : root.right;
        }
        return root;
    }

}
