package cn.humblecodeukco.test.leetcode;

import java.util.*;

/**
 * @Author lyr
 * @Date 2020/11/19 12:32
 * @Version 1.0
 * @Description 17
 */
public class LetterCombinations {
    public static void main(String[] args) {
        LetterCombinationsSolution letterCombinationsSolution = new LetterCombinationsSolution();
        List<String> ret = letterCombinationsSolution.letterCombinations2("23");
        for (String string : ret) {
            System.out.println(string);
        }
    }
}

class LetterCombinationsSolution {
    /**
     * 回溯 深度优先搜索
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0) return combinations;
        Map<Character, String> phoneMap = new HashMap() {
            {
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }
        };
        backtrack(combinations, phoneMap, digits, 0, new StringBuilder());
        return combinations;
    }
    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuilder combination) {
        if (index == digits.length()) combinations.add(combination.toString());
        else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int letterCount = letters.length();
            for (int i = 0; i < letterCount; ++i) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }

    /**
     * 队列 广度优先搜索
     * @param digits
     * @return
     */
    public List<String> letterCombinations2(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0) return combinations;
        Map<Character, String> phoneMap = new HashMap() {
            {
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }
        };
        Queue<String> queue = new LinkedList<>();
        String letter = phoneMap.get(digits.charAt(0));
        for (int i = 0; i < letter.length(); ++i) {
            queue.offer(String.valueOf(letter.charAt(i)));
        }
        int index = 1;
        while (index < digits.length()) {
            int length = queue.size();
            for (int i = 0; i < length; ++i) {
                letter = phoneMap.get(digits.charAt(index));
                StringBuilder tmp = new StringBuilder(queue.poll());
                for (int j = 0; j < letter.length(); ++j) {
                    tmp.append(letter.charAt(j));
                    queue.offer(tmp.toString());
                    tmp.deleteCharAt(index);
                }
            }
            ++index;
        }
        return new ArrayList<>(queue);
    }
}
