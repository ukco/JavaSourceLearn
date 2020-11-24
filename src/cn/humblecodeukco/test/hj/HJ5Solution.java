package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author lyr
 * @Date 2020/11/24 12:22
 * @Version 1.0
 * @Description HJ5
 */
public class HJ5Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = bf.readLine()) != null) {
            String temp = input.substring(2);
            int sum = 0;
            int length = temp.length();

            for (int i = length - 1; i >= 0; i--) {
                char c = temp.charAt(i);
                int tempNum = (int) c;
                if (tempNum >= 65) { tempNum = tempNum - 65 + 10; }
                else { tempNum = tempNum - 48; }
                sum = sum + (int) Math.pow(16, length - i - 1) * tempNum;
            }
            System.out.println(sum);
        }
    }

    public void solution2() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = bf.readLine()) != null) {
            System.out.println(Long.parseLong(line.substring(2), 16));
        }
    }
}
