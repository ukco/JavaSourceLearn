package cn.humblecodeukco.test.leetcode;

/**
 * @Author lyr
 * @Date 2021/3/16 9:44
 * @Version 1.0
 * @Description 59. 螺旋矩阵II
 */
public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int l = 0, r = n -1 , t = 0, b = n - 1;
        int[][] mat = new int[n][n];
        int num = 1, tar = n * n;
        while (num <= tar) {
            for (int i = l; i <= r; i++) { mat[t][i] = num++; }
            t++;
            for (int i =t; i <= b; i++) { mat[i][r] = num++; }
            r--;
            for (int i = r; i >= l; i--) { mat[b][i] = num++; }
            b--;
            for (int i = b; i >= t; i--) { mat[i][l] = num++; }
            l++;
        }
        return mat;
    }
}
