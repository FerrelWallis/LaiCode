package binaryTree_BST;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversalOfBinaryTree_recursive_654 {

    //left root right
    //n space O(logn) O(n) best
    //n space O(n) O(n)
    public List<Integer> inOrder(TreeNode root) {
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
        helper(ans, root.left);
        ans.add(root.key);
        helper(ans, root.right);
    }

}
