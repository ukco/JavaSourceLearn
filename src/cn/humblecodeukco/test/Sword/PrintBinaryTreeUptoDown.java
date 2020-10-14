package cn.humblecodeukco.test.Sword;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author lyr
 * @Date 2020/10/14 10:48
 * @Version 1.0
 * @Description JZ60, 32
 */
public class PrintBinaryTreeUptoDown {
    public static void main(String[] args) {

    }
}

class PrintBinaryTreeUptoDownSolution {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) return result;

        Queue<TreeNode> layer = new LinkedList<>();
        layer.offer(pRoot);
        int start = 0, end = 1;
        while (!layer.isEmpty()) {
            ArrayList<Integer> layerList = new ArrayList<>();
            TreeNode pNode = layer.poll();
            layerList.add(pNode.val);
            start++;
            if (pNode.left != null) layer.add(pNode.left);
            if (pNode.right != null) layer.add(pNode.right);
            if (start == end) {
                end = layer.size();
                start = 0;
                result.add(layerList);
            }
        }
        return result;
    }
}