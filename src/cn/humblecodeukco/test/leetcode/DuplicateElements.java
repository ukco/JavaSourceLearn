package cn.humblecodeukco.test.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author lyr
 * @Date 2020/10/26 12:32
 * @Version 1.0
 * @Description 217
 */
public class DuplicateElements {
}

class DuplicateElementsSolution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int x: nums) {
            if (set.contains(x)) { return true; }
            set.add(x);
        }
        return false;
    }
}

/*
class DuplicateElementsSolution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }
}*/
