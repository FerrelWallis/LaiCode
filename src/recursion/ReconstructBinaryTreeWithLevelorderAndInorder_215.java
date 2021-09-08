package recursion;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReconstructBinaryTreeWithLevelorderAndInorder_215 {
    //Given the levelorder and inorder traversal sequence of a binary tree, reconstruct the original tree.

    //Assumptions
    //The given sequences are not null and they have the same length
    //There are no duplicate keys in the binary tree

    //Examples
    //levelorder traversal = {5, 3, 8, 1, 4, 11}
    //inorder traversal = {1, 3, 4, 5, 8, 11}
    //the corresponding binary tree is
    //        5
    //      /    \
    //    3        8
    //  /   \        \
    //
    //1      4        11

    //How is the binary tree represented?
    //We use  level order traversal sequence with a special symbol "#" denoting the null node.

    //For Example:
    //The sequence [1, 2, 3, #, #, 4] represents the following binary tree:
    //    1
    //  /   \
    // 2     3
    //      /
    //    4

    //给了inorder和levelorder levelorder因为没有明确的左右元素边界，因此需要根据inorder手动挑沙子归类出左边元素和右边元素
    //root肯定是levelorder的第一个元素
    //time O(n^2) space O(n)
    public TreeNode reconstruct(int[] in, int[] lev) {
        //1. 先将levelorder建成一个list方便后面挑沙子break into 2 list
        //2. 将inorder建成一个value,index的hashmap
        List<Integer> level = new ArrayList<>();
        for (int i = lev.length - 1; i >= 0; i--) { //O(n)
            level.add(i);
        }
        HashMap<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < in.length; i++) { //O(n)
            inMap.put(in[i], i);
        }
        return helper(level, inMap); //O（n^2）
    }

    public TreeNode helper(List<Integer> level, HashMap<Integer, Integer> inMap) {
        if (level.isEmpty()) {
            return null;
        }
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int rootval = level.remove(level.size() - 1); //O(1) 但不影响因为后面有O（n）逃不掉的
        TreeNode root = new TreeNode(rootval);
        int rootindex = inMap.get(rootval);
        for (int l : level) {
            if (inMap.get(l) < rootindex) {
                left.add(l);
            } else {
                right.add(l);
            }
        }
        root.left = helper(left, inMap);
        root.right = helper(right, inMap);
        return root;
    }


}
