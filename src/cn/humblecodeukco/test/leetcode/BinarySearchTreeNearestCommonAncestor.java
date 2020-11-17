package cn.humblecodeukco.test.leetcode;

import cn.humblecodeukco.test.DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lyr
 * @Date 2020/11/17 17:15
 * @Version 1.0
 * @Description 235
 */
public class BinarySearchTreeNearestCommonAncestor {
    /**
     * 两次遍历
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path_p = getPath(root, p);
        List<TreeNode> path_q = getPath(root, q);
        TreeNode ancestor = null;
        for (int i = 0; i < path_p.size() && i < path_q.size(); ++i) {
            if (path_p.get(i) == path_q.get(i)) ancestor = path_p.get(i);
            else break;
        }
        return ancestor;
    }
    public List<TreeNode> getPath(TreeNode root, TreeNode target) {
        List<TreeNode> path = new ArrayList<>();
        TreeNode node = root;
        while (node != target) {
            path.add(node);
            if (target.val < node.val) node = node.left;
            else node = node.right;
        }
        path.add(node);
        return path;
    }

    /**
     * 一次遍历
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while (true) {
            if (p.val < ancestor.val && q.val < ancestor.val) ancestor = ancestor.left;
            else if (p.val > ancestor.val && q.val > ancestor.val) ancestor = ancestor.right;
            else break;
        }
        return ancestor;
    }

    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        if ((root.val - p.val) * (root.val - q.val) <= 0) return root;
        else if (root.val < p.val && root.val < q.val) return lowestCommonAncestor3(root.right, p, q);
        else return lowestCommonAncestor3(root.left, p, q);
    }
}
