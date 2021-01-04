package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author lyr
 * @Date 2021/1/4 12:11
 * @Version 1.0
 * @Description HJ62. 查找输入整数二进制中1的个数
 */
public class HJ62Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = read.readLine()) != null) {
            int number = Integer.parseInt(str);
            int count = 0;
            while (number != 0) {
                if ((number & 1) == 1) { ++count; }
                number >>= 1;
            }
            System.out.println(count);
        }
    }
}
