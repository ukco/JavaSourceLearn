package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author lyr
 * @Date 2020/12/14 12:31
 * @Version 1.0
 * @Description
 */
public class HJ40Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = reader.readLine()) != null) {
            int englishCharCount = 0;
            int blankCharCount = 0;
            int numberCharCount = 0;
            int otherCharCount = 0;
            char[] chars = line.toCharArray();
            for (int i = 0; i < chars.length; ++i) {
                if ((chars[i] >= 'a' && chars[i] <= 'z') || (chars[i] >= 'A' && chars[i] <= 'Z')) {
                    ++englishCharCount;
                    continue;
                } else if (chars[i] == ' ') {
                    ++blankCharCount;
                    continue;
                } else if (chars[i] >= '0' && chars[i] <= '9') {
                    ++numberCharCount;
                    continue;
                } else { ++otherCharCount; }
            }
            System.out.println(englishCharCount);
            System.out.println(blankCharCount);
            System.out.println(numberCharCount);
            System.out.println(otherCharCount);
        }
    }
}
