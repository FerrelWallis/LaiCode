package binaryTree_BST;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class InorderTraversalOfBinaryTree_iterative_43 {

    //left root right
    //cla: root == null => return empty list

    //         5
    //      /    \
    //    3        8
    //  /   \        \
    //1      4        11
    //iterative
    //use: stack
    // [5 4]   [1 3 4]
    //TreeNode helper = root
    //helper = null : pop 1 add to ans, helper = 1.right
    //helper = null : pop 3 to ans, helper = 3.right
    //hlper = 4: push 4 to stack and helper.4.left
    //4.left = null: pop 4 add to ans

    //helper == null => pop ele out from stack add to ans, and helper = ele.right
    //helper != null => push ele into stack, helper = ele.left
    public List<Integer> inOrder(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode helper = root;
        while (!stack.isEmpty() || helper != null) {
            if (helper == null) {
                TreeNode cur = stack.pollLast();
                ans.add(cur.key);
                helper = cur.right;
            } else {
                stack.offerLast(helper);
                helper = helper.left;
            }
        }
        return ans;
    }
}
