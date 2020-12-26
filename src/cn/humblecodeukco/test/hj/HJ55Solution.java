package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author lyr
 * @Date 2020/12/26 13:20
 * @Version 1.0
 * @Description HJ55 挑7
 */
public class HJ55Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = read.readLine()) != null) {
            int range = Integer.parseInt(str);
            int count = 0;
            for (int i = 1; i <= range; i++) {
                if (i % 7 == 0) { ++count; }
                else {
                    String iTmp = String.valueOf(i);
                    if (iTmp.indexOf('7') != -1) { ++count; }
                }
            }
            System.out.println(count);
        }
    }
}
