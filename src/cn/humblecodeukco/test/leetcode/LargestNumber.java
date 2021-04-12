package cn.humblecodeukco.test.leetcode;

import java.util.Arrays;

/**
 * @Author lyr
 * @Date 2021/4/12 9:46
 * @Version 1.0
 * @Description 179. 最大数
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        // 转换成包装类型，以便传入Comparator对象
        Integer[] numsArr = new Integer[n];
        for (int i = 0; i < n; i++) { numsArr[i] = nums[i]; }

        Arrays.sort(numsArr, (x, y) -> {
            long sx = 10, sy = 10;
            while (sx <= x) { sx *= 10; }
            while (sy <= y) { sy *= 10; }
            return (int) (-sy * x - y + sx * y + x);
        });

        if (numsArr[0] == 0) { return "0"; }
        StringBuilder ret = new StringBuilder();
        for (int num : numsArr) { ret.append(num); }

        return ret.toString();
    }

    public String largestNumber2(int[] nums) {
        int n = nums.length;
        String[] nums_str = new String[n];
        for (int i = 0; i < n; i++) { nums_str[i] = String.valueOf(nums[i]); }
        Arrays.sort(nums_str, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        StringBuilder sb = new StringBuilder();
        for (String num : nums_str) {
            sb.append(num);
        }
        if (sb.charAt(0) == '0') { return "0"; }
        return sb.toString();
    }
}
