package cn.humblecodeukco.test.leetcode;

import java.util.*;

/**
 * @Author lyr
 * @Date 2020/12/14 9:48
 * @Version 1.0
 * @Description 49 字母异位词分组
 */
public class GroupAnagrams {
    /**
     * 排序
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 计数
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            int[] counts = new int[26];
            int length = str.length();
            for (int i = 0; i < length; ++i) { counts[str.charAt(i) - 'a']++; }
            // 将每个出现次数大于0的字母和出现次数按顺序拼接成字符串，作为哈希表的键
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; ++i) {
                if (counts[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
}
