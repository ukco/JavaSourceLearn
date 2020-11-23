package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author lyr
 * @Date 2020/11/23 21:52
 * @Version 1.0
 * @Description HJ9
 */
public class HJ9Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int tmp = Integer.parseInt(String.valueOf(s.charAt(i)));
            if (!set.contains(tmp)) {
                set.add(tmp);
                res = res * 10 + tmp;
            }
        }
        System.out.println(res);
    }

    public void solution2() throws Exception {
        InputStream in = System.in;
        int available = in.available() - 1;
        char[] chars = new char[available];
        while (available-- > 0) {
            chars[available] = (char) in.read();
        }
        StringBuilder resul = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (resul.lastIndexOf(String.valueOf(chars[i])) != -1) { continue; }
            resul.append(chars[i]);
        }
        System.out.println(resul.toString());
    }
}
