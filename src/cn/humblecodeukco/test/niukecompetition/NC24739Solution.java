package cn.humblecodeukco.test.niukecompetition;

import org.apache.logging.log4j.core.tools.picocli.CommandLine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @Author lyr
 * @Date 2020/12/10 21:59
 * @Version 1.0
 * @Description
 */
public class NC24739Solution {

    static class Reader {
        static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer tokenizer = new StringTokenizer("");

        static String nextLine() throws IOException {
            return reader.readLine();
        }

        static String next() throws IOException {
            while (!tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        static int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        static double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        static void close() throws IOException {
            reader.close();
        }
    }

    public static void main(String[] args) throws IOException {
        int n = Reader.nextInt();
        int m = Reader.nextInt();
        char[][] map = new char[n][m];
        for (int i = 0; i < n; ++i) {
            String str = Reader.nextLine();
            for (int j = 0; j < str.length(); ++j) {
                map[i][j] = str.charAt(j);
            }
        }
        SolutionNC24739 solutionNC24739 = new SolutionNC24739(n, m, map);
        solutionNC24739.dfs();
    }

    /**
     * 方法2
     */
    public static void test2() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] a = new char[n][m];

        // 输入
        for (int i = 0; i < n; ++i) {
            String str = sc.next();
            for (int j = 0; j < m; ++j) {
                a[i][j] = str.charAt(j);
            }
        }

        // 计算
        int count = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (a[i][j] == 'W') {
                    count++;
                    func(a, i, j);
                }
            }
        }
        System.out.println(count);
    }
    public static void func(char[][] a, int ii, int jj) {
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                int x = i + ii;
                int y = j + jj;
                if (x >= 0 && x < a.length && y >= 0 && y < a[0].length && a[x][y] == 'W') {
                    a[x][y] = '.';
                    func(a, x, y);
                }
            }
        }
    }
}

class SolutionNC24739 {
    private int n, m, ans;
    private char[][] map;
    private int[][] load = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public SolutionNC24739(int n, int m, char[][] map) {
        this.n = n;
        this.m = m;
        this.map = map;
        this.ans = 0;
    }

    public void dfs() {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (map[i][j] == 'W') {
                    dfs(i, j);
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }

    private void dfs(int x, int y) {
        map[x][y] = '.';
        for (int i = 0; i < 8; ++i) {
            int nx = x + load[i][0];
            int ny = y + load[i][1];
            if (0 <= nx && nx < n && 0 <= ny && ny < m && map[nx][ny] == 'W') {
                dfs(nx, ny);
            }
        }
    }
}
