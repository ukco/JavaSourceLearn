package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author lyr
 * @Date 2020/12/12 14:18
 * @Version 1.0
 * @Description HJ35
 */
public class HJ35Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            int num = Integer.parseInt(str);
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= num; ++i) {
                int start = (i - 1) * i / 2 + 1;
                int step = i + 1;
                for (int j = 1; j <= num - i + 1; ++j) {
                    sb.append(start).append(" ");
                    start += step;
                    ++step;
                }
                sb.setCharAt(sb.length() - 1, '\n');
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb.toString());
        }
    }
}
