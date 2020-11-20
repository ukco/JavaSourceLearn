package cn.humblecodeukco.test.leetcode;

import cn.humblecodeukco.test.DataStructure.TreeNode;

import java.util.Random;

/**
 * @Author lyr
 * @Date 2020/11/20 12:50
 * @Version 1.0
 * @Description 108
 */
public class InvertSortArrayToBinaryTree {
}

class InvertSortArrayToBinaryTreeSolution {

    /**
     * 中序遍历，总是选择中间位置左边的数字作为根节点
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) return null;

        // 总是选择中间位置左边的数字作为根节点
        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }

    /**
     * 中序遍历，总是选择中间位置右边的数字作为根节点
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST2(int[] nums) {
        return helper2(nums, 0, nums.length - 1);
    }
    public TreeNode helper2(int[] nums, int left, int right) {
        if (left > right) return null;

        // 总是选择中间位置右边的数字作为根节点
        int mid = (left + right + 1) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper2(nums, left, mid - 1);
        root.right = helper2(nums, mid + 1, right);
        return root;
    }

    /**
     * 中序遍历，选择任意一个中间位置数字作为根节点
     * @param nums
     * @return
     */
    Random rand = new Random();
    public TreeNode sortedArrayToBST3(int[] nums) {
        return helper3(nums, 0, nums.length - 1);
    }
    public TreeNode helper3(int[] nums, int left, int right) {
        if (left > right) return null;

        // 任意选择一个中间位置数字作为根节点
        int mid = (left + right + rand.nextInt(2)) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper3(nums, left, mid - 1);
        root.right = helper3(nums, mid + 1, right);
        return root;
    }
}