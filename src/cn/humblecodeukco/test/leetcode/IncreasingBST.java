package cn.humblecodeukco.test.leetcode;

import cn.humblecodeukco.test.DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lyr
 * @Date 2021/4/25 15:48
 * @Version 1.0
 * @Description 897. 递增顺序搜索树
 */
public class IncreasingBST {
    /**
     * 中序遍历之后生成新的树
     * @param root
     * @return
     */
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);

        TreeNode dummyNode = new TreeNode(-1);
        TreeNode currNode = dummyNode;
        for (int value : res) {
            currNode.right = new TreeNode(value);
            currNode = currNode.right;
        }
        return dummyNode.right;
    }
    private void inorder(TreeNode node, List<Integer> res) {
        if (node == null) { return; }

        inorder(node.left, res);
        res.add(node.val);
        inorder(node.right, res);
    }

    private TreeNode resNode;

    /**
     * 在中序遍历的过程中改变节点指向
     * @param root
     * @return
     */
    public TreeNode increasingBST2(TreeNode root) {
        TreeNode dummyNdoe = new TreeNode(-1);
        resNode = dummyNdoe;
        inorder2(root);
        return dummyNdoe.right;
    }
    private void inorder2(TreeNode node) {
        if (node == null) { return; }

        inorder2(node.left);
        // 在中序遍历的过程中修改节点指向
        resNode.right = node;
        node.left = null;
        resNode = node;
        inorder2(node.right);
    }
}
