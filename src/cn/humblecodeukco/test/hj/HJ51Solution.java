package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author lyr
 * @Date 2020/12/23 10:57
 * @Version 1.0
 * @Description HJ51 输出单向链表中倒数第k个结点
 */
public class HJ51Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = read.readLine()) != null) {
            int num = Integer.parseInt(str);
            String[] numStr = read.readLine().split(" ");
            int num2 = Integer.parseInt(read.readLine().trim());
            if (num2 <= 0 || num2 > numStr.length) { System.out.println(num2); }
            else { System.out.println(numStr[numStr.length - num2]); }
        }
    }
}
