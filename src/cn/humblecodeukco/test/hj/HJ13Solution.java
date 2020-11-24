package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/**
 * @Author lyr
 * @Date 2020/11/24 10:41
 * @Version 1.0
 * @Description HJ13
 */
public class HJ13Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        System.out.println(String.join(" ", words));
    }
}
