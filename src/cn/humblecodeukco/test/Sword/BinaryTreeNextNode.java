package cn.humblecodeukco.test.Sword;

import cn.humblecodeukco.test.DataStructure.TreeLinkNode;

/**
 * @Author lyr
 * @Date 2020/10/13 9:41
 * @Version 1.0
 * @Description JZ57, 8
 */
public class BinaryTreeNextNode {
}

class BinaryTreeNextNodeSolution {
    public TreeLinkNode Getnext(TreeLinkNode pNode) {
        if (pNode == null) return null;

        TreeLinkNode pNext = null;
        if (pNode.right != null) {
            TreeLinkNode pRight  = pNode.right;
            while (pRight.left != null) pRight = pRight.left;
            pNext = pRight;
        } else if (pNode.parent != null) {
            TreeLinkNode pCurrent = pNode;
            TreeLinkNode pParent = pNode.parent;
            while (pParent != null && pCurrent == pParent.right) {
                pCurrent = pParent;
                pParent = pParent.parent;
            }
            pNext = pParent;
        }
        return pNext;
    }
}