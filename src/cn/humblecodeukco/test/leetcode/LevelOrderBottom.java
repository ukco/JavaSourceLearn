package cn.humblecodeukco.test.leetcode;

import cn.humblecodeukco.test.DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author lyr
 * @Date 2020/11/14 21:27
 * @Version 1.0
 * @Description 107
 */
public class LevelOrderBottom {
}

class LevelOrderBottomSolution {
    /**
     * 广度优先搜索
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levelOrder = new LinkedList<>();
        if (root == null) return levelOrder;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                TreeNode left = node.left, right = node.right;
                if (left != null) queue.offer(left);
                if (right != null) queue.offer(right);
            }
            levelOrder.add(0, level);
        }
        return levelOrder;
    }
}