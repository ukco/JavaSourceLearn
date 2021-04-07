package cn.humblecodeukco.test.leetcode;

/**
 * @Author lyr
 * @Date 2021/4/7 13:49
 * @Version 1.0
 * @Description 81. 搜索旋转排序数组II
 */
public class Search {
    public boolean search(int[] nums, int target) {
        int length = nums.length;

        int index;
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                index = i;
                if (binarySearch(nums, 0, index, target)) { return true; }
                else { return binarySearch(nums, index + 1, length - 1, target); }
            }
        }
        return binarySearch(nums, 0, length - 1, target);
    }
    private boolean binarySearch(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) { return true; }
            else if (nums[mid] < target) { low = mid + 1; }
            else { high = mid - 1; }
        }
        return false;
    }
}
