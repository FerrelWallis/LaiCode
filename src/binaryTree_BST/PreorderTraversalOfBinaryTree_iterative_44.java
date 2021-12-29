package binaryTree_BST;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PreorderTraversalOfBinaryTree_iterative_44 {

    //preorder: root left right
    //         5
    //      /    \
    //    3        8
    //  /   \        \
    //1      4        11

    //stack
    //right left
    //[11]   5 3 1 4 8 11
    //pop 5 to ans, add 5.right = 8, 5.left = 3
    //pop 3 to ans, add 3.right = 4 , 3.left = 1;
    //pop 1 to ans, 1 with no child
    //pop 4 to ans, no child
    //pop 8 to ans, add 8.right = 11
    //pop 11 to ans

    //pop out top ele and add the chidren of this ele into the stack in the order: right left
    public List<Integer> preOrder(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offerLast(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pollLast();
            ans.add(cur.key);
            if (cur.right != null) {
                stack.offerLast(cur.right);
            }
            if (cur.left != null) {
                stack.offerLast(cur.left);
            }
        }
        return ans;
    }

}
