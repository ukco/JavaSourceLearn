package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author lyr
 * @Date 2020/12/31 13:26
 * @Version 1.0
 * @Description HJ59. 找出字符串中第一个只出现一次的字符
 */
public class HJ59Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = read.readLine()) != null) {
            Map<Character, Integer> map = new LinkedHashMap<>();
            for (int i = 0; i < str.length(); ++i) {
                map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
            }
            boolean flag = false;
            Iterator<Map.Entry<Character, Integer>> entryIterator = map.entrySet().iterator();
            while (entryIterator.hasNext()) {
                Map.Entry<Character, Integer> entry = entryIterator.next();
                Character key = entry.getKey();
                int value = entry.getValue();
                if (value == 1) {
                    flag = true;
                    System.out.println(key);
                    break;
                }
            }
            if (!flag) { System.out.println(-1); }
        }
    }
}
