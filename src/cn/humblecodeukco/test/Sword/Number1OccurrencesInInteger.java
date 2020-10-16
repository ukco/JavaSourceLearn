package cn.humblecodeukco.test.Sword;

/**
 * @Author lyr
 * @Date 2020/10/16 20:05
 * @Version 1.0
 * @Description JZ31, 43
 */
public class Number1OccurrencesInInteger {
    public static void main(String[] args) {

    }
}

//class Number1OccurrencesInIntegerSolution {
//    public int NumberOf1Between1AndN_Solution(int n) {
//        int number = 0;
//        for (int i = 1; i <= n; ++i) {
//            number += NumberOf(i);
//        }
//        return number;
//    }
//
//    public int NumberOf(int n) {
//        int number = 0;
//        while (n != 0) {
//            if (n % 10 == 1)
//                number++;
//            n /= 10;
//        }
//        return number;
//    }
//}

class Number1OccurrencesInIntegerSolution {
    public int NumberOf1Between1AndN_Solution(int n) {
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while (high != 0 || cur != 0) {
            if (cur == 0) res += high * digit;
            else if (cur == 1) res += high * digit + low + 1;
            else res += (high + 1) * digit;
            low += cur *digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }
}