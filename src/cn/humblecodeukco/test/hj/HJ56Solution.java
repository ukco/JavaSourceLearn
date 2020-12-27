package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author lyr
 * @Date 2020/12/27 12:29
 * @Version 1.0
 * @Description HJ56 完全数计算
 */
public class HJ56Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = read.readLine()) != null) {
            int range = Integer.parseInt(str);
            int count = 0;
            for (int i = 1; i <= range; ++i) {
                int sum = 0;
                for (int j = 1; j < i; ++j) {
                    if (i % j == 0) { sum += j; }
                }
                if (sum == i) { ++count; }
            }
            System.out.println(count);
        }
    }

    public void test2() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = read.readLine()) != null) {
            int range = Integer.parseInt(str);
            int count = 0;
            for (int i = 1; i <= range; ++i) {
                int sum = 1;
                for (int j = 2; j < Math.sqrt(i) + 1; ++j) {
                    if (i % j == 0) {
                        sum += j;
                        if (j * j == i) { continue; }
                        sum += i / j;
                    }
                }
                if (sum == i) { ++count; }
            }
            System.out.println(count);
        }
    }
}
