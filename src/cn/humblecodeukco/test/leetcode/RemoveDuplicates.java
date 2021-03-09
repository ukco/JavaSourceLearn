package cn.humblecodeukco.test.leetcode;

/**
 * @Author lyr
 * @Date 2021/3/9 14:17
 * @Version 1.0
 * @Description 1047. 删除字符串中的所有相邻重复项
 */
public class RemoveDuplicates {
    public String removeDuplicates(String S) {
        StringBuilder stack = new StringBuilder();
        int top = -1;
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (top >= 0 && stack.charAt(top) == ch) {
                stack.deleteCharAt(top);
                --top;
            } else {
                stack.append(ch);
                ++top;
            }
        }
        return stack.toString();
    }
}
