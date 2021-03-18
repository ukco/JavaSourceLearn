package cn.humblecodeukco.test.leetcode;

import java.util.Map;

/**
 * @Author lyr
 * @Date 2021/1/4 9:45
 * @Version 1.0
 * @Description 509. 斐波那契数列
 */
public class Fib {
    /**
     * 递归
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n == 0) { return 0; }
        if (n == 1) { return 1; }
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 数组
     * @param n
     * @return
     */
    public int fib2(int n) {
        if (n == 0) { return 0; }
        if (n == 1) { return 1; }
        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; ++i) { fib[i] = fib[i - 2] + fib[i - 1]; }
        return fib[n];
    }

    /**
     * 动态规划
     * 滚动数组
     * @param n
     * @return
     */
    public int fib3(int n) {
        if (n < 2) { return n; }
        int p = 0, q = 0, r = 1;
        for (int i = 2; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    /**
     * 通项公式
     * @param n
     * @return
     */
    public int fib4(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibN = Math.pow((1 + sqrt5) / 2, n) - Math.pow((1 - sqrt5) / 2, n);
        return (int) Math.round(fibN / sqrt5);
    }

}
