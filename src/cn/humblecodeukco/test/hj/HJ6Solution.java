package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author lyr
 * @Date 2020/11/24 20:50
 * @Version 1.0
 * @Description HJ6 质因子
 */
public class HJ6Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        StringBuilder sb = new StringBuilder();
        while ((str = bf.readLine()) != null) {
            int sum = Integer.valueOf(str);
            for (int i = 2; i <= Math.sqrt(sum); i++) {
                if (sum % i == 0) {
                    sb.append(i + " ");
                    sum /= i;
                    i--;
                }
            }
            sb.append(sum + " ");
            System.out.println(sb.toString());
        }
    }
}
