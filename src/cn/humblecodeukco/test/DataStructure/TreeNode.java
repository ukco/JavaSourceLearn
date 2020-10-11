package cn.humblecodeukco.test.DataStructure;

/**
 * @Author lyr
 * @Date 2020/10/11 20:06
 * @Version 1.0
 * @Description
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
