package cn.humblecodeukco.test.leetcode;

import cn.humblecodeukco.test.DataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author lyr
 * @Date 2020/10/14 19:59
 * @Version 1.0
 * @Description 104
 */
public class MaximumDepthofBinaryTree {
    public static void main(String[] args) {

    }
}

// 递归DFS
//class MaximunDepthofBinaryTreeSolution {
//    public int maxDepth(TreeNode root) {
//        if (root == null) return 0;
//
//        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
//    }
//}

// 广度优先搜索
class MaximunDepthofBinaryTreeSolution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                size--;
            }
            ans++;
        }
        return ans;
    }
}