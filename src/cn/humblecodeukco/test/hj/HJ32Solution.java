package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author lyr
 * @Date 2020/12/8 15:38
 * @Version 1.0
 * @Description HJ32
 */
public class HJ32Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = reader.readLine()) != null) {
            int max = 0;
            char[] arr = str.toCharArray();
            for (int i = 0; i < arr.length; ++i) {
                int left = i - 1;
                int right = i;
                while (left >= 0 && right < arr.length && arr[left] == arr[right]) {
                    if (right - left + 1 > max) { max = right - left + 1; }
                    --left;
                    ++right;
                }
                left = i - 1;
                right = i + 1;
                while (left >= 0 && right < arr.length && arr[left] == arr[right]) {
                    if (right - left + 1 > max) { max = right - left + 1; }
                    --left;
                    ++right;
                }
            }
            System.out.println(max);
        }
    }
}
