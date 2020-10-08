package cn.humblecodeukco.test.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lyr
 * @Date 2020/9/14 21:52
 * @Version 1.0
 * @Description 1
 */
public class TwoSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int [] index = solution.twoSum(new int[]{2, 7, 11, 15}, 26);
        for(int i : index) {
            System.out.println(i);
        }
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++) {
            int x = nums[i];
            if(map.containsKey((target - x))) {
                return new int[]{map.get(target - x), i};  // get(Object key) {...}
            }
            map.put(x, i);  // put(K key, V value) {...}
        }
        throw new IllegalArgumentException("No two sum solution"); // 不合法的参数异常
    }
}
