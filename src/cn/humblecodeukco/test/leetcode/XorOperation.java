package cn.humblecodeukco.test.leetcode;

/**
 * @Author lyr
 * @Date 2021/5/7 11:11
 * @Version 1.0
 * @Description 1486. 数组异或操作
 */
public class XorOperation {
    public int xorOperation(int n, int start) {
        // int[] nums = new int[n];
        int res = start;
        int tmp;
        for (int i = 1; i < n; ++i) {
            tmp = start + 2 * i;
            res ^= tmp;
        }
        return res;
    }
}
