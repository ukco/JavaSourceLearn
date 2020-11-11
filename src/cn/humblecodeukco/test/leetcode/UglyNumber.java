package cn.humblecodeukco.test.leetcode;

/**
 * @Author lyr
 * @Date 2020/11/11 12:26
 * @Version 1.0
 * @Description 263
 */
public class UglyNumber {
}

class UglyNumberSolution {
    public boolean isUgly(int num) {
        if (num < 1) return false;
        while (num % 2 == 0) num /= 2;
        while (num % 3 == 0) num /= 3;
        while (num % 5 == 0) num /= 5;
        return num == 1;
    }

    public boolean isUgly2(int num) {
        if (num == 0) return false;
        boolean flag = true;
        while (flag && num != 1) {
            flag = false;
            if (num % 2 == 0) {
                num = num >> 1;
                flag = true;
            } else if (num % 3 == 0) {
                num = num / 3;
                flag = true;
            } else if (num % 5 == 0) {
                num = num / 5;
                flag = true;
            }
        }
        return num == 1;
    }
}