package cn.humblecodeukco.test.leetcode;

import java.util.Arrays;

/**
 * @Author lyr
 * @Date 2021/4/15 9:41
 * @Version 1.0
 * @Description 213. 打家劫舍II
 */
public class RobII {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) { return 0; }

        int length = nums.length;
        if (length == 1) { return nums[0]; }
        return Math.max(myRob(Arrays.copyOfRange(nums, 0, length - 1)),
                myRob(Arrays.copyOfRange(nums, 1, length)));
    }
    private int myRob(int[] nums) {
        int pre = 0, cur = 0, tmp;
        for (int num : nums) {
            tmp = cur;
            cur = Math.max(pre + num, cur);
            pre = tmp;
        }
        return cur;
    }
}
