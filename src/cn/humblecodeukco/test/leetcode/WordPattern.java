package cn.humblecodeukco.test.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lyr
 * @Date 2020/12/16 9:48
 * @Version 1.0
 * @Description 290 单词规律
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] arrays = s.split(" ");
        Map<Character, String> map = new HashMap<>();
        int i = 0;
        for (; i < pattern.length() && i < arrays.length; ++i) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                if (map.get(c).equals(arrays[i])) { continue; }
                return false;
            } else {
                if (map.containsValue(arrays[i])) { return false; }
                else { map.put(c, arrays[i]); }
            }
        }
        return i >= arrays.length && i >= pattern.length();
    }
}
