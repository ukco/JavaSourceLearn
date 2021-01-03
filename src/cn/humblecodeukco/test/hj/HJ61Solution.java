package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author lyr
 * @Date 2021/1/3 15:33
 * @Version 1.0
 * @Description HJ61. 放苹果
 */
public class HJ61Solution {
    /**
     * 放苹果分为两种情况，一种是有盘子为空，一种是每个盘子上都有苹果。
     * 令(m,n)表示将m个苹果放入n个盘子中的摆放方法总数。
     * 1.假设有一个盘子为空，则(m,n)问题转化为将m个苹果放在n-1个盘子上，即求得(m,n-1)即可
     * 2.假设所有盘子都装有苹果，则每个盘子上至少有一个苹果，即最多剩下m-n个苹果，问题转化为将m-n个苹果放到n个盘子上, 即求(m-n，n)
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = read.readLine()) != null) {
            String[] s = str.split(" ");
            int m = Integer.parseInt(s[0]);
            int n = Integer.parseInt(s[1]);
            System.out.println(count(m, n));
        }
    }
    private static int count(int m, int n) {
        if (n == 1 || m == 0) { return 1; }
        else if (n > m) { return count(m, m); }
        else { return count(m, n - 1) + count(m - n, n); }
    }

    /**
     * 动态规划
     * @throws IOException
     */
    public void test() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = read.readLine()) != null) {
            String[] s = str.split(" ");
            int m = Integer.parseInt(s[0]);
            int n = Integer.parseInt(s[1]);
            // 初始状态转移矩阵dp[n][m], dp[i][j]表示i个盘子放j个苹果的放法；
            int[][] dp = new int[n + 1][m + 1];
            Arrays.fill(dp[1], 1);
            for (int i = 1; i <= n; ++i) { dp[i][0] = dp[i][1] = 1; }
            for (int i = 2; i <= n; ++i) {
                for (int j = 2; j <= m; ++j) {
                    dp[i][j] = dp[i - 1][j] + (j - i < 0 ? 0 : dp[i][j - i]);
                }
            }
            System.out.println(dp[n][m]);
        }
    }
}
