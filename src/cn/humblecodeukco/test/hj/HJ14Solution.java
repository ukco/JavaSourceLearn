package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @Author lyr
 * @Date 2020/11/24 11:10
 * @Version 1.0
 * @Description HJ14
 */
public class HJ14Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bf.readLine());
        String[] result = new String[count];
        for (int i = 0; i < count; i++) { result[i] = bf.readLine(); }
        Arrays.sort(result);
        for (String w: result) { System.out.println(w); }
    }
}
