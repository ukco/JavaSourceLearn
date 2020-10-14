package cn.humblecodeukco.test.leetcode;

import cn.humblecodeukco.test.DataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author lyr
 * @Date 2020/10/14 18:06
 * @Version 1.0
 * @Description 101
 */
public class SymmetryBinaryTree {
    public static void main(String[] args) {

    }
}

// 递归
//class SymmetryBinaryTreeSolution {
//    public boolean isSymmetric(TreeNode root) {
//        return check(root, root);
//    }
//
//    public boolean check(TreeNode p, TreeNode q) {
//        if (p == null && q == null) return true;
//        if (p == null || q == null) return false;
//        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
//    }
//}

// 迭代
class SymmetryBinaryTreeSolution {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode u, TreeNode v) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) continue;
            if ((u == null || v == null) || (u.val != v.val)) return false;

            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }
}