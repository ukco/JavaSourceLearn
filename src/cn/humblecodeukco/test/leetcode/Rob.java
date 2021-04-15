package cn.humblecodeukco.test.leetcode;

/**
 * @Author lyr
 * @Date 2021/4/15 9:53
 * @Version 1.0
 * @Description 198. 打家劫舍
 */
public class Rob {
    /**
     * 动态规划
     * @param nums
     * @return
     */
    public int rot(int[] nums) {
        if (nums == null || nums.length == 0) { return 0; }

        int length = nums.length;
        if (length == 1) { return nums[0]; }

        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }

    public int rot2(int[] nums) {
        if (nums == null || nums.length == 0) { return 0; }
        int length = nums.length;
        if (length == 1) { return nums[0]; }

        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            int tmp = second;
            second = Math.max(first + nums[i], second);
            first = tmp;
        }
        return second;
    }
}
