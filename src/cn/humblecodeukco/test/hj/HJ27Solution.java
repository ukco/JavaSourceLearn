package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author lyr
 * @Date 2020/12/2 10:34
 * @Version 1.0
 * @Description HJ27
 */
public class HJ27Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while (null != (input = br.readLine())) {
            String[] arr = input.trim().split(" ");
            Integer length = Integer.parseInt(arr[0]);
            // 目标单词
            String target = arr[arr.length - 2];
            // 字典序第 k 大
            Integer k = Integer.parseInt(arr[arr.length - 1]);
            String[] dic = new String[length];
            for (int i = 1; i <= length; i++) { dic[i - 1] = arr[i]; }
            int count = 0;
            List<String> list = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                if (dic[i].length() != target.length() || dic[i].equals(target)) { continue; }
                char[] chars = dic[i].toCharArray();
                char[] targetArr = target.toCharArray();
                int tmp = 0;
                Arrays.sort(chars);
                Arrays.sort(targetArr);
                if (String.valueOf(chars).equals(String.valueOf(targetArr))) {
                    count++;
                    list.add(dic[i]);
                }
            }
            System.out.println(count);
            Collections.sort(list);
            if (list.size() >= k) { System.out.println(list.get(k - 1)); }
        }
    }
}
