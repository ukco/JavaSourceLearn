package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author lyr
 * @Date 2020/12/25 10:45
 * @Version 1.0
 * @Description HJ53. 杨辉三角的变形
 */
public class HJ53Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = read.readLine()) != null) {
            System.out.println(getResult(str));
        }
    }
    private static int getResult(String str) {
        int i = Integer.parseInt(str);
        if (i <= 2) { return -1; }
        else if (i % 2 == 1) { return 2; }
        else {
            if (i % 4 == 0) { return 3; }
            else { return 4; }
        }
    }
}
