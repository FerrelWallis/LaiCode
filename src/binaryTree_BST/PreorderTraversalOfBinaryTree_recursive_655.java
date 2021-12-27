package binaryTree_BST;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversalOfBinaryTree_recursive_655 {

    //root left right
    //base case if root == null => reach the leaf node of the three
    //1. put root into the list
    //2. drill down to the level send root.left
    //3. drill down to the level with root.right

    //n O(n) space O(logn) average
    //n O(n) space O(n) worst linked like
    public List<Integer> preOrder(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
           return ans;
        }
        helper(ans, root);
        return ans;
    }

    public void helper(List<Integer> ans, TreeNode root) {
        if (root == null) {
            return;
        }
        ans.add(root.key);
        helper(ans, root.left);
        helper(ans, root.right);
    }

}
