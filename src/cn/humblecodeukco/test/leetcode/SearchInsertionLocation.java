package cn.humblecodeukco.test.leetcode;

/**
 * @Author lyr
 * @Date 2020/10/9 13:38
 * @Version 1.0
 * @Description 35
 */
public class SearchInsertionLocation {
    public static void main(String[] args) {

    }
}

class SearchInsertionLocationSolution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}