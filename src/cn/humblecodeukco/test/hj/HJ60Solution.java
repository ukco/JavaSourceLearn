package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author lyr
 * @Date 2021/1/2 17:40
 * @Version 1.0
 * @Description HJ60 查找组成一个偶数最接近的两个素数
 */
public class HJ60Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = read.readLine()) != null) {
            int number = Integer.parseInt(str);
            int range = Integer.MAX_VALUE;
            int prev = 0, post = 0;
            for (int i = 2; i <= number / 2; ++i) {
                if (isPrime(i) && isPrime(number - i)) {
                    if ((number - i - i) < range) {
                        range = number - i - i;
                        prev = i;
                        post = number - i;
                    }
                }
            }
            System.out.println(prev);
            System.out.println(post);
        }
    }
    private static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); ++i) {
            if (n % i == 0) { return false;}
        }
        return true;
    }
}
