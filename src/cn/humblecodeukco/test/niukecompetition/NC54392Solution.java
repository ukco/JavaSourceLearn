package cn.humblecodeukco.test.niukecompetition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @Author lyr
 * @Date 2020/12/10 21:20
 * @Version 1.0
 * @Description
 */
public class NC54392Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = reader.readLine()) != null) {
            int num = Integer.parseInt(str);
            for (int i = 0; i < num; ++i) {
                str = reader.readLine();
                String[] arr = str.split(" ");
                Arrays.sort(arr);
                int a = Integer.parseInt(arr[0]);
                int b = Integer.parseInt(arr[1]);
                int c = Integer.parseInt(arr[2]);
                if (a == b && b == c) { System.out.println("equilateral"); }
                else if ((a * a + b * b) == (c * c)) { System.out.println("right"); }
                else if (a + b <= c) { System.out.println("error"); }
                else if (a + b > c) { System.out.println("normal"); }
            }
        }
    }
}
