package cn.humblecodeukco.test.leetcode;

/**
 * @Author lyr
 * @Date 2020/12/17 9:52
 * @Version 1.0
 * @Description 714
 */
public class MaxProfit {
    /**
     * 动态规划
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    /**
     * 优化版本
     * 注意到字状态转移方程中，dp[i][0] 和 dp[i][1] 只会从 dp[i−1][0] 和 dp[i−1][1] 转移而来
     * 因此我们不必使用数组存储所有的状态，而是使用两个变量 sell 以及 buy 分别表示 dp[..][0] 和 dp[..][1] 直接进行状态转移即可。
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit2(int[] prices, int fee) {
        int n = prices.length;
        int sell = 0, buy = -prices[0];
        for (int i = 1; i < n; ++i) {
            sell = Math.max(sell, buy + prices[i] - fee);
            buy = Math.max(buy, sell - prices[i]);
        }
        return sell;
    }
}
