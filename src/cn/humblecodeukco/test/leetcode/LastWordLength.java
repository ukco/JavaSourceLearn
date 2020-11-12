package cn.humblecodeukco.test.leetcode;

/**
 * @Author lyr
 * @Date 2020/11/12 12:13
 * @Version 1.0
 * @Description 58
 */
public class LastWordLength {
    public static void main(String[] args) {
        System.out.println(new LastWordLengthSolution().lengthOfLastWord("  "));
    }
}

class LastWordLengthSolution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0 || s.trim().length() == 0) return 0;
        String[] arr = s.split(" ");
        return arr[arr.length - 1].length();
    }

    public int lengthOfLastWord2(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') end--;
        if (end < 0) return 0;
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') start--;
        return end - start;
    }
}
