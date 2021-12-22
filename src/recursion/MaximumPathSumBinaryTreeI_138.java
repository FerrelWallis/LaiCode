package recursion;

public class MaximumPathSumBinaryTreeI_138 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-91);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        MaximumPathSumBinaryTreeI_138 test = new MaximumPathSumBinaryTreeI_138();
        System.out.println(test.maxPathSum(root));
    }

    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        find(root, max);
        return max[0];
    }

    public int find(TreeNode root, int[] max) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        //case1: leaf node
        if (root.left == null && root.right == null) {
            return root.key;
        }
        int left = maxPathSum(root.left);
        int right = maxPathSum(root.right);
        if (root.left != null && root.right != null) {
            max[0] = Math.max(root.key + left + right, max[0]);
            return root.key + Math.max(left, right);
        }
        //case 2:只有一个
        if (root.left == null) {
            return root.key + right;
        } else {
            return root.key + left;
        }
    }
}
