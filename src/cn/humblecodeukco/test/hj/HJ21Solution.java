package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author lyr
 * @Date 2020/11/27 12:26
 * @Version 1.0
 * @Description HJ21
 */
public class HJ21Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        String str2 = "bcdefghijklmnopqrstuvwxyza222333444555666777788899990123456789";
        String a = br.readLine();
        char[] c = a.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < str1.length(); j++) {
                if (c[i] == str1.charAt(j)) {
                    sb.append(str2.charAt(j));
                    break;
                }
            }
        }
        System.out.println(sb.toString());
    }

    public void passwdTrans() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String pwd = bf.readLine();
        Map<Character, Character> map = new HashMap() {
            {
                put('1', '1');
                put('a', '2'); put('b', '2'); put('c', '2');
                put('d', '3'); put('e', '3'); put('f', '3');
                put('g', '4'); put('h', '4'); put('i', '4');
                put('j', '5'); put('k', '5'); put('l', '5');
                put('m', '6'); put('n', '6'); put('o', '6');
                put('p', '7'); put('q', '7'); put('r', '7'); put('s', '7');
                put('t', '8'); put('u', '8'); put('v', '8');
                put('w', '9'); put('x', '9'); put('y', '9'); put('z', '9');
                put('0', '0');
            }
        };
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pwd.length(); i++) {
            char tmp = pwd.charAt(i);
            if (tmp >= 'A' && tmp <= 'Z') {
                tmp = Character.toLowerCase(tmp);
                if (tmp == 'z') { tmp = 'a'; }
                else { tmp++; }
                sb.append(tmp);
            } else if (tmp >= 'a' && tmp <= 'z') {
                sb.append(map.get(tmp));
            } else { sb.append(tmp); }
        }
        System.out.println(sb.toString());
    }
}
