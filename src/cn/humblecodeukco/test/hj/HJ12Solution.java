package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @Author lyr
 * @Date 2020/11/24 10:31
 * @Version 1.0
 * @Description HJ12
 */
public class HJ12Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int j = s.length() - 1;
        while (j >= 0) {
            System.out.print(s.charAt(j--));
        }
    }

    public void solution2() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        StringBuilder sb = new StringBuilder(s);
        sb = sb.reverse();
        System.out.println(sb.toString());
    }
}
