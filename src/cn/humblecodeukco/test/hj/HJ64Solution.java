package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @Author lyr
 * @Date 2021/1/5 16:23
 * @Version 1.0
 * @Description HJ64. MP3光标位置
 */
public class HJ64Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = read.readLine()) != null) {
            String command = read.readLine();
            int num = Integer.parseInt(str);

            char[] array = command.toCharArray();
            int current = 1;
            int start = 1;
            for (char one: array) {
                if (num <= 4) {
                    if (one == 'U') {
                        if (current == 1) { current = num; }
                        else { --current; }
                    } else if (one == 'D') {
                        if (current == num) { current = 1; }
                        else { ++current; }
                    }
                } else {
                    if (one == 'U') {
                        if (current == 1) {
                            current = num;
                            start = num - 3;
                        } else if (current == start) {
                            --current;
                            --start;
                        } else { --current; }
                    } else if (one == 'D') {
                        if (current == num) {
                            current = 1;
                            start = 1;
                        } else if (current == start + 3) {
                            ++current;
                            ++start;
                        } else { ++current; }
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= 4; ++i) {
                if (num >= i) { sb.append(start + i - 1).append(" "); }
            }
            System.out.println(sb.toString().trim());
            System.out.println(current);
        }
    }
}
