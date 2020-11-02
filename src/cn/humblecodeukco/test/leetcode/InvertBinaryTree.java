package cn.humblecodeukco.test.leetcode;

import cn.humblecodeukco.test.DataStructure.TreeNode;

/**
 * @Author lyr
 * @Date 2020/11/2 18:20
 * @Version 1.0
 * @Description 226
 */
public class InvertBinaryTree {
}

class InvertBinaryTreeSolution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}