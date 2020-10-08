package cn.humblecodeukco.test.Sword;

import com.sun.source.tree.BinaryTree;

import java.util.Stack;
import java.util.function.BinaryOperator;

/**
 * @Author lyr
 * @Date 2020/9/29 19:11
 * @Version 1.0
 * @Description
 */
public class MirrorOfBinaryTree {
    public static void main(String[] args) {
        MirrorOfBinaryTreeSolution mirrorOfBianryTreeSolution = new MirrorOfBinaryTreeSolution();

    }
}

class BinaryTreeNode {
    public int data;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BinaryTreeNode [data=" + data + ", left=" + left + ", right=" +right + "]";
    }
}

// 递归
class MirrorOfBinaryTreeSolution {
    public void MirrorRecursively(BinaryTreeNode pNode) {
        // 根节点为null，直接返回
        if (pNode == null) return;
        // 如果根节点的左右节点为空，直接返回
        if ((pNode.left == null && pNode.right == null)) return;

        BinaryTreeNode pTemp = pNode.left;
        pNode.left = pNode.right;
        pNode.right = pTemp;

        if (pNode.left != null) MirrorRecursively(pNode.left);
        if (pNode.right != null) MirrorRecursively(pNode.right);
    }
}

// 循环，栈
//class MirrorOfBinaryTreeSolution {
//    public void MirrorRecursively (BinaryTreeNode pNode) {
//        if (pNode == null) return;
//
//        Stack<BinaryTreeNode> stack = new Stack<>();
//        stack.push(pNode);
//        while (!stack.isEmpty()) {
//            BinaryTreeNode treeNode = stack.pop();
//            if (treeNode.left != null || treeNode.right != null) {
//                BinaryTreeNode tempNode = treeNode.left;
//                treeNode.left  = treeNode.right;
//                treeNode.right = tempNode;
//            }
//            if (treeNode.left != null) stack.push(treeNode.left);
//            if (treeNode.right != null) stack.push(treeNode.right);
//        }
//    }
//}