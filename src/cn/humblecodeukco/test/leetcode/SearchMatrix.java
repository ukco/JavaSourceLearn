package cn.humblecodeukco.test.leetcode;

import java.util.Arrays;

/**
 * @Author lyr
 * @Date 2021/3/30 12:17
 * @Version 1.0
 * @Description 74. 搜索二维矩阵
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int width = matrix[0].length;
        int high = matrix.length;

        int[] tmp = new int[high];
        Arrays.setAll(tmp, i -> matrix[i][0]);
        int index = binarySearch(tmp, target);
        if (index < 0) { return false; }

        int left = 0, right = width - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (matrix[index][mid] == target) { return true; }
            else if (matrix[index][mid] < target) { left = mid + 1; }
            else { right = mid - 1; }
        }
        return false;
    }
    private int binarySearch(int[] array, int target) {
        int low = 0, high = array.length - 1;
        int mid;
        int index = -1;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (array[mid] == target) {
                index = mid;
                high = mid - 1;
            } else if (array[mid] < target) {
                if (((mid < array.length - 1) && array[mid + 1] > target)
                        || (mid == array.length - 1)) {
                    return mid;
                }
                low = mid + 1;
            }
            else { high = mid - 1; }
        }
        return index;
    }
}
