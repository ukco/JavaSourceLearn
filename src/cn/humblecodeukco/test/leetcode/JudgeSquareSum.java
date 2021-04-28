package cn.humblecodeukco.test.leetcode;

/**
 * @Author lyr
 * @Date 2021/4/28 9:39
 * @Version 1.0
 * @Description 633. 平方数之和
 */
public class JudgeSquareSum {
    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; ++a) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b) { return true; }
        }
        return false;
    }

    /**
     * 双指针
     * @param c
     * @return
     */
    public boolean judgeSquareSum2(int c) {
        int left = 0;
        int right = (int) Math.sqrt(c);
        while (left <= right) {
            int sum = left * left + right * right;
            if (sum == c) { return true; }
            else if (sum > c) { right--; }
            else { left++; }
        }
        return false;
    }
}
