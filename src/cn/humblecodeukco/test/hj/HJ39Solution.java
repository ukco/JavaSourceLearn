package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author lyr
 * @Date 2020/12/17 10:21
 * @Version 1.0
 * @Description HJ38 判断两个IP是否属于同一子网
 */
public class HJ39Solution {
    private static int N = 4;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = reader.readLine()) != null) {
            String[] mask = str.split("\\.");
            String[] ip1 = reader.readLine().split("\\.");
            String[] ip2 = reader.readLine().split("\\.");
            if (!valid(mask) || !valid(ip1) || !valid(ip2) || maskValid(mask)) { System.out.println(1); }
            else {
                long maskBinary = getIPBinary(mask);
                long l1 = and(ip1, maskBinary);
                long l2 = and(ip2, maskBinary);
                System.out.println(l1 == l2 ? 0 : 2);
            }
        }
    }
    private static boolean valid(String[] ip) {
        for (int i = 0; i < N; ++i) {
            int value = Integer.parseInt(ip[i]);
            if (value > 255 || value < 0) { return false; }
        }
        return true;
    }
    private static boolean maskValid(String[] mask) {
        long res = getIPBinary(mask);
        String s = Long.toBinaryString(res);
        StringBuilder builder = new StringBuilder(32);
        builder.append(s);
        while (builder.length() < 32) { builder.insert(0, "0"); }
        String s1 = builder.toString();
        boolean flag = false;
        boolean isError = false;
        for (int i = 0; i < s1.length(); ++i) {
            if (flag) {
                if (s1.charAt(i) == '1') {
                    isError = true;
                    break;
                }
            } else {
                if (s1.charAt(i) == '0') { flag = true; }
            }
        }
        return isError;
    }
    private static long getIPBinary(String[] ip) {
        long res = 0;
        for (int i = 0; i < N; ++i) {
            // * 优先级大于 <<
            res += Integer.parseInt(ip[i]) << 8 * (N - i -1);
        }
        return res;
    }
    private static long and(String[] ip, long mask) {
        long res = getIPBinary(ip);
        return res & mask;
    }
}
