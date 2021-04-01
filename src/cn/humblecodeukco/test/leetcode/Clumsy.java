package cn.humblecodeukco.test.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author lyr
 * @Date 2021/4/1 19:52
 * @Version 1.0
 * @Description 1006. 笨阶乘
 */
public class Clumsy {
    /**
     * 使用栈模拟
     * @param N
     * @return
     */
    public int Clumsy(int N) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(N);
        N--;

        int index = 0;
        while (N > 0) {
            if (index % 4 == 0) { stack.push(stack.pop() * N); }
            else if (index % 4 == 1) { stack.push(stack.pop() / N); }
            else if (index % 4 == 2) { stack.push(N); }
            else { stack.push(-N); }
            ++index;
            --N;
        }

        // 把栈中所有数字依次弹出求和
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
