package cn.humblecodeukco.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author lyr
 * @Date 2020/11/22 16:09
 * @Version 1.0
 * @Description 18
 */
public class FourNumberSum {
}

class FourNumberSumSolution {
    /**
     * 排序 + 双指针
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return quadruplets;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; ++i) {
            // 同一重循环中，如果当前元素与上一个元素相同，则跳过当前元素
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 在确定第一个数之后，如果 nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target，说明
            // 此时剩下的三个数无论取什么值，四数之和一定大于target，因此退出第一重循环
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            // 在确定第一个数之后，如果 nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < targe，
            // 说明此时剩下的三个数无论取什么值，四数之和一定小于target，因此第一重循环直接进入下一轮，枚举nums[i + 1]
            if (nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < length - 2; ++j) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if (nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }
                int left = j + 1, right = length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            ++left;
                        }
                        ++left;
                        while (left < right && nums[right] == nums[right - 1]) {
                            --right;
                        }
                        --right;
                    } else if (sum < target) {
                        ++left;
                    } else {
                        --right;
                    }
                }
            }
        }
        return quadruplets;
    }
}