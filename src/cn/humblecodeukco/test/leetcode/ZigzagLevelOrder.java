package cn.humblecodeukco.test.leetcode;

import cn.humblecodeukco.test.DataStructure.TreeNode;
import com.sun.tools.javac.util.ArrayUtils;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author lyr
 * @Date 2020/12/22 9:56
 * @Version 1.0
 * @Description 103. 二叉树的锯齿形层序遍历
 */
public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) { return ret; }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            int currentLevelSize = queue.size();
            int[] level = new int[currentLevelSize];

            int index;
            if (flag) { index = 0; }
            else { index = currentLevelSize - 1; }

            for (int i = 0; i < currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                if (node.left != null) { queue.offer(node.left); }
                if (node.right != null) { queue.offer(node.right); }

                if (flag) { level[index++] = node.val; }
                else { level[index--] = node.val; }
            }
            List<Integer> list = Arrays.stream(level).boxed().collect(Collectors.toList());
            ret.add(list);
            flag = !flag;
        }
        return ret;
    }

    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) { return ans; }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        boolean isOrderLeft = true;

        while (!nodeQueue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<>();
            int size = nodeQueue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode curNode = nodeQueue.poll();
                if (isOrderLeft) { levelList.offerLast(curNode.val); }
                else { levelList.offerFirst(curNode.val); }
                if (curNode.left != null) { nodeQueue.offer(curNode.left); }
                if (curNode.right != null) { nodeQueue.offer(curNode.right); }
            }
            ans.add(new LinkedList<>(levelList));
            isOrderLeft = !isOrderLeft;
        }
        return ans;
    }
}
