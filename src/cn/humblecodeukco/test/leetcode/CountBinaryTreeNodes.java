package cn.humblecodeukco.test.leetcode;

import cn.humblecodeukco.test.DataStructure.TreeNode;

/**
 * @Author lyr
 * @Date 2020/11/24 12:50
 * @Version 1.0
 * @Description 222. 完全二叉树的节点个数
 */
public class CountBinaryTreeNodes {
    /**
     * 二分查找 + 位运算
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) { return 0; }
        int level = 0;
        TreeNode node = root;
        while (node.left != null) {
            level++;
            node = node.left;
        }
        int low = 1 << level, high = (1 << (level + 1)) - 1;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (exists(root, level, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
    public boolean exists(TreeNode root, int level, int k) {
        int bits = 1 << (level - 1);
        TreeNode node = root;
        while (node != null && bits > 0) {
            if ((bits & k) == 0) { node = node.left; }
            else { node = node.right; }
            bits >>= 1;
        }
        return node != null;
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public int countNodes2(TreeNode root) {
        if (root == null) { return 0; }
        return countNodes2(root.left) + countNodes2(root.right) + 1;
    }

    public int countNodes3(TreeNode root) {
        if (root == null) { return 0; }
        int left = countLevel(root.left);
        int right = countLevel(root.right);
        if (left == right) { return countNodes3(root.right) + (1 << left); }
        else { return countNodes3(root.left) + (1 << right); }
    }
    private int countLevel(TreeNode root) {
        int level = 0;
        while (root != null) {
            level++;
            root = root.left;
        }
        return level;
    }
}
