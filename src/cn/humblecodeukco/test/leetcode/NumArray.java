package cn.humblecodeukco.test.leetcode;

/**
 * @Author lyr
 * @Date 2021/3/1 9:17
 * @Version 1.0
 * @Description 303. 区域和检索-数组不可变
 */
public class NumArray {

    private int[] sums;

    /**
     * 前缀和思想
     * @param nums
     */
    public NumArray(int[] nums) {
        if (nums == null) { return; }

        this.sums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }
}
