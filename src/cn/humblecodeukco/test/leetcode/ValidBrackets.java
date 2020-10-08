package cn.humblecodeukco.test.leetcode;

import java.util.*;

/**
 * @Author lyr
 * @Date 2020/10/4 19:35
 * @Version 1.0
 * @Description 20
 */
public class ValidBrackets {
    public static void main(String[] args) {
        System.out.println(new ValidBracketsSolution().isValid("[])"));
    }
}

//class ValidBracketsSolution {
//    public boolean isValid(String s) {
//        int n = s.length();
//        if (n % 2 == 1) return false;
//
//        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
//           put(')', '(');
//           put(']', '[');
//           put('}', '{');
//        }};
//        Deque<Character> stack = new LinkedList<>();
//        for (int i = 0; i < n; ++i) {
//            char ch = s.charAt(i);
//            if (pairs.containsKey(ch)) {
//                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
//                    return false;
//                }
//                stack.pop();
//            } else {
//                stack.push(ch);
//            }
//        }
//        return stack.isEmpty();
//    }
//}

class ValidBracketsSolution {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (char c: s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else if (stack.isEmpty() || c != stack.pop()) return false;
        }
        return stack.isEmpty();
    }
}