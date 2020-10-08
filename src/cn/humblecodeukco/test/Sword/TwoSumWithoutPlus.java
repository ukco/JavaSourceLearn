package cn.humblecodeukco.test.Sword;

/**
 * @Author lyr
 * @Date 2020/9/22 22:32
 * @Version 1.0
 * @Description JZ48, 65
 */
public class TwoSumWithoutPlus {
    public static void main(String[] args) {
        TwoSumWithoutPlusSolution twoSumWithoutPlusSolution = new TwoSumWithoutPlusSolution();
        System.out.println(twoSumWithoutPlusSolution.Add(1, 0));
    }
}

class TwoSumWithoutPlusSolution {
    public int Add(int num1, int num2) {
        // 不带进位的结果
        int sum = 0;
        // 记录的进位
        int carry = 0;
        do {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        } while (num2 != 0);
        return sum;
    }
}
