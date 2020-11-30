package cn.humblecodeukco.test.leetcode;

import java.util.PriorityQueue;

/**
 * @Author lyr
 * @Date 2020/11/30 9:42
 * @Version 1.0
 * @Description 767. 重构字符串
 */
public class ReorganizeString {
    /**
     * 基于最大堆的贪心算法
     * @param S
     * @return
     */
    public String reorganizeString(String S) {
        if (S.length() < 2) { return S; }
        int[] counts = new int[26];
        int maxCount = 0;
        int length = S.length();
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            counts[c - 'a']++;
            maxCount = Math.max(maxCount, counts[c - 'a']);
        }
        if (maxCount > (length + 1) / 2) { return ""; }
        PriorityQueue<Character> queue = new PriorityQueue<>((o1, o2) -> counts[o2 - 'a'] - counts[o1 - 'a']);
        for (char c = 'a'; c <= 'z'; c++) {
            if (counts[c - 'a'] > 0) { queue.offer(c); }
        }
        StringBuilder sb = new StringBuilder();
        while (queue.size() > 1) {
            char letter1 = queue.poll();
            char letter2 = queue.poll();
            sb.append(letter1);
            sb.append(letter2);
            int index1 = letter1 - 'a', index2 = letter2 - 'a';
            counts[index1]--;
            counts[index2]--;
            if (counts[index1] > 0) { queue.offer(letter1); }
            if (counts[index2] > 0) { queue.offer(letter2); }
        }
        if (queue.size() > 0) { sb.append(queue.poll()); }
        return sb.toString();
    }

    /**
     * 基于计数的贪心算法
     * @param S
     * @return
     */
    public String reorganizeString2(String S) {
        if (S.length() < 2) { return S; }
        int[] counts = new int[26];
        int maxCount = 0;
        int length = S.length();
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            counts[c - 'a']++;
            maxCount = Math.max(maxCount, counts[c - 'a']);
        }
        if (maxCount > (length + 1) / 2) { return ""; }
        char[] reorganizeArray = new char[length];
        int evenIndex = 0, oddIndex = 1;
        int halfLength = length / 2;
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            while (counts[i] > 0 && counts[i] <= halfLength && oddIndex < length) {
                reorganizeArray[oddIndex] = c;
                counts[i]--;
                oddIndex += 2;
            }
            while (counts[i] > 0) {
                reorganizeArray[evenIndex] = c;
                counts[i]--;
                evenIndex += 2;
            }
        }
        return new String(reorganizeArray);
    }

    public String reorganizeString3(String S) {
        char[] alphabeArr = S.toCharArray();
        int[] alphabetCount = new int[26];
        int length = S.length();
        for (int i = 0; i < length; i++) {
            alphabetCount[alphabeArr[i] - 'a']++;
        }
        int max = 0, alphabet = 0, threshold = (length + 1) >> 1;
        // 找出出现次数最多的那个字符
        for (int i = 0; i < alphabetCount.length; i++) {
            if (alphabetCount[i] > max) {
                max = alphabetCount[i];
                alphabet = i;
                // 如果出现次数最多的那个字符的数量大于阈值，说明他不能使得
                // 两相邻的字符不同，直接返回空字符串即可
                if (max > threshold) { return ""; }
            }
        }
        // 到这一步说明他可以使得两相邻的字符不同，我们随便返回一个结果，res就是返回
        // 结果的数组形式，最后会再转化为字符串的
        char[] res = new char[length];
        int index = 0;
        // 先把出现次数最多的字符存储在数组下标为偶数的位置上
        while (alphabetCount[alphabet]-- > 0) {
            res[index] = (char) (alphabet + 'a');
            index += 2;
        }
        // 然后再把剩下的字符存储在其他位置上
        for (int i = 0; i < alphabetCount.length; i++) {
            while (alphabetCount[i]-- > 0) {
                if (index >= res.length) { index = 1; }
                res[index] = (char) (i + 'a');
                index += 2;
            }
        }
        return new String(res);
    }
}
