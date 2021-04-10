package cn.humblecodeukco.test.leetcode;

/**
 * @Author lyr
 * @Date 2021/4/10 12:32
 * @Version 1.0
 * @Description 263. 丑数
 */
public class IsUgly {
    public boolean isUgly(int num) {
        if (num == 0) { return false; }
        while (true) {
            if (num == 1) { return true; }
            else if (num % 2 == 0) { num /= 2; }
            else if (num % 3 == 0) { num /= 3; }
            else if (num % 5 == 0) { num /= 5; }
            else { return false; }
        }
    }

    public boolean isUgly2(int num) {
        if (num <= 0) { return false; }
        int[] factors = new int[] {2, 3, 5};
        for (int factor : factors) {
            while (num % factor == 0) { num /= factor; }
        }
        return num == 1;
    }
}
