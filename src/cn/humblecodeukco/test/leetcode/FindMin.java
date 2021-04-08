package cn.humblecodeukco.test.leetcode;

/**
 * @Author lyr
 * @Date 2021/4/8 9:31
 * @Version 1.0
 * @Description 153. 寻找旋转排序数组中的最小值
 */
public class FindMin {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        int mid;

        while (low <= high) {
            mid = low + (high - low) / 2;
            if (mid == nums.length - 1) { return nums[0];}
            if (nums[mid] > nums[mid + 1]) { return nums[mid + 1]; }

            if (nums[mid] >= nums[low]) { low = mid + 1; }
            else if (nums[mid] <= nums[high]) { high = mid - 1; }
        }
        return nums[0];
    }
}
