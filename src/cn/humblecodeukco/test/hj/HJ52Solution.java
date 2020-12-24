package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author lyr
 * @Date 2020/12/24 10:59
 * @Version 1.0
 * @Description HJ52 计算字符串的距离
 */
public class HJ52Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String a;
        while ((a = read.readLine()) != null) {
            String b = read.readLine();
            System.out.println(stringDistance(a.toCharArray(), b.toCharArray()));
        }
    }
    private static int stringDistance(char[] a, char[] b) {
        int[][] len = new int[a.length + 1][b.length + 1];
        for (int i = 0; i < a.length + 1; ++i) { len[i][0] = i; }
        for (int j = 0; j < b.length + 1; ++j) { len[0][j] = j; }

        for (int i = 1; i < a.length + 1; ++i) {
            for (int j = 1; j < b.length + 1; ++j) {
                if (a[i - 1] == b[j - 1]) { len[i][j] = len[i - 1][j - 1]; }
                else { len[i][j] = Math.min(Math.min(len[i - 1][j], len[i - 1][j - 1]), len[i][j - 1]) + 1; }
            }
        }
        return len[a.length][b.length];
    }
}
