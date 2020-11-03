package cn.humblecodeukco.test.leetcode;

/**
 * @Author lyr
 * @Date 2020/11/3 12:59
 * @Version 1.0
 * @Description 231
 */
public class isPowerOfTwoSolution {

    // 位运算，获取二进制中最右边的1
    // 如何获取二进制中最右边的 1：x & (-x)。
    /*public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        long x = (long) n;
        return (x & (-x)) == x;
    }*/

    // 位运算，去除二进制中最右边的1
    // 如何将二进制中最右边的 1 设置为 0：x & (x - 1)。
    /*public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        long x = (long) n;
        return (x & (x - 1)) == 0;
    }*/

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
