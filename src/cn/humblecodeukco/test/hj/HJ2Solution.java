package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author lyr
 * @Date 2020/11/24 14:12
 * @Version 1.0
 * @Description HJ2
 */
public class HJ2Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String len = read.readLine().toLowerCase();
        String word = read.readLine().toLowerCase();
        int count = 0;
        for (int i = 0; i < len.length(); i++) {
            if (String.valueOf(len.charAt(i)).equals(word)) { count++; }
        }
        System.out.println(count);
    }
}
