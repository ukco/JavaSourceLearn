package cn.humblecodeukco.test.leetcode;

import java.util.*;

/**
 * @Author lyr
 * @Date 2020/9/18 21:21
 * @Version 1.0
 * @Description 151
 */
public class ReverseWords {
    public static void main(String[] args) {
        ReverseSolution reverseSolution = new ReverseSolution();
        System.out.println(reverseSolution.reverseWords("the  sky is blue"));
    }
}

// 使用语言特性
// 时间复杂度：O(N)
// 空间复杂度：O(N)
//class ReverseSolution {
//    public String reverseWords(String s) {
//        String[] words = s.trim().split(" +");
//        // Arrays.asList()返回的是一个Lis。
//        // Arrays.ArrayList 是工具类 Arrays 的一个内部静态类，它没有完全实现List的方法，而 ArrayList直接实现了List 接口，实现了List所有方法。
//        // java.util.Collections.reverse(list)--这是一个列表，其元素将被扭转。
//        Collections.reverse(Arrays.asList(words));
//        return String.join(" ", words);
//    }
//}

// 栈（双端队列）
// 时间复杂度：O(N)
// 空间复杂度：O(N)
//class ReverseSolution {
//    public String reverseWords(String s) {
//        int left = 0, right = s.length() - 1;
//        // remove leading spaces
//        while (left <= right && s.charAt(left) == ' ') ++left;
//        // remove trailing spaces
//        while (left <= right && s.charAt(right) == ' ') ++right;
//
//        Deque<String> d = new ArrayDeque<>();
//        StringBuilder word = new StringBuilder();
//        // push word by word in front of deque
//        while(left <= right) {
//            char c = s.charAt(left);
//
//            if((word.length() != 0) && (c == ' ')) {
//                d.offerFirst(word.toString());
//                word.setLength(0);
//            } else if (c != ' ') {
//                word.append(c);
//            }
//            ++left;
//        }
//        d.offerFirst(word.toString());
//
//        return String.join(" ", d);
//    }
//}

// 翻转整个字符串，再翻转每个单词
// 时间复杂度：O(N)
// 空间复杂度：O(N)
class ReverseSolution {
    public String reverseWords(String s) {
        StringBuilder sb = trimSpaces(s);

        // 翻转字符串
        reverse(sb, 0, sb.length() - 1);

        // 翻转每一个单词
        reverseEachWord(sb);

        return sb.toString();
    }

    public StringBuilder trimSpaces(String s) {
        int left = 0, right = s.length() - 1;
        // 去掉字符串开头的空白字符
        while (left <= right && s.charAt(left) == ' ') ++left;
        // 去掉字符串末尾的空白字符
        while (left <= right && s.charAt(right) == ' ') --right;

        // 将字符串间多余的空白字符去除
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);
            if (c != ' ') {
                sb.append(c);
            } else if (sb.charAt(sb.length() - 1) != ' ' ) {
                sb.append(c);
            }
            ++left;
        }
        return sb;
    }

    public void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char tmp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, tmp);
        }
    }
    public void reverseEachWord(StringBuilder sb) {
        int n = sb.length();
        int start = 0, end = 0;

        while (start < n) {
            // 循环至单词的末尾
            while (end < n && sb.charAt(end) != ' ') ++end;
            // 翻转单词
            reverse(sb, start, end - 1);
            // 更新start，去找下一个单词
            start = end + 1;
            ++end;
        }
    }
}