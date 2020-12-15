package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author lyr
 * @Date 2020/12/15 13:18
 * @Version 1.0
 * @Description HJ46 按字节截取字符串
 */
public class HJ46Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = reader.readLine()) != null) {
            int num = Integer.parseInt(reader.readLine());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < num; ++i) { sb.append(str.charAt(i)); }
            System.out.println(sb.toString());
        }
    }
}
