package cn.humblecodeukco.test.leetcode;

import java.util.Arrays;

/**
 * @Author lyr
 * @Date 2020/12/15 13:00
 * @Version 1.0
 * @Description 738.单调递增的数字
 */
public class MonotoneIncreasingDigits {
    /**
     * 贪心
     * @param N
     * @return
     */
    public int monotoneIncreasingDigits(int N) {
        char[] strN = Integer.toString(N).toCharArray();
        int i = 1;
        while (i < strN.length && strN[i - 1] <= strN[i]) { ++i; }
        if (i < strN.length) {
            while (i > 0 && strN[i - 1] > strN[i]) {
                --strN[i - 1];
                --i;
            }
            for (++i; i < strN.length; ++i) { strN[i] = '9'; }
        }
        return Integer.parseInt(new String(strN));
    }

    /**
     * 超出时间限制
     * @param N
     * @return
     */
    public int monotoneIncreasingDigits2(int N) {
        while (N >= 0) {
            char[] strN = Integer.toString(N).toCharArray();
            Arrays.sort(strN);
            if (Integer.parseInt(new String(strN)) == N) { return N; }
            N--;
        }
        return 0;
    }
}
