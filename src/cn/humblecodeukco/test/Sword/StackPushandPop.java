package cn.humblecodeukco.test.Sword;

import java.util.Stack;

/**
 * @Author lyr
 * @Date 2020/10/11 17:29
 * @Version 1.0
 * @Description JZ21, 31
 */
public class StackPushandPop {
    public static void main(String[] args) {
        System.out.println(new StackPushandPopSolution().IsPopOrder(new int[] {1,2,3,4,5}, new int[] {4,3,5,1,2}));
    }
}

class StackPushandPopSolution {
    public boolean IsPopOrder(int[] pushed, int[] poped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int num: pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == poped[i]) {
                stack.pop();
                ++i;
            }
        }
        return stack.isEmpty();
    }
}
