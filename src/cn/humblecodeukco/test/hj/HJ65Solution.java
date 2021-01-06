package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @Author lyr
 * @Date 2021/1/6 16:45
 * @Version 1.0
 * @Description HJ65 查找两个字符串a，b中的最长公共子串
 */
public class HJ65Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String stra;
        while ((stra = read.readLine()) != null) {
            String strb = read.readLine();
            if ("".equals(stra) || "".equals(strb)) { System.out.println(""); }
            int n = stra.length(), m = strb.length();
            if (n < m) {
                String tmp = stra;
                stra = strb;
                strb = tmp;
            }
            int count = Integer.MIN_VALUE;
            String res = "";
            for (int i = 0; i < stra.length();) {
                int j = 0, num = 0, index = 0;
                int iindex = i + 1;
                boolean flag = false, isFirst = true;
                while (j < strb.length()) {
                    if (i < stra.length() && j < strb.length() && stra.charAt(i++) == strb.charAt(j++)) {
                        if (isFirst) {
                            index = j - 1;
                            isFirst = false;
                        }
                        flag = true;
                        ++num;
                    }
                    if ( i < stra.length() && j < strb.length() && stra.charAt(i) != strb.charAt(j)) {
                        if (flag) { break; }
                        ++j;
                    }
                }
                if (count < num) {
                    count = num;
                    res = strb.substring(index, j);
                }
                i = iindex;
            }
            System.out.println(res);
        }
    }

    public void test() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String stra;
        while ((stra = read.readLine()) != null) {
            String strb = read.readLine();
            if ("".equals(stra) || "".equals(strb)) { System.out.println(""); }
            int n = stra.length(), m = strb.length();
            if (n > m) {
                String tmp = stra;
                stra = strb;
                strb = tmp;
            }
            int max = Integer.MIN_VALUE;
            char[] ch1 = stra.toCharArray();
            char[] ch2 = strb.toCharArray();
            int[][] ins = new int[stra.length() + 1][strb.length() + 1];
            int start = 0;
            for (int i = 0; i < stra.length(); ++i) {
                for (int j = 0; j < strb.length(); ++j) {
                    if (ch1[i] == ch2[j]) {
                        ins[i + 1][j + 1] = ins[i][j] + 1;
                        if (ins[i + 1][j + 1] > max) {
                            max = ins[i + 1][j + 1];
                            start = i - max;
                        }
                    }
                }
            }
            System.out.println(stra.substring(start + 1, start + max + 1));
        }
    }
}
