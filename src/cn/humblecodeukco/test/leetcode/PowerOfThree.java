package cn.humblecodeukco.test.leetcode;

/**
 * @Author lyr
 * @Date 2020/11/15 13:13
 * @Version 1.0
 * @Description 326
 */
public class PowerOfThree {

    /**
     * 循环迭代
     * @param n
     * @return
     */
    public boolean isPowerOfThree(int n) {
        if (n == 0 || n == 2) return false;
        while (n != 1) {
            if (n % 3 != 0) return false;
            n /= 3;
        }
        return true;
    }

    public boolean isPowerOfThree2(int n) {
        if (n < 1) return false;
        while (n % 3 == 0) n /= 3;
        return n == 1;
    }

    /**
     * 基准转换
     * @param n
     * @return
     */
    public boolean isPowerOfThree3(int n) {
        return Integer.toString(n, 3).matches("^10*$");
    }
}
