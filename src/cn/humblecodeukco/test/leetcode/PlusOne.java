package cn.humblecodeukco.test.leetcode;


/**
 * @Author lyr
 * @Date 2020/10/6 13:34
 * @Version 1.0
 * @Description 66
 */
public class PlusOne {
    public static void main(String[] args) {
        PlusOneSolutin plusOneSolutin = new PlusOneSolutin();
        int[] res = plusOneSolutin.plusOne(new int[] {2, 9});
        for (int i: res) {
            System.out.print(i);
        }
    }
}

class PlusOneSolutin {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; --i) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}