package cn.humblecodeukco.test.leetcode;

/**
 * @Author lyr
 * @Date 2021/4/6 9:44
 * @Version 1.0
 * @Description 80. 删除有序数组中的重复项
 */
public class RemoveDuplicatesII {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) { return 0; }

        int index = nums.length;
        for (int i = 0; i < index - 2; i++) {
            if (nums[i] == nums[i + 1] && nums[i] == nums[i + 2]) {
                for (int j = i + 2; j < index - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                --index;
                --i;
            }
        }
        return index;
    }

    /**
     * 双指针
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums) {
        int n = nums.length;
        if (n <= 2) { return n; }

        int slow = 2, fast = 2;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }
}
