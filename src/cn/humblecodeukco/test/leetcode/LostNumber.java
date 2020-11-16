package cn.humblecodeukco.test.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author lyr
 * @Date 2020/11/16 12:48
 * @Version 1.0
 * @Description
 */
public class LostNumber {
}

class LostNumberSolution {
    /**
     * 排序
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);

        // 判断 n 是否出现在末位
        if (nums[nums.length - 1] != nums.length) return nums.length;
        // 判断 0 是否出现在首位
        else if (nums[0] != 0) return 0;

        // 此时缺失的数字一定在 (0, n) 中
        for (int i = 1; i < nums.length - 1; ++i) {
            int expectedNum = nums[i - 1] + 1;
            if (nums[i] != expectedNum) return expectedNum;
        }

        // 未缺失任何数字（保证函数有返回值）
        return -1;
    }

    /**
     * 哈希表
     * @param nums
     * @return
     */
    public int missingNumber2(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) numSet.add(num);

        int expectedNumCount = nums.length + 1;
        for (int number = 0; number < expectedNumCount; number++) {
            if(!numSet.contains(number)) {
                return number;
            }
        }
        return -1;
    }

    /**
     * 位运算
     * @param nums
     * @return
     */
    public int missingNumber3(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; ++i) missing ^= i ^ nums[i];
        return missing;
    }

    /**
     * 数学
     * @param nums
     * @return
     */
    public int missingNumber4(int[] nums) {
        int expectedSum = nums.length * (nums.length + 1) / 2;
        int actualSum = 0;
        for (int num : nums) actualSum += num;
        return expectedSum - actualSum;
    }

    /**
     * 边加边减
     * @param nums
     * @return
     */
    public int missingNumber5(int[] nums) {
        int sum = 0;
        int i;
        for (i = 0; i < nums.length; ++i) sum += nums[i] - i;
        sum -= i;
        return Math.abs(sum);
    }
}