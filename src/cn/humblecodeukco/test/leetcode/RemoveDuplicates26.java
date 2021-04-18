package cn.humblecodeukco.test.leetcode;

/**
 * @Author lyr
 * @Date 2021/4/18 11:06
 * @Version 1.0
 * @Description 26. 删除有序数组中的重复项
 */
public class RemoveDuplicates26 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) { return 0; }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                nums[index + 1] = nums[i];
                index++;
            }
        }
        return index + 1;
    }
}
