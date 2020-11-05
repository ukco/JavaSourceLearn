package cn.humblecodeukco.test.leetcode;

import cn.humblecodeukco.test.DataStructure.TreeNode;
import sun.security.tools.PathList;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author lyr
 * @Date 2020/11/4 12:36
 * @Version 1.0
 * @Description 257
 */
public class AllPathOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3));
        AllPathOfBinaryTreeSolution allPathOfBinaryTreeSolution = new AllPathOfBinaryTreeSolution();
        List<String> pathList = allPathOfBinaryTreeSolution.binaryTreePaths(root);
        for (String path: pathList) System.out.println(path);
    }
}

/*
class AllPathOfBinaryTreeSolution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> pathList = new LinkedList<>();
        if (root == null) return pathList;
        solve(root, "", pathList);
        return pathList;
    }
    public void solve(TreeNode root, String cur, List<String> pathList) {
        if (root == null) return;
        cur += root.val;
        if (root.left == null && root.right == null) pathList.add(cur);
        else {
            solve(root.left, cur + "->", pathList);
            solve(root.right, cur + "->", pathList);
        }
    }
}*/

// StringBuilder
/*class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> pathList = new LinkedList<>();
        if (root == null) return pathList;
        solve(root, "", pathList);
        return pathList;
    }
    public void solve(TreeNode root, String cur, List<String> pathList) {
        if (root == null) return;
        StringBuilder pathSB = new StringBuilder(cur);
        pathSB.append(root.val);
        if (root.left == null && root.right == null) pathList.add(pathSB.toString());
        else {
            pathSB.append("->");
            solve(root.left, pathSB.toString(), pathList);
            solve(root.right, pathSB.toString(), pathList);
        }
    }
}*/

// StringBuffer
/*
class AllPathOfBinaryTreeSolution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> pathList = new LinkedList<>();
        solve(root, "", pathList);
        return pathList;
    }
    public void solve(TreeNode root, String cur, List<String> pathList) {
        if (root != null) {
            StringBuffer pathSB = new StringBuffer(cur);
            pathSB.append(root.val);
            if (root.left == null && root.right == null) pathList.add(pathSB.toString());
            else {
                pathSB.append("->");
                solve(root.left, pathSB.toString(), pathList);
                solve(root.right, pathSB.toString(), pathList);
            }
        }
    }
}*/

class AllPathOfBinaryTreeSolution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) return paths;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<String> pathQueue = new LinkedList<>();

        nodeQueue.offer(root);
        pathQueue.offer(Integer.toString(root.val));

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            String path = pathQueue.poll();

            if (node.left == null && node.right == null) paths.add(path);
            else {
                if (node.left != null) {
                    nodeQueue.offer(node.left);
                    pathQueue.offer(new StringBuffer(path).append("->").append(node.left.val).toString());
                }

                if (node.right != null) {
                    nodeQueue.offer(node.right);
                    pathQueue.offer(new StringBuffer(path).append("->").append(node.right.val).toString());
                }
            }
        }
        return paths;
    }
}
