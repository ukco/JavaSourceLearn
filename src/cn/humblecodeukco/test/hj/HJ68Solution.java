package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author lyr
 * @Date 2021/1/11 15:52
 * @Version 1.0
 * @Description HJ68 成绩排序
 */
public class HJ68Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = read.readLine()) != null) {
            int n = Integer.parseInt(str.trim());
            int bool = Integer.parseInt(read.readLine().trim());
            String[] name = new String[n];
            int[] score = new int[n];
            for (int i = 0; i < n; ++i) {
                str = read.readLine().trim();
                String[] temp = str.split(" ");
                name[i] = temp[0];
                score[i] = Integer.parseInt(temp[1]);
            }
            if (bool == 0) {
                // 由高到低
                for (int i = 0; i < n; ++i) {
                    for (int j = 0; j < n - 1 - i; ++j) {
                        if (score[j + 1] > score[j]) {
                            String na = name[j];
                            name[j] = name[j + 1];
                            name[j + 1] = na;
                            int t = score[j];
                            score[j] = score[j + 1];
                            score[j + 1] = t;
                        }
                    }
                }
            } else {
                // 由低到高
                for (int i = 0; i < n; ++i) {
                    for (int j = 0; j < n - 1 - i; ++j) {
                        if (score[j + 1] < score[j]) {
                            String na = name[j];
                            name[j] = name[j + 1];
                            name[j + 1] = na;
                            int t = score[j];
                            score[j] = score[j + 1];
                            score[j + 1] = t;
                        }
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(name[i]).append(" ").append(score[i]).append("\n");
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb.toString());
        }
    }
}
