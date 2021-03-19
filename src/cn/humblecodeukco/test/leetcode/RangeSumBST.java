package cn.humblecodeukco.test.leetcode;

import cn.humblecodeukco.test.DataStructure.TreeNode;

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
            else if (low < root.val) { dfs(root.left, low, high); }
            else if (root.val < high) { dfs(root.right, low, high); }
        }
    }
}
