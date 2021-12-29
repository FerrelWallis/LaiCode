package binaryTree_BST;

import java.util.ArrayList;
import java.util.List;

public class GetKeysInBinarySearchTreeInGivenRange_55 {

    //BST: LEFT < ROOT < RIGHT
    //we can preorder traversal the BST
    //          10
    //        /   \
    //       6     13
    //      / \    / \
    //     3   8  12 16
    //    / \  /
    //   1  4  7
    //                  [0, 7]
    // base case: root == null => return
    // 1. if cur.key > min, then drill down to left subtree
    // 2. if (cur.key >= min || cur.key <= max) add to ans
    // 3. if cur.key < max, then drill down to right subtree

    public List<Integer> getRange(TreeNode root, int min, int max) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        preorder(ans, root, min, max);
        return ans;
    }

    public void preorder(List<Integer> ans, TreeNode root, int min, int max) {
        if (root == null) {
            return;
        }
        if (root.key > min) {
            preorder(ans, root.left, min, max);
        }
        if (root.key >= min && root.key <= max) {
            ans.add(root.key);
        }
        if (root.key < max) {
            preorder(ans, root.right, min, max);
        }
    }


}
