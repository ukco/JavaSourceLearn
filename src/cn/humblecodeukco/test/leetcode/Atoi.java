package cn.humblecodeukco.test.leetcode;

import com.sun.org.apache.bcel.internal.generic.INEG;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lyr
 * @Date 2020/9/21 18:58
 * @Version 1.0
 * @Description 8
 */
public class Atoi {
    public static void main(String[] args) {
        AtoiSolution atoiSolution = new AtoiSolution();
        System.out.println(atoiSolution.myAtoi("  -42"));
    }
}

//class AtoiSolution {
//    public int myAtoi(String str) {
//        if(str.length() == 0) return 0;
//        int start = 0, end = str.length();
//        while (start < end && str.charAt(start) == ' ') ++start;
//        if (start == end) return 0;
//        if(str.charAt(start) == '-' || str.charAt(start) == '+') {
//            if (start == end -1 ) {
//                return 0;
//            } else {
//                if (!Character.isDigit(str.charAt(start + 1))) return 0;
//            }
//        } else if (!Character.isDigit(str.charAt(start))) return 0;
//
//        StringBuilder sb = new StringBuilder();
//        // 可能有符号，先存入sb
//        sb.append(str.charAt(start++));
//        while (start  < end && Character.isDigit(str.charAt(start))) {
//            sb.append(str.charAt(start++));
//        }
//        if(sb.charAt(0) == '+') {
//            return convertToInt(sb.substring(1, sb.length()), '+');
//        } else if (sb.charAt(0) == '-') {
//            return convertToInt(sb.substring(1, sb.length()), '-');
//        } else {
//            return convertToInt(sb.toString(), ' ');
//        }
//    }
//    public int convertToInt (String sb, char flag) {
//        int len = sb.length();
//        int result = 0;
//        for (int i = 0; i <= len - 1; i++) {
//            // *10和 +sb.charAt(i)都有可能越界，所以都移动到右边去就可以了
//            if (result > (Integer.MAX_VALUE - (sb.charAt(i) - '0')) / 10) {
//                if (flag == '-') {
//                    return Integer.MIN_VALUE;
//                } else return Integer.MAX_VALUE;
//            }
//            result = result * 10 + (sb.charAt(i) - '0');
//        }
//        if (flag == '+' || flag == ' ') {
//            return result;
//        } else {
//            return -result;
//        }
//        //return Integer.parseInt(sb);
//    }
//}

// 上面方法的简化版
// 明确转换规则：空格处理、正负号处理、数字处理(result = result * 10 + num)
//              模式识别：整数运算注意溢出、转换为INT_MAX的逆运算
//class AtoiSolution {
//    public int myAtoi(String str) {
//        int res = 0;
//        int i = 0;
//        int flag = 1;
//        while (str.charAt(i) == ' ') {++i;}
//        if (str.charAt(i) == '-') {flag = -1;}
//        if (str.charAt(i) == '+' || str.charAt(i) == '-') {++i;}
//        while (i<str.length() && Character.isDigit(str.charAt(i))) {
//            int r = str.charAt(i) - '0';
//            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && r > 7)) {
//                return flag > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
//            }
//            res = res * 10 + r;
//            i++;
//        }
//        return flag > 0 ? res : -res;
//    }
//}

// 方法一：自动机
// 时间复杂度：O(n)
// 空间复杂度：O(1)，自动机的状态只需要常数空间存储
class AtoiSolution {
    /**
     * 我们的程序在每个时刻有一个状态s，每次从序列中输入一个字符c，并根据字符c转移
     * 到下一个状态s'。这样，我们需要建立一个覆盖所有情况的从s与c映射到s'的表格即可
     * 解决题目中的问题
     * https://leetcode-cn.com/problems/string-to-integer-atoi/solution/zi-fu-chuan-zhuan-huan-zheng-shu-atoi-by-leetcode-/
     * */
    public int myAtoi(String str) {
        Automaton automaton = new Automaton();
        for (int i = 0; i < str.length(); ++i) {
            automaton.get(str.charAt(i));
        }
        return (int) (automaton.sign * automaton.ans);
    }
}

class Automaton {
    public int sign = 1;
    public long ans = 0;
    private String state = "start";
    private Map<String, String[]> table = new HashMap<String, String[]>() {{
        put("start", new String[]{"start", "signed", "in_number", "end"});
        put("signed", new String[]{"end", "end", "in_number", "end"});
        put("in_number", new String[]{"end", "end", "in_number", "end"});
        put("end", new String[]{"end", "end", "end", "end"});
    }};

    public void get(char c) {
        state = table.get(state)[get_col(c)];
        if ("in_number".equals(state)) {
            ans = ans * 10 + c - '0';
            ans = sign == 1 ? Math.min(ans, (long)Integer.MAX_VALUE) : Math.min(ans, -(long)Integer.MIN_VALUE);
        } else if ("signed".equals(state)) {
            sign = c == '+' ? 1 : -1;
        }
    }

    private int get_col(char c) {
        if (c == ' ') {
            return 0;
        }
        if (c == '+' || c == '-') {
            return 1;
        }
        if (Character.isDigit(c)) {
            return 2;
        }
        return 3;
    }
}