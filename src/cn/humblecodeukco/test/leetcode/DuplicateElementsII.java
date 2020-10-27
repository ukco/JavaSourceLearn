package cn.humblecodeukco.test.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Author lyr
 * @Date 2020/10/27 11:02
 * @Version 1.0
 * @Description 219
 */
public class DuplicateElementsII {
}

/*class DuplicateElementsIISolution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; ++i) {
            for (int j = Math.max(i - k, 0); j < i; ++j) {
                if (nums[i] == nums[j]) return true;
            }
        }
        return false;
    }
}*/

/*
class DuplicateElementsIISolution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}*/

class DuplicateElementsIISolution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k)
                set.remove(nums[i - k]);
        }
        return false;
    }
}