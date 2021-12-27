package binaryTree_BST;

public class TweakedIdenticalBinaryTrees_50 {

    //         5
    //      /    \
    //    3        8
    //  /   \
    // 1      4

    //         5
    //      /    \
    //    8        3
    //           /   \
    //          1     4

    //1. root of 2 tree is identical
    //2. root1.left == root2.left && root1.right == root2.right
    //  ||
    //   root1.left == root2.right && root1.right == root2.left
    // one && two is null return true
    //
    public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
        if (one == null || two == null) {
            if (one == null && two == null) {
                return true;
            } else {
                return false;
            }
        }
        if (one.key != two.key) {
            return false;
        }
        return (isTweakedIdentical(one.left, two.left) && isTweakedIdentical(one.right, two.right)) ||
                (isTweakedIdentical(one.left, two.right) && isTweakedIdentical(one.right, two.left));
    }
}
