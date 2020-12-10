package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author lyr
 * @Date 2020/12/10 10:38
 * @Version 1.0
 * @Description HJ33
 */
public class HJ33Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while (null != (str = br.readLine())) {
            String[] ip = str.split("\\.");
            long num = Long.parseLong(br.readLine());
            // 转10进制
            System.out.println(Long.parseLong(ip[0]) << 24 | Long.parseLong(ip[1]) << 16 |
                    Long.parseLong(ip[2]) << 8 | Long.parseLong(ip[3]));
            // 转换ip地址
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf((num >> 24) & 255)).append(".").append(String.valueOf((num >> 16) & 255))
                    .append(".").append(String.valueOf((num >> 8) & 255)).append(".").append(String.valueOf(num & 255));
            System.out.println(sb.toString());
        }
    }
}
