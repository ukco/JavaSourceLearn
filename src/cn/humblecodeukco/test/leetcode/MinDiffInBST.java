package cn.humblecodeukco.test.leetcode;

import cn.humblecodeukco.test.DataStructure.TreeNode;

/**
 * @Author lyr
 * @Date 2021/4/13 14:41
 * @Version 1.0
 * @Description 783. 二叉搜索树节点最小距离
 */
public class MinDiffInBST {

    int pre;
    int ans;

    /**
     * 中序遍历
     * @param root
     * @return
     */
    public int minDiffInBST(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }
    private void dfs(TreeNode root) {
        if (root == null) { return; }
        dfs(root.left);
        if (pre == -1) { pre = root.val; }
        else {
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }
}
