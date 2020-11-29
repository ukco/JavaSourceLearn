package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author lyr
 * @Date 2020/11/26 20:54
 * @Version 1.0
 * @Description HJ19
 */
public class HJ20Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        StringBuffer sb = new StringBuffer();

        while ((input = reader.readLine()) != null) {

            // 设置四种类型数据初始为空即false，有数据了就更改为true
            boolean[] flag = new boolean[4];
            char[] chars = input.toCharArray();

            // 第一个条件
            if (chars.length < 9) {
                sb.append("NG").append("\n");
                continue;
            }

            // 第二个条件
            for (int i = 0; i < chars.length; i++) {
                if ('A' <= chars[i] && chars[i] <= 'Z') { flag[0] = true; }
                else if ('a' <= chars[i] && chars[i] <= 'z') { flag[1] = true; }
                else if ('0' <= chars[i] && chars[i] <= '9') { flag[2] = true; }
                else { flag[3] = true; }
            }
            int count = 0;
            for (int i = 0; i < 4; i++) {
                if (flag[i]) { count++; }
            }

            // 第三个条件
            // 不存在两个大于2的子串相同，即！（i=i+3,i+1=i+4,i+2=i+5）
            boolean sign = true;
            for (int i = 0; i < chars.length - 5; i++) {
                for (int j = i + 3; j < chars.length - 2; j++) {
                    if (chars[i] == chars[j] && chars[i + 1] == chars[j + 1] && chars[i + 2] == chars[j + 2]) {
                        sign = false;
                    }
                }
            }

            if (count >= 3 && sign) {
                sb.append("OK").append("\n");
            } else {
                sb.append("NG").append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
