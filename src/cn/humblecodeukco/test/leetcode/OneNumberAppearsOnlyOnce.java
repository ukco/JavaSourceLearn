package cn.humblecodeukco.test.leetcode;

/**
 * @Author lyr
 * @Date 2020/10/16 16:55
 * @Version 1.0
 * @Description 136
 */
public class OneNumberAppearsOnlyOnce {
    public static void main(String[] args) {

    }
}

class OneNumberAppearsOnlyOnceSolution {
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num: nums) single ^= num;
        return single;
    }
}