package cn.humblecodeukco.test.leetcode;

/**
 * @Author lyr
 * @Date 2020/12/9 10:03
 * @Version 1.0
 * @Description 62
 */
public class UniquePaths {
    /**
     * 动态规划
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];
        for (int i = 0; i < m; ++i) { f[i][0] = 1; }
        for (int j = 0; j < n; ++j) { f[0][j] = 1; }

        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) { f[i][j] = f[i - 1][j] + f[i][j - 1]; }
        }

        return f[m - 1][n - 1];
    }

    /**
     * 组合数学
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths2(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; ++x, ++y) { ans = ans * x / y; }
        return (int) ans;
    }
}
