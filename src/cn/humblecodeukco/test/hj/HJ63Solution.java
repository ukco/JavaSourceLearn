package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @Author lyr
 * @Date 2021/1/4 21:13
 * @Version 1.0
 * @Description HJ63. DNA序列
 */
public class HJ63Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = read.readLine()) != null) {
            int n = Integer.parseInt(read.readLine());
            int p = Integer.MIN_VALUE;
            int count = 0;
            String res = "";
            for (int i = 0; i <= str.length() - n; ++i) {
                for (int j = i; j < n + i; ++j) {
                    if (str.charAt(j) == 'C' || str.charAt(j) == 'G') { ++count; }
                }
                if (p < count) {
                    p = count;
                    res = str.substring(i, i + n);
                }
                count = 0;
            }
            System.out.println(res);
        }
    }
}
