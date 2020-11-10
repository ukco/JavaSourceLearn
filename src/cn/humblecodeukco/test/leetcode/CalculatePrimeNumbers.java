package cn.humblecodeukco.test.leetcode;

import java.util.Arrays;

/**
 * @Author lyr
 * @Date 2020/11/10 12:20
 * @Version 1.0
 * @Description 204
 */
public class CalculatePrimeNumbers {
}

class CalculatePrimeNumbersSolution {
    /**
     * 暴力，超时
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; ++i) {
            boolean sign = true;
            for (int j = 2; j < i; ++j) {
                if (i % j == 0) {
                    sign = false;
                    break;
                }
            }
            if (sign) count++;
        }
        return count;
    }

    /**
     * 暴力优化
     * @param n
     * @return
     */
    public int countPrimes2(int n) {
        if (n < 3) return 0;
        // 从3开始验算，所以初始值为1（2为质数）。
        int count = 1;
        for (int i = 3; i < n; ++i) {
            // 当某个数为 2 的 n 次方时（n为自然数），其 & (n - 1) 所得值将等价于取余运算所得值
            // 如果 x = 2^n ，则 x & (n - 1) == x % n
            // if(i % 2 == 0)
            if ((i & 1) == 0) continue;
            boolean sign = true;
            // 用 j * j <= i 代替 j <= √i 会更好。
            // 因为我们已经排除了所有偶数，所以每次循环加二将规避偶数会减少循环次数
            for (int j = 3; j * j <= i; j += 2) {
                if (i % j == 0) {
                    sign = false;
                    break;
                }
            }
            if (sign) count++;
        }
        return count;
    }

    /**
     * 厄拉多塞筛法
     * @param n
     * @return
     */
    public int countPrimes3(int n) {
        int count = 0;
        boolean[] signs = new boolean[n];
        Arrays.fill(signs, true);
        for (int i = 2; i < n; ++i) {
            if (signs[i]) {
                count++;
                for (int j = i + i; j < n; j += i) signs[j] = false;
            }
        }
        return count;
    }
}
