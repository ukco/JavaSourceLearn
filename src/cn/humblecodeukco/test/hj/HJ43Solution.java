package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author lyr
 * @Date 2020/12/18 10:57
 * @Version 1.0
 * @Description HJ43 迷宫问题
 */
public class HJ43Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = reader.readLine()) != null) {
            String[] dim = str.split(" ");
            int N = Integer.parseInt(dim[0]), M = Integer.parseInt(dim[1]);
            int[][] maze = new int[N][M];
            for (int i = 0; i < N; ++i) {
                str = reader.readLine();
                String[] arr = str.split(" ");
                for (int j = 0; j < M; ++j) {
                    maze[i][j] = Integer.parseInt(arr[j]);
                }
            }
            String[] res = {""};
            process(maze, 0, 0, "(0,0)\n", res);
            if (res[0].length() == 0) { System.out.println("(0,0)"); }
            else { System.out.println(res[0].substring(0, res[0].length() - 1)); }
        }
    }
    private static void process(int[][] arr, int x, int y, String path, String[] res) {
        if ((x == arr.length - 1) && (y == arr[x].length - 1)) {
            if (arr[x][y] == 0) { res[0] = path; }
            return;
        }
        if (x > arr.length - 1 || y > arr[x].length - 1) { return; }
        if (x + 1 < arr.length && arr[x + 1][y] == 0) {
            process(arr, x + 1, y, path + "(" + (x + 1) + "," + y + ")\n", res);
        }
        if (y + 1 < arr[x].length && arr[x][y + 1] == 0) {
            process(arr, x, y + 1, path + "(" + x + "," + (y + 1) + ")\n", res);
        }
    }
}
