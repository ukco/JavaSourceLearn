package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author lyr
 * @Date 2020/11/30 21:52
 * @Version 1.0
 * @Description
 */
public class HJ23Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        Map<Character, Integer> map = new LinkedHashMap<>();
        while (null != (str = br.readLine())) {
            char[] array = str.toCharArray();
            for (int i = 0; i < array.length; i++) {
                map.put(array[i], map.getOrDefault(array[i], 0) + 1);
            }
            int min = Integer.MAX_VALUE;
            for (Character key : map.keySet()) {
                if (min > map.get(key)) { min = map.get(key); }
            }
            StringBuilder sb = new StringBuilder();
            for (Character c : array) {
                if (min != map.get(c)) { sb.append(c); }
            }
            System.out.println(sb.toString());
            sb.delete(0, sb.length() - 1);
            map.clear();
        }
    }
}
