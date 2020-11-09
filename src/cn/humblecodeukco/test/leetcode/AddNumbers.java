package cn.humblecodeukco.test.leetcode;

/**
 * @Author lyr
 * @Date 2020/11/9 13:02
 * @Version 1.0
 * @Description 258
 */
public class AddNumbers {
    public static void main(String[] args) {
        System.out.println(new AddNumbersSolution().addDigits(9));
    }
}

class AddNumbersSolution {
    public int addDigits(int num) {
        int result = 0;
        while (true) {
            result += num % 10;
            num /= 10;
            if (num == 0) {
                num = result;
                if (result <= 9) return result;
                result = 0;
            }
        }
    }

    public int addDigits2(int num) {
        return (num - 1) % 9 + 1;
    }
}
