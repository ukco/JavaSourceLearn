package cn.humblecodeukco.test.niukecompetition;

import java.io.IOException;
import java.util.Scanner;

/**
 * @Author lyr
 * @Date 2020/12/17 11:13
 * @Version 1.0
 * @Description NC13142
 */
public class NC13142Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = Integer.parseInt(scanner.nextLine());
        String[] arrs = scanner.nextLine().split(" ");
        int[] arr = new int[len];
        for (int i = 0; i < len; ++i) { arr[i] = Integer.parseInt(arrs[i]); }
        System.out.println(solution(arr));
    }

    /**
     * 左数组：以每个节点为结束点，他的最大上升序列
     * 右数组：以每个节点为开始点，他的最大上升序列
     * @param arr
     * @return
     */
    private static int solution(int[] arr) {
        int len = arr.length;
        // 创建左右数组
        int[] left = new int[len];
        int[] right = new int[len];

        // 初始化左右数组
        left[0] = 1;
        for (int i = 1; i < len; ++i) {
            if (arr[i] > arr[i - 1]) { left[i] = left[i - 1] + 1; }
            else { left[i] = 1; }
        }

        right[len - 1] = 1;
        for (int i = len - 2; i >= 0; --i) {
            if (arr[i] < arr[i + 1]) { right[i] = right[i + 1] + 1; }
            else { right[i] = 1; }
        }

        int max = 1;

        for (int i = 1; i < len - 1; ++i) {
            int a = left[i - 1];
            int b = right[i + 1];
            if (arr[i + 1] > arr[i - 1] && a + b > max) { max = a + b; }
        }
        return max + 1;
    }
}
