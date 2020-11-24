package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author lyr
 * @Date 2020/11/24 19:24
 * @Version 1.0
 * @Description HJ4
 */
public class HJ4Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = read.readLine()) != null) {
            int size = str.length() / 8;
            for (int i = 0; i < size; i++) {
                System.out.println(str.substring(i * 8, 8 * i + 8));
            }
            if (str.length() % 8 != 0) {
                String last = str.substring(size * 8);
                int length = 8 - last.length();
                for (int i = 0; i < length; i++) { last += "0"; }
                System.out.println(last);
            }
        }
    }
}
