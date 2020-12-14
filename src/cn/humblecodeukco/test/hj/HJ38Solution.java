package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author lyr
 * @Date 2020/12/13 20:49
 * @Version 1.0
 * @Description HJ38
 */
public class HJ38Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = reader.readLine()) != null) {
            double height = Double.parseDouble(str);
            double heighttmp = height;
            double count = height * 2.0;
            for (int i = 2; i < 5; ++i) {
                height = height / 2;
                count = count + height;
            }
            System.out.println(count);
            System.out.println(heighttmp / 32);
        }
    }
}
