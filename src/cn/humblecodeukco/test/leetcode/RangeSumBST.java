package cn.humblecodeukco.test.leetcode;

import cn.humblecodeukco.test.DataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author lyr
 * @Date 2021/3/18 16:08
 * @Version 1.0
 * @Description 938. 二叉搜索树的范围和
 */
public class RangeSumBST {
    int ans = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) { return ans; }
        dfs(root, low, high);
        return ans;
    }
    private void dfs(TreeNode root, int low, int high) {
        if (root != null) {
            if (low <= root.val && root.val <= high) { ans += root.val; }
            if (low < root.val) { dfs(root.left, low, high); }
            if (root.val < high) { dfs(root.right, low, high); }
        }
    }

    /**
     * 深度优先搜索
     * @param root
     * @param low
     * @param high
     * @return
     */
    public int rangeSumBST2(TreeNode root, int low, int high) {
        if (root == null) { return 0; }
        if (root.val > high) { return rangeSumBST2(root.left, low, high); }
        if (root.val < low) { return rangeSumBST2(root.right, low, high); }
        return root.val + rangeSumBST2(root.left, low, high) + rangeSumBST2(root.right, low, high);
    }

    /**
     * 广度优先搜索
     * @param root
     * @param low
     * @param high
     * @return
     */
    public int rangeSumBST3(TreeNode root, int low, int high) {
        int sum = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) { continue; }
            if (node.val > high) { q.offer(node.left); }
            else if (node.val < low) { q.offer(node.right); }
            else {
                sum += node.val;
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        return sum;
    }
}
