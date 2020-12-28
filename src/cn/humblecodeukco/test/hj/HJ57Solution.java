package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * @Author lyr
 * @Date 2020/12/28 12:30
 * @Version 1.0
 * @Description HJ57 高精度整数加法
 */
public class HJ57Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = read.readLine()) != null) {
            BigInteger a = new BigInteger(str);
            str = read.readLine();
            BigInteger b = new BigInteger(str);
            System.out.println(a.add(b));
        }
    }

    public void Solution2() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = read.readLine()) != null && line.length() > 0) {
            System.out.println(add(line.trim(), read.readLine().trim()));
        }
    }
    private static String add(String s1, String s2) {
        if (s1.length() == 0 || s2.length() == 0) { return ""; }
        boolean neg1 = s1.charAt(0) == '-';
        boolean neg2 = s2.charAt(0) == '-';

        if (neg1 == neg2) {
            if (s1.length() < s2.length()) {
                String tmp = s1;
                s1 = s2;
                s2 = tmp;
            }
        } else if (neg1) {
            if (s1.length() < s2.length() + 1) {
                String tmp = s1;
                s1 = s2;
                s2 = tmp;
                neg1 = false;
                neg2 = true;
            }
        } else if (neg2) {
            if (s1.length() + 1 < s2.length()) {
                String tmp = s1;
                s1 = s2;
                s2 = tmp;
                neg1 = true;
                neg2 = false;
            }
        }

        int[] lmax = new int[neg1 ? s1.length() - 1 : s1.length()];
        for (int i = neg1 ? 1 : 0; i < lmax.length; ++i) { lmax[i] = s1.charAt(i) - '0'; }
        int[] lmin = new int[neg2 ? s2.length() - 1 : s2.length()];
        for (int i = neg2 ? 1 : 0; i < lmin.length; ++i) { lmin[i] = s2.charAt(i) - '0'; }

        int i = lmax.length - 1, j = lmin.length - 1;
        if (neg1 == neg2) {
            int[] carry = new int[1];
            while (j >= 0) {
                add(lmax, i, lmin[j], carry);
                --i;
                --j;
            }
            StringBuilder sb = new StringBuilder();
            if (neg1)
                sb.append('-');
            if (carry[0] == 1)
                sb.append(1);
            for (i = 0; i < lmax.length; ++i)
                sb.append(lmax[i]);
            return sb.toString();
        } else {
            int flag = 0;
            boolean neg = true;
            if (i == j) {
                flag = -1;
                for (int k = 0; k <= i; ++k) {
                    if (lmax[k] > lmin[k]) {
                        flag = 0;
                        neg = neg1;
                        break;
                    } else if (lmax[k] < lmin[k]) {
                        flag = 1;
                        neg = neg2;
                        break;
                    }
                }
            }
            if (flag == -1)
                return "0";
            if (flag == 1) {
                int[] temp = lmax;
                lmax = lmin;
                lmin = temp;
            }
            while (j >= 0) {
                minus(lmax, i, lmin[j]);
                --i;
                --j;
            }
            int L = 0;
            for (i = 0; i < lmax.length; ++i) {
                if (lmax[i] == 0) {
                    ++L;
                } else {
                    break;
                }
            }
            StringBuilder sb = new StringBuilder();
            if (neg)
                sb.append('-');
            for (i = L; i < lmax.length; ++i)
                sb.append(lmax[i]);
            return sb.toString();
        }
    }

    static void add(int[] lmax, int i, int val, int[] carry) {
        if (i == -1) {
            carry[0] = 1;
            return;
        }
        lmax[i] += val;
        if (lmax[i] >= 10) {
            lmax[i] = lmax[i] - 10;
            add(lmax, --i, 1, carry);
        }
    }

    static void minus(int[] max, int i, int val) {
        max[i] -= val;
        if (max[i] < 0) {
            max[i] = max[i] + 10;
            minus(max, --i, 1);
        }
    }
}
