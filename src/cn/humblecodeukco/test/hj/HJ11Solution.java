package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @Author lyr
 * @Date 2020/11/24 9:34
 * @Version 1.0
 * @Description HJ11
 */
public class HJ11Solution {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int num = cin.nextInt();
        char[] numChars = String.valueOf(num).toCharArray();
        int i = 0, j = numChars.length - 1;
        while (i < j) {
            char tmp = numChars[i];
            numChars[i] = numChars[j];
            numChars[j] = tmp;
            i++;
            j--;
        }
        System.out.println(numChars);
    }

    public void solution2() throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        StringBuilder sb = new StringBuilder(s);
        sb = sb.reverse();
        System.out.println(sb.toString());
    }
}
