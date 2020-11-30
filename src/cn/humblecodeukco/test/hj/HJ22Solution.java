package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author lyr
 * @Date 2020/11/30 11:05
 * @Version 1.0
 * @Description HJ22
 */
public class HJ22Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while ((str = br.readLine()) != null) {
            int g = 0;
            g = Integer.parseInt(str);

            if (g == 0) { return; }

            int count = 0;

            while (g != 0) {
                int f = g / 3;
                count += f;
                g = g % 3 + f;
                if (g < 3) { break; }
            }
            if (g == 2) { count += 1; }
            System.out.println(count);
        }
    }
}
