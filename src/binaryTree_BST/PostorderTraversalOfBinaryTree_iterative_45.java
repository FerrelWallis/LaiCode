package binaryTree_BST;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PostorderTraversalOfBinaryTree_iterative_45 {


    //left right root
    //         5
    //      /    \
    //    3        8
    //  /   \        \
    //1      4        11

    //[]    5 8 11 3 4 1
    // 1 4 3 11 8 5

    //1. do the reserved post traversal using stack
    //  root right left
    //  1) pop ele out from stack
    //  2) add val ele into ans
    //  3) put the left child first and right child next into stack
    //jump out while when stack is empty
    //2. reverse the order into postorder
    public List<Integer> postOrder(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        Deque<Integer> reverse = new ArrayDeque<>();
        stack.offerLast(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pollLast();
            reverse.offerLast(cur.key);
            if (cur.left != null) {
                stack.offerLast(cur.left);
            }
            if (cur.right != null) {
                stack.offerLast(cur.right);
            }
        }
        while (!reverse.isEmpty()) {
            ans.add(reverse.pollLast());
        }
        return ans;
    }
}
