package cn.humblecodeukco.test.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author lyr
 * @Date 2020/12/20 11:59
 * @Version 1.0
 * @Description 316. 去除重复字母
 */
public class RemoveDuplicateLetters {
    /**
     * 贪心 + 栈
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {
        int len = s.length();
        char[] charArray = s.toCharArray();
        int[] lastIndex = new int[26];
        for (int i = 0; i < len; i++) { lastIndex[charArray[i] - 'a'] = i; }

        Deque<Character> stack = new ArrayDeque<>();
        // 记录每个字符在栈中是否出现
        boolean[] visited = new boolean[26];
        for (int i = 0; i < len; i++) {
            if (visited[charArray[i] - 'a']) { continue; }
            while (!stack.isEmpty() && stack.peekLast() > charArray[i] && lastIndex[stack.peekLast() - 'a'] > i) {
                Character top = stack.removeLast();
                visited[top - 'a'] = false;
            }
            stack.addLast(charArray[i]);
            visited[charArray[i] - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack) { sb.append(c); }
        return sb.toString();
    }
}
