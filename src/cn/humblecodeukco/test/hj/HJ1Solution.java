package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author lyr
 * @Date 2020/11/24 14:25
 * @Version 1.0
 * @Description HJ1
 */
public class HJ1Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine().trim();
        int length = str.length() - 1;
        int count = 0;
        while (length >= 0 && str.charAt(length) != ' ') {
            count++;
            length--;
        }
        System.out.println(count);
    }
}
