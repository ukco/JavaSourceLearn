package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author lyr
 * @Date 2020/12/6 17:14
 * @Version 1.0
 * @Description HJ29
 */
public class HJ29Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            String word = br.readLine();
            System.out.println(encrypt(str));
            System.out.println(decrypt(word));
        }
    }
    private static String encrypt(String str) {
        char[] ch = str.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < ch.length; ++i) {
            if (ch[i] >= 'a' && ch[i] <= 'z') {
                if (ch[i] == 'z') { sb.append('A'); }
                else { sb.append((char) (ch[i] - 32 + 1)); }
            } else if (ch[i] >= 'A' && ch[i] <= 'Z') {
                if (ch[i] == 'Z') { sb.append('a'); }
                else { sb.append((char) (ch[i] + 32 + 1)); }
            } else if (ch[i] >= '0' && ch[i] <= '9') {
                if (ch[i] == '9') { sb.append('0'); }
                else { sb.append(ch[i] - '0' + 1); }
            }
        }
        return sb.toString();
    }
    private static String decrypt(String str) {
        char[] ch = str.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (char c: ch) {
            if (c >= 'a' && c <= 'z') {
                if (c == 'a') { sb.append('Z'); }
                else { sb.append((char) (c - 32 - 1)); }
            } else if (c >= 'A' && c <= 'Z') {
                if (c == 'A') { sb.append('z'); }
                else { sb.append((char) (c + 32 - 1)); }
            } else if (c >= '0' && c <= '9') {
                if (c == '0') { sb.append('9'); }
                else { sb.append(c - '0' - 1); }
            }
        }
        return sb.toString();
    }
}
