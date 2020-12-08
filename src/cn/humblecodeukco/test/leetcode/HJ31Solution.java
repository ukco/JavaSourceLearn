package cn.humblecodeukco.test.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @Author lyr
 * @Date 2020/12/8 9:59
 * @Version 1.0
 * @Description HJ31
 */
public class HJ31Solution {
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        int available = in.available();
        char[] arr = new char[available];
        int off_word = 0;
        int off_end = arr.length;
        char c;
        for (int i = 0; i < available; ++i) {
            c = (char) in.read();
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) { arr[off_word++] = c; }
            else if (off_word > 0) {
                System.arraycopy(arr, 0, arr, off_end - off_word, off_word);
                off_end -= off_word + 1;
                off_word = 0;
                arr[off_end] = ' ';
            }
        }
        System.out.println(String.valueOf(arr, off_end + 1, arr.length - off_end - 1));
    }

    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null && line.length() > 0) {
            char[] array = line.trim().toCharArray();
            StringBuilder sb = new StringBuilder();
            boolean flag = false;
            int mark = -1;
            for (int i = array.length - 1; i >= 0; --i) {
                if ((array[i] >= 'A' && array[i] <= 'Z') || (array[i] >= 'a' && array[i] <= 'z')) {
                    if (mark == -1) { mark = i; }
                    flag = true;
                } else if (flag) {
                    sb.append(array, i + 1, mark - i).append(' ');
                    mark = -1;
                    flag = false;
                }
            }
            if (flag) {
                sb.append(array, 0, mark + 1);
                System.out.println(sb.toString());
            } else { System.out.println(sb.substring(0, sb.length() - 1)); }
        }
    }
}
