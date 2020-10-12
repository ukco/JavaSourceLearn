package cn.humblecodeukco.test.Sword;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lyr
 * @Date 2020/10/12 18:18
 * @Version 1.0
 * @Description JZ53, 20
 */
public class isNumeric {
    public static void main(String[] args) {

    }
}

//class isNumericSolution {
//    public boolean isNumeric(String s) {
//        if (s == null || s.length() == 0) return false;
//        s = s.trim();
//        boolean numFlag = false;
//        boolean dotFlag = false;
//        boolean eFlag = false;
//        for (int i = 0; i < s.length(); ++i) {
//            // 判定为数字，则标记numFlag
//            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
//                numFlag = true;
//                // 判定为 . 需要没出现过 . ，并且没出现过 e
//            } else if (s.charAt(i) == '.' && !dotFlag && !eFlag) {
//                dotFlag = true;
//                // 判定为 e ，需要没出现过e，并且出现过数字了
//            } else if ((s.charAt(i) == 'e' || s.charAt(i) == 'E') && !eFlag && numFlag) {
//                eFlag = true;
//                numFlag = false; // 为了避免123e这种情况，出现e之后就标志位false
//                // 判定为+-符号，只能出现在第一位或者紧跟e后面
//            } else if ((s.charAt(i) == '+' || s.charAt(i) == '-') && (i == 0 || s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E')) {
//                // 其他情况，都是非法的
//            } else {
//                return false;
//            }
//        }
//        return numFlag;
//    }
//}

// 有限状态自动机
class isNumericSolution {
    public boolean isNumeric(String s) {
        Map[]  states = {
                new HashMap() {{ put(' ', 0); put('s', 1); put('d', 2); put('.', 4); }}, //0
                new HashMap() {{ put('d', 2); put('.', 4); }}, //1
                new HashMap() {{ put('d', 2); put('.', 3); put('e', 5); put(' ', 8); }}, //2
                new HashMap() {{ put('d', 3); put('e', 5); put(' ', 8); }}, //3
                new HashMap() {{ put('d', 3); }}, //4
                new HashMap() {{ put('s', 6); put('d', 7); }}, //5
                new HashMap() {{ put('d', 7); }}, //6
                new HashMap() {{ put('d', 7); put(' ', 8); }}, //7
                new HashMap() {{ put(' ', 8); }} //8
        };
        int p = 0;
        char t;
        for (char c: s.toCharArray()) {
            if (c >= '0' && c <= '9') t = 'd';
            else if (c == '+' || c == '-') t = 's';
            else if (c == 'e' || c == 'E') t = 'e';
            else if (c == '.' || c == ' ') t = c;
            else t = '?';
            if (!states[p].containsKey(t)) return false;
            p = (int)states[p].get(t);
        }
        return p == 2 || p == 3 || p == 7 || p ==8;
    }
}