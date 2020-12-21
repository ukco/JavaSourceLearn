package cn.humblecodeukco.test.leetcode;

/**
 * @Author lyr
 * @Date 2020/12/21 9:30
 * @Version 1.0
 * @Description 764. 使用最小花费爬楼梯
 */
public class MinCostClimbingStairs {
    /**
     * 动态规划
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= n; ++i) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }

    /**
     * 动态规划优化
     * @param cost
     * @return
     */
    public int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;
        int prev = 0,  curr = 0;
        for (int i = 2; i <= n; ++i) {
            int next = Math.min(curr + cost[i - 1], prev + cost[i - 2]);
            prev = curr;
            curr = next;
        }
        return curr;
    }
}
