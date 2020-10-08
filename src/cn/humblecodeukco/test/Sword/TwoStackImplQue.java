package cn.humblecodeukco.test.Sword;

import java.util.Stack;

/**
 * @Author lyr
 * @Date 2020/9/23 21:31
 * @Version 1.0
 * @Description JZ5, 9
 */
public class TwoStackImplQue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() throws Exception {
        if(stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if(stack2.isEmpty()) throw new Exception("queue is empty");
        return stack2.pop();
    }

    public static void main(String[] args) {

    }
}

