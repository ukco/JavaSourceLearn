package cn.humblecodeukco.test.Sword;

/**
 * @Author lyr
 * @Date 2020/10/1 17:04
 * @Version 1.0
 * @Description JZ38, 55
 */
public class BinaryTreeDepth {
    public static void main(String[] args) {

    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

// 方法一：递归
class BinaryTreeDepthSolution {
    public int TreeDepth(TreeNode root) {
        if (root == null) { return 0; }

        int nLeft = TreeDepth(root.left);
        int nRight = TreeDepth(root.right);

        return nLeft > nRight ? (nLeft + 1) : (nRight + 1);
    }
}