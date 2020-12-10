package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @Author lyr
 * @Date 2020/12/10 20:36
 * @Version 1.0
 * @Description HJ34
 */
public class HJ34Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            char[] result = s.toCharArray();
            Arrays.sort(result);
            System.out.println(String.valueOf(result));
        }
    }
}
