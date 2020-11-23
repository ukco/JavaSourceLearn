package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author lyr
 * @Date 2020/11/23 19:23
 * @Version 1.0
 * @Description HJ10
 */
public class HJ10Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int[] ascii = new int[128];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int tmp = ascii[s.charAt(i)];
            ascii[s.charAt(i)] = tmp + 1;
            if (tmp == 0) { count++; }
        }
        System.out.println(count);
    }
}
