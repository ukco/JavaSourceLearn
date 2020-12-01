package cn.humblecodeukco.test.leetcode;

/**
 * @Author lyr
 * @Date 2020/12/1 10:21
 * @Version 1.0
 * @Description 34 在排序数组中查找元素的第一个和最后一个位置
 */
public class SearchRange {
    /**
     * 双指针
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) { return new int[] {-1, -1}; }
        int i = 0, j = nums.length - 1;
        while (i <= j && nums[i] != target && nums[j] != target) {
            i++;
            j--;
        }
        if (i > nums.length - 1 && j < 0) { return new int[] {-1, -1}; }
        if (nums[i] == target && nums[j] == target) { return new int[] {i, j}; }
        if (i < j && nums[i] == target && nums[j] != target) {
            while (i < j && nums[j] != target) { j--; }
            return new int[] {i, j};
        }
        if (i < j && nums[i] != target && nums[j] == target) {
            while (i < j && nums[i] != target) { i++; }
            return new int[] {i, j};
        }
        return new int[] {-1, -1};
    }

    /**
     * 二分查找
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange2(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[] {leftIdx, rightIdx};
        }
        return new int[] {-1, -1};
    }
    private int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid -1;
                ans = mid;
            } else { left = mid + 1; }
        }
        return ans;
    }

    public static void main(String[] args) {
        SearchRange searchRange = new SearchRange();
        int[] res = searchRange.searchRange(new int[] {5,7,7,8,8,10}, 8);
        for(int i: res) {
            System.out.println(i);
        }
    }
}
