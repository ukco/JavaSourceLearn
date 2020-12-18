package cn.humblecodeukco.test.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lyr
 * @Date 2020/12/18 9:45
 * @Version 1.0
 * @Description 389. 找不同
 */
public class FindTheDifferenceSolution {
    /**
     * map
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); ++i) {
            if (map.containsKey(t.charAt(i))) {
                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
            } else { return t.charAt(i); }
        }
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            if (entry.getValue() != 0) { return entry.getKey(); }
        }
        return ' ';
    }

    /**
     * 数组
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference2(String s, String t) {
        int[] array = new int[26];
        for (int i = 0; i < s.length(); ++i) { ++array[s.charAt(i) - 'a']; }
        for (int i = 0; i < t.length(); ++i) {
            if (array[t.charAt(i) - 'a'] == 0) { return t.charAt(i); }
            else { --array[t.charAt(i) - 'a'];}
        }
        for (int i = 0; i < 26; ++i) {
            if (array[i] != 0) { return (char) ('a' + i); }
        }
        return ' ';
    }

    /**
     * 计数
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference3(String s, String t) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            cnt[ch - 'a']++;
        }
        for (int i = 0; i < t.length(); ++i) {
            char ch = t.charAt(i);
            cnt[ch - 'a']--;
            if (cnt[ch - 'a'] < 0) { return ch; }
        }
        return ' ';
    }

    /**
     * 求和
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference4(String s, String t) {
        int as = 0, at = 0;
        for (int i = 0; i < s.length(); ++i) { as += s.charAt(i); }
        for (int i = 0; i < t.length(); ++i) { at += t.charAt(i); }
        return (char) (at - as);
    }

    /**
     * 位运算
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference5(String s, String t) {
        int ret = 0;
        for (int i = 0; i < s.length(); ++i) { ret ^= s.charAt(i); }
        for (int i = 0; i < t.length(); ++i) { ret ^= t.charAt(i); }
        return (char) ret;
    }
}
