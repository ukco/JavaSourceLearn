package cn.humblecodeukco.test.leetcode;

import java.util.TreeSet;

/**
 * @Author lyr
 * @Date 2021/4/22 10:38
 * @Version 1.0
 * @Description 363. 矩形区域不超过K的最大数值和
 */
public class MaxSumSubmatrix {
    /**
     * 有序集合
     * @param matrix
     * @param k
     * @return
     */
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int ans = Integer.MIN_VALUE;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            // 枚举上边界
            int[] sum = new int[n];
            for (int j = i; j < m; ++j) {
                // 枚举下边界
                for (int c = 0; c < n; ++c) {
                    // 更新每列的元素和
                    sum[c] += matrix[j][c];
                }
                TreeSet<Integer> sumSet = new TreeSet<>();
                sumSet.add(0);
                int s = 0;
                for (int v : sum) {
                    s += v;
                    Integer ceil = sumSet.ceiling(s - k);
                    if (ceil != null) {
                        ans = Math.max(ans, s - ceil);
                    }
                    sumSet.add(s);
                }
            }
        }
        return ans;
    }
}
