package binaryTree_BST;

public class InsertInBinarySearchTree_51 {

    //         5                insert 11
    //      /    \
    //    3        8
    //  /   \        \
    // 1     4        11

    //recursion
    //corner case: root = null return TreeNode key

    //if root.key == key => return root
    //if root.key > key => root.left = insert(root.left, key)
    //if root.key < key => root.right = insert(root.right, key)
    //base case: root == null return TreeNode key
    public TreeNode insert(TreeNode root, int key) {
        if (root == null) {
            return new TreeNode(key);
        }
        if (root.key > key) {
            root.left = insert(root.left, key);
        } else if (root.key < key){
            root.right = insert(root.right, key);
        }
        return root;
    }

    public TreeNode insert2(TreeNode root, int key) {
        if (root == null) {
            return new TreeNode(key);
        }
        TreeNode cur = root;
        while (cur != null) {
            if (cur.key == key) {
                return root;
            } else if (cur.key > key) {
                if (cur.left == null) {
                    cur.left = new TreeNode(key);
                    break;
                }
                cur = cur.left;
            } else {
                if (cur.right == null) {
                    cur.right = new TreeNode(key);
                    break;
                }
                cur = cur.right;
            }
        }
        return root;
    }

}
