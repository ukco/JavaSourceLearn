package cn.humblecodeukco.test.Sword;

/**
 * @Author lyr
 * @Date 2020/10/4 18:53
 * @Version 1.0
 * @Description JZ7, 10
 */
public class FibonacciSequence {
    public static void main(String[] args) {
        System.out.println(new FibonacciSequenceSolution().Fibonacci(8));
    }
}

// 递归
//class FibonacciSequenceSolution {
//    public int Fibonacci(int n) {
//        if (n == 0) return 0;
//        if (n == 1) return 1;
//        return Fibonacci(n - 1) + Fibonacci(n - 2);
//    }
//}

class FibonacciSequenceSolution {
    public int Fibonacci(int n) {
        int result[] = new int[]{0, 1};
        if (n < 2) return result[n];

        int fibNMinusOne = 1;
        int fibNMinusTwo = 0;
        int fibN = 0;

        for (int i = 2; i <= n; ++i) {
            fibN = fibNMinusOne + fibNMinusTwo;
            fibNMinusTwo = fibNMinusOne;
            fibNMinusOne = fibN;
        }

        return fibN;
    }
}