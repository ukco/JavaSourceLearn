package cn.humblecodeukco.test.leetcode;

import cn.humblecodeukco.test.DataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author lyr
 * @Date 2020/10/15 10:24
 * @Version 1.0
 * @Description 111
 */
public class MinimumDepthofBinaryTree {
    public static void main(String[] args) {

    }
}

// 深度优先搜搜
//class MinimumDepthofBinaryTreeSolution {
//    public int minDepth(TreeNode root) {
//        if (root == null) return 0;
//
//        if (root.left == null && root.right == null) return 1;
//
//        int min_depth = Integer.MAX_VALUE;
//        if (root.left != null) min_depth = Math.min(minDepth(root.left), min_depth);
//        if (root.right != null) min_depth = Math.min(minDepth(root.right), min_depth);
//
//        return min_depth + 1;
//    }
//}

//class MinimumDepthofBinaryTreeSolution {
//    public int minDepth(TreeNode root) {
//        if (root == null) return 0;
//        int m1 = minDepth(root.left);
//        int m2 = minDepth(root.right);
//        // 如果左子节点和右子节点有为空的情况，直接返回 m1 + m2 + 1
//        // 如果都不为空，返回较小深度 + 1
//        return root.left == null || root.right == null ? m1 + m2 + 1 : Math.min(m1, m2) + 1;
//    }
//}

// 广度优先搜索
class MinimumDepthofBinaryTreeSolution {
    class QueueNode {
        TreeNode node;
        int depth;

        public QueueNode(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<QueueNode> queue = new LinkedList<>();
        queue.offer(new QueueNode(root, 1));
        while (!queue.isEmpty()) {
            QueueNode nodeDepth = queue.poll();
            TreeNode node = nodeDepth.node;
            int depth = nodeDepth.depth;
            if (node.left == null && node.right == null) return depth;
            if (node.left != null) queue.offer(new QueueNode(node.left, depth + 1));
            if (node.right != null) queue.offer(new QueueNode(node.right, depth + 1));
        }
        return 0;
    }
}