package cn.humblecodeukco.test.leetcode;

import java.util.Arrays;

/**
 * @Author lyr
 * @Date 2020/10/10 14:09
 * @Version 1.0
 * @Description 53
 */
public class MaximumSubsequenceSum {
    public static void main(String[] args) {

    }
}

// 贪心
//class MaximumSubsequenceSumSolution {
//    public int maxSubArray(int[] nums) {
//       if (nums == null) return Integer.MIN_VALUE;
//
//       int cur_sum = nums[0];
//       int max_sum = nums[0];
//
//       for (int i = 0; i < nums.length; ++i) {
//           cur_sum = Math.max(nums[i], cur_sum + nums[i]);
//           max_sum = Math.max(cur_sum, max_sum);
//       }
//       return max_sum;
//    }
//}

// 动态规划
class MaximumSubsequenceSumSolution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; ++i) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
        }
        return Arrays.stream(nums).max().getAsInt();
    }
}