package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author lyr
 * @Date 2021/1/12 11:13
 * @Version 1.0
 * @Description HJ69. 矩阵乘法
 */
public class HJ69Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = reader.readLine()) != null) {
            if ("".equals(str)) { continue; }
            int x = Integer.parseInt(str);
            int y = Integer.parseInt(reader.readLine());
            int z = Integer.parseInt(reader.readLine());
            int[][] matrix1 = new int[x][y];
            int[][] matrix2 = new int[y][z];
            for (int i = 0; i < x; i++) {
                String[] params = reader.readLine().split(" ");
                for (int j = 0; j < y; j++) {
                    matrix1[i][j] = Integer.parseInt(params[j]);
                }
            }
            for (int i = 0; i < y; i++) {
                String[] params = reader.readLine().split(" ");
                for (int j = 0; j < z; j++) {
                    matrix2[i][j] = Integer.parseInt(params[j]);
                }
            }
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < z; j++) {
                    int temp = 0;
                    for (int k = 0; k < y; k++) {
                        temp += matrix1[i][k] * matrix2[k][j];
                    }
                    ans.append(temp).append(" ");
                }
                ans.deleteCharAt(ans.length() - 1).append("\n");
            }
            System.out.println(ans.toString());
        }
    }
}
