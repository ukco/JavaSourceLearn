package cn.humblecodeukco.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lyr
 * @Date 2021/3/15 13:08
 * @Version 1.0
 * @Description 54. 螺旋矩阵
 */
public class SpiralOrder {
    public List<Integer> spiralOrder (int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null) { return res; }

        int row = matrix.length;
        int col = matrix[0].length;

        int loop = (Math.min(row, col) + 1) / 2;

        for (int i = 0; i < loop; i++) {
            int j = i;
            int k = i;

            for (; k < i + col - 1; k++) { res.add(matrix[j][k]); }

            if (col == 1 || row == 1) {
                for (; j <= i + row - 1; j++) {
                    res.add(matrix[j][k]);
                }
                return res;
            } else {
                for (; j < i + row - 1; j++) {
                    res.add(matrix[j][k]);
                }
            }

            for (; k > i; k--) { res.add(matrix[j][k]); }

            for (; j > i; j--) { res.add(matrix[j][k]); }

            row -= 2;
            col -= 2;
        }
        return res;
    }

    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> order = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length, colums = matrix[0].length;
        boolean[][] visited = new boolean[rows][colums];
        int total = rows * colums;
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            order.add(matrix[row][column]);
            visited[row][column] = true;
            int nextRow = row + directions[directionIndex][0];
            int nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 ||
                    nextColumn >= colums || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return order;
    }
}
