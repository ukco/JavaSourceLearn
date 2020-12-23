package cn.humblecodeukco.test.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @Author lyr
 * @Date 2020/12/23 9:32
 * @Version 1.0
 * @Description 387. 字符串中的第一个唯一字符
 */
public class FirstUniqChar {
    /**
     * 哈希表存储频数
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        Map<Character, Integer> frequency = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) { frequency.put(s.charAt(i), frequency.getOrDefault(s.charAt(i), 0) + 1); }
        for (int i = 0; i < s.length(); i++) {
            if (frequency.get(s.charAt(i)) == 1) { return i; }
        }
        return -1;
    }

    /**
     * 哈希表存储索引
     * @param s
     * @return
     */
    public int firstUniqChar2(String s) {
        Map<Character, Integer> position = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (position.containsKey(ch)) { position.put(ch, -1); }
            else { position.put(ch, i); }
        }
        /*int first = n;
        for (Map.Entry<Character, Integer> entry : position.entrySet()) {
            int pos = entry.getValue();
            if (pos != -1 && pos < first) { first = pos; }
        }
        if (first == n) { return -1; }
        return first;*/
        // 解决lambda修改不了局部变量的问题
        /*int[] first = {n};
        position.forEach((k, v) -> { if (v != -1 && v < first[0]) { first[0] = v; } });
        if (first[0] == n) { return -1; }
        return first[0];*/

        int[] first = {n};
        position.entrySet().stream().forEach((entry) -> {
            int pos = entry.getValue();
            if (pos != -1 && pos < first[0]) { first[0] = pos; }
        });
        if (first[0] == n) { return -1; }
        return first[0];
    }

    /**
     * 队列
     * @param s
     * @return
     */
    public int firstUniqChar3(String s) {
        Map<Character, Integer> position = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (!position.containsKey(ch)) {
                position.put(ch, i);
                queue.offer(new Pair(ch, i));
            } else {
                position.put(ch, -1);
                while (!queue.isEmpty() && position.get(queue.peek().ch) == -1) { queue.poll(); }
            }
        }
        return queue.isEmpty() ? -1 : queue.poll().pos;
    }
    class Pair {
        char ch;
        int pos;
        Pair(char ch, int pos) {
            this.ch = ch;
            this.pos = pos;
        }
    }
}
