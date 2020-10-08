package cn.humblecodeukco.test.leetcode;

import java.util.*;

/**
 * @Author lyr
 * @Date 2020/9/19 12:16
 * @Version 1.0
 * @Description 186
 */
public class ReverseWordsII {
    public static void main(String[] args) {
        ReverseSolution2 reverseSolution2 = new ReverseSolution2();
        System.out.println(reverseSolution2.reverseWords("the sky is blue"));
    }
}

// 单词切割成字符实现翻转
// 需要String数组 List列表 StringBuilder 还需要构造一个新的String返回对象
//class ReverseSolution2 {
//    public String reverseWords(String s) {
//        String[] words = s.split(" ");
//        //整体翻转
//        Collections.reverse(Arrays.asList(words));
//        //每个单词再单独翻转
//        List<String> newwords = new ArrayList<>();
//        for(String word: words) {
//            char[] simple = word.toCharArray();
//            StringBuilder stringBuilder = new StringBuilder();
//            for(int i=simple.length-1; i>=0; i--){
//                stringBuilder.append(simple[i]);
//            }
//            newwords.add(stringBuilder.toString());
//        }
//        return String.join(" ", newwords);
//    }
//}

// 利用栈实现
// 开辟一个栈空间 一个字符数组空间 一个StringBuilder空间
class ReverseSolution2 {
    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        char[] strchar = s.toCharArray();
        for(char single: strchar) {
            stack.push(String.valueOf(single));
        }
        StringBuilder stringBuilder = new StringBuilder();
        while(!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }
}
