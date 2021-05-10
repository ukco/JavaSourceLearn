package cn.humblecodeukco.test.leetcode;

import cn.humblecodeukco.test.DataStructure.TreeNode;
import cn.humblecodeukco.test.DataStructure.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lyr
 * @Date 2021/5/10 9:33
 * @Version 1.0
 * @Description 872. 叶子相似的树
 */
public class LeafSimilar {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) { return false; }

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        dfs(root1, list1);
        dfs(root2, list2);

        int length1 = list1.size(), length2 = list2.size();
        if (length1 != length2) { return false; }

        for (int i = 0; i < length1; ++i) {
            if (!list1.get(i).equals(list2.get(i))) { return false; }
        }

        return true;
    }
    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) { return; }
        dfs(root.left, list);
        if (root.left == null && root.right == null) { list.add(root.val); }
        dfs(root.right, list);
    }

    public static void main(String[] args) {
        Tree r = new Tree();
        TreeNode root1 = r.buildFromArray(new String[] {"3", "5", "1", "6", "2", "9", "8", "null", "null", "7", "4"}, 0, 11);
        TreeNode root2 = r.buildFromArray(new String[] {"3", "5", "1", "6", "7", "4", "2", "null", "null", "null", "null", "null", "null", "9", "8"}, 0, 15);

        System.out.println(new LeafSimilar().leafSimilar(root1, root2));
    }
}
