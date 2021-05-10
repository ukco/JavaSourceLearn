package cn.humblecodeukco.test.DataStructure;

/**
 * @Author lyr
 * @Date 2021/5/10 10:20
 * @Version 1.0
 * @Description
 */
public class Tree {
    public TreeNode buildFromArray(String[] array, int i, int n) {
        if (i >= n || "null".equals(array[i])) { return null; }
        TreeNode root = new TreeNode(Integer.parseInt(array[i]));

        root.left = buildFromArray(array, 2 * i + 1, n);
        root.right = buildFromArray(array, 2 * i + 2, n);

        return root;
    }
}
