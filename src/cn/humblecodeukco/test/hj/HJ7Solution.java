package cn.humblecodeukco.test.hj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author lyr
 * @Date 2020/11/23 16:29
 * @Version 1.0
 * @Description HJ7
 */
public class HJ7Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int index = s.indexOf(".");
        int a = Integer.parseInt(s.substring(0, index));
        int b = Integer.parseInt(s.substring(index + 1, s.length()));
        if (b >= 10) {
            while (b > 10) {
                b /= 10;
            }
        }
        if (b >= 5) {
            System.out.println(a + 1);
        } else {
            System.out.println(a);
        }
    }
}
