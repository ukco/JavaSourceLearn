package cn.humblecodeukco.test.leetcode;

/**
 * @Author lyr
 * @Date 2021/3/17 17:06
 * @Version 1.0
 * @Description 29. 两数相除
 */
public class Divide {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) { return 0; }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean negative;
        // 用异或来计算是否符号相异
        negative = (dividend ^ divisor) < 0;
        long t = Math.abs((long) dividend);
        long d= Math.abs((long) divisor);
        int result = 0;
        for (int i= 31; i >= 0; i--) {
            // 找出足够大的数 2 ^ n * divisor
            if ((t >> i) >= d) {
                // 将结果加上 2 ^ n
                result += 1 << i;
                // 将被除数减去 2 ^ n * divisor
                t -= d << i;
            }
        }
        // 符号相异取反
        return negative ? -result : result;
    }
}
