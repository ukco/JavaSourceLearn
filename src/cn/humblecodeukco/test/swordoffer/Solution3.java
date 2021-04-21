package cn.humblecodeukco.test.swordoffer;

/**
 * @Author lyr
 * @Date 2021/4/21 11:24
 * @Version 1.0
 * @Description 3. 数组中重复的数字
 */
public class Solution3 {
    public int findRepeatNumber(int[] nums) {
        int n = nums.length;
        int[] count = new int[n];
        for (int num : nums) {
            if (count[num] == 0) { count[num] += 1; }
            else { return num; }
        }
        return -1;
    }

    public int findRepeatNumber2(int[] nums) {
        if (nums == null || nums.length == 0) { return -1; }

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) { return nums[i]; }
                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
        }
        return -1;
    }
}
