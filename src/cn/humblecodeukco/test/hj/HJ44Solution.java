package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author lyr
 * @Date 2020/12/20 12:59
 * @Version 1.0
 * @Description HJ44 Sudoku-Java
 */
public class HJ44Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = read.readLine()) != null) {
            char[][] arr = new char[9][];
            arr[0] = str.toCharArray();
            for (int i = 1; i < 9; ++i) { arr[i] = read.readLine().toCharArray(); }
            dealnum(arr);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; ++i) { sb.append(String.valueOf(arr[i]) + '\n'); }
            System.out.println(sb.toString());
        }
    }
    private static boolean dealnum(char[][] arr) {
        int x = 0, y = 0;
        s: for (; x < 9; ++x) {
            for (y = 0; y < 17; y += 2) {
                if (arr[x][y] == '0') { break s; }
            }
        }
        if (x < 9 && y < 17) {
            boolean[] stu = new boolean[10];
            for (int i = 0; i < 9; ++i) {
                stu[arr[x][i << 1] - '0'] = true;
                stu[arr[i][y] - '0'] = true;
            }
            int lx = (x / 3) * 3, ly = (y / 6) * 6;
            for (int i = lx; i < lx + 3; ++i) {
                for (int j = ly; j < ly + 5; j += 2) { stu[arr[i][j] - '0'] = true; }
            }
            for (int i = 1; i < 10; ++i) {
                if (stu[i]) { continue; }
                arr[x][y] = (char) (i + '0');
                if (dealnum(arr)) { return true; }
                arr[x][y] = '0';
            }
            return false;
        }
        return true;
    }
}
