package cn.humblecodeukco.test.Sword;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author lyr
 * @Date 2020/10/3 14:35
 * @Version 1.0
 * @Description JZ4, 7
 */
public class reConstructBinaryTree {
    public static void main(String[] args) {

    }
}

// 方法一 递归
// 时间复杂度：O(n)。对于每个节点都有创建过程以及根据左右子树重建过程。
// 空间复杂度：O(n)O(n)。存储整棵树的开销。
class reConstructBinaryTreeSolution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;

        Map<Integer, Integer> indexMap = new HashMap<>();
        int length = preorder.length;
        // 使用一个 Map 存储中序遍历的每个元素及其对应的下标，目的是为了快速获得一个元素在中序遍历中的位置
        for (int i = 0; i < length; ++i) {
            indexMap.put(inorder[i], i);
        }
        // 调用递归方法，对于前序遍历和中序遍历，下标范围都是从 0 到 n-1，其中 n 是二叉树节点个数。
        TreeNode root = buildTree(preorder, 0, length - 1,
                inorder, 0, length - 1, indexMap);
        return root;
    }

    // 递归方法的基准情形有两个：判断前序遍历的下标范围的开始和结束，若开始大于结束，则当前的二叉树中没有节点，
    // 返回空值 null。若开始等于结束，则当前的二叉树中恰好有一个节点，根据节点值创建该节点作为根节点并返回。
    public TreeNode buildTree(int[] preorder, int preorderStart,
                              int preorderEnd, int[] inorder,
                              int inorderStart, int inorderEnd,
                              Map<Integer, Integer> indexMap) {
        if (preorderStart > preorderEnd) return null;

        int rootVal = preorder[preorderStart];
        TreeNode root = new TreeNode(rootVal);
        if (preorderStart == preorderEnd) {
            return root;
        } else {
            int rootIndex = indexMap.get(rootVal);
            int leftNodes = rootIndex - inorderStart;
            int rightNodes = inorderEnd - rootIndex;
            TreeNode leftSubtree = buildTree(preorder, preorderStart + 1,
                    preorderStart + leftNodes, inorder, inorderStart,
                    rootIndex - 1, indexMap);
            TreeNode rightSubtree = buildTree(preorder,
                    preorderEnd - rightNodes + 1, preorderEnd,
                    inorder, rootIndex + 1, inorderEnd, indexMap);
            root.left = leftSubtree;
            root.right = rightSubtree;
            return root;
        }
    }
}

// 方法二 迭代
// 可以使用栈保存遍历过的节点。初始时令中序遍历的指针指向第一个元素，遍历前序遍历的数组，如
// 果前序遍历的元素不等于中序遍历的指针指向的元素，则前序遍历的元素为上一个节点的左子节点。如果前序遍历的元素等
// 于中序遍历的指针指向的元素，则正向遍历中序遍历的元素同时反向遍历前序遍历的元素，找到最后一次相等的元素，将前
// 序遍历的下一个节点作为最后一次相等的元素的右子节点。其中，反向遍历前序遍历的元素可通过栈的弹出元素实现。
// 时间复杂度：O(n)。前序遍历和后序遍历都被遍历。
// 空间复杂度：O(n)。额外使用栈存储已经遍历过的节点。
//class reConstructBinaryTreeSolution {
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        if (preorder == null || preorder.length == 0) return null;
//
//        TreeNode root = new TreeNode(preorder[0]);
//        int length = preorder.length;
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//        int inorderIndex = 0;
//        for (int i = 1; i < length; ++i) {
//            int preorderVal = preorder[i];
//            TreeNode node = stack.peek();
//            if (node.val != inorder[inorderIndex]) {
//                node.left = new TreeNode(preorderVal);
//                stack.push(node.left);
//            } else {
//                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
//                    node = stack.pop();
//                    inorderIndex++;
//                }
//                node.right = new TreeNode(preorderVal);
//                stack.push(node.right);
//            }
//        }
//        return root;
//    }
//}