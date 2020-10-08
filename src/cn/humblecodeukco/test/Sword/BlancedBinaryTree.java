package cn.humblecodeukco.test.Sword;

import sun.rmi.transport.proxy.RMIHttpToCGISocketFactory;

/**
 * @Author lyr
 * @Date 2020/10/1 17:17
 * @Version 1.0
 * @Description JZ39, 55题目二
 */
public class BlancedBinaryTree {
    public static void main(String[] args) {

    }
}

// 重复遍历同一个节点，影响性能
//class BlancedBinaryTreeSolution {
//    public boolean IsBalanced_Solution(TreeNode root) {
//        if (root == null) return true;
//
//        BinaryTreeDepthSolution binaryTreeDepthSolution = new BinaryTreeDepthSolution();
//        int left = binaryTreeDepthSolution.TreeDepth(root.left);
//        int right = binaryTreeDepthSolution.TreeDepth(root.right);
//        int diff = left - right;
//        if (diff > 1 || diff < -1) return false;
//
//        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
//    }
//}

// 自底向上，类似于后序遍历
// 时间复杂度：O(n)，其中 n 是二叉树中的节点个数。
// 使用自底向上的递归，每个节点的计算高度和判断是否平衡都只需要处理一次，
// 最坏情况下需要遍历二叉树中的所有节点，因此时间复杂度是 O(n)。
// 空间复杂度：O(n)，其中 n 是二叉树中的节点个数。
// 空间复杂度主要取决于递归调用的层数，递归调用的层数不会超过 n。
class BlancedBinaryTreeSolution {
    public boolean IsBalanced_Solution(TreeNode root) {
        return height(root) >=0;
    }

    public int height(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}