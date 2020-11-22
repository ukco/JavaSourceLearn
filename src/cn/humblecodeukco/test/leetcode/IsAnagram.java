package cn.humblecodeukco.test.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author lyr
 * @Date 2020/11/22 15:23
 * @Version 1.0
 * @Description 242
 */
public class IsAnagram {
}

class IsAnagramSolution {
    /**
     * 排序
     * t 是 s 的异位词等价于「两个字符串排序后相等」。
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    /**
     * 哈希表
     * t 是 s 的异位词等价于「两个字符串中字符出现的种类和次数均相等」。
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); ++i) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> table = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            table.put(ch, table.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < t.length(); ++i) {
            char ch = t.charAt(i);
            table.put(ch, table.getOrDefault(ch, 0) - 1);
            if (table.get(ch) < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram4(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            table[s.charAt(i) - 'a'] ++;
            table[t.charAt(i) - 'a'] --;
        }
        for (int i = 0; i < 26; ++i) {
            if (table[i] != 0) {
                return false;
            }
        }
        return true;
    }
}