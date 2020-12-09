package cn.humblecodeukco.test.niukecompetition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author lyr
 * @Date 2020/12/9 20:29
 * @Version 1.0
 * @Description
 */
public class POJ1000Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String in = read.readLine();
        String[] inarr = in.split(" ");
        int a = Integer.parseInt(inarr[0]);
        int b = Integer.parseInt(inarr[1]);
        System.out.println(a + b);
    }
}
