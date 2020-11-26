package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author lyr
 * @Date 2020/11/26 18:43
 * @Version 1.0
 * @Description HJ18
 */
public class HJ18Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int a = 0, b = 0, c = 0, d = 0, e = 0, err = 0, pri = 0;
        String str = null;
        while ((str = bf.readLine()) != null) {
            int idx = str.indexOf('~');
            long ip = ip2num(str.substring(idx + 1));
            if (ip <= 0 || ip >= 0XFFFFFFFFL || (((ip ^ 0XFFFFFFFFL)+1)|ip)!=ip) {
                err += 1;
                continue;
            }
            ip = ip2num(str.substring(0, idx));
            long iph = ip >> 24;
            if (ip < 0L || ip > 0XFFFFFFFFL) { err++; }
            else if (iph >=1 && iph <= 126) {
                a++;
                if (iph == 10) { pri++; }
            } else if (iph>= 128 && iph <= 191) {
                b++;
                if (ip >> 20 == 0xAC1) { pri++; }
            } else if (iph >= 192 && iph <= 223) {
                c++;
                if (ip >> 16 == 0xC0A8) { pri++; }
            } else if (iph >= 224 && iph<= 239) { d++; }
            else if (iph >= 240 && iph <= 255) { e++; }
        }
        System.out.println(a+" " + b + " " + c+" " + d+ " " + e+ " " + err+" " + pri);
    }
    private static long ip2num(String ip) {
        long num = 0;
        int flag = 1, temp = 0;
        char[] chars = ip.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '.') {
                // | 或运算符 两个位都为0时，结果才为0
                num = num << 8 | temp;
                temp = 0;
                flag++;
                continue;
            }
            if (flag >= 2) { return -1; }
            if (chars[i] >= '0' && chars[i] <= '9') {
                temp = temp * 10 + chars[i] - '0';
                flag = 0;
            } else {
                flag = 3;
                break;
            }
        }
        if (flag >= 2) { return -1; }
        num = num << 8 | temp;
        return num;
    }
}