package cn.humblecodeukco.test.leetcode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author lyr
 * @Date 2020/11/8 16:50
 * @Version 1.0
 * @Description 232
 */
public class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    int front;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        if (s1.isEmpty()) front = x;
        while (!s1.isEmpty()) s2.push(s1.pop());
        s2.push(x);
        while (!s2.isEmpty()) s1.push(s2.pop());
    }

    public int pop() {
        int x = s1.pop();
        if (!s1.isEmpty()) front = s1.peek();
        else front = -1;
        return x;
    }

    public int peeK() {
        return front;
    }

    public boolean empty() {
        return s1.isEmpty();
    }
}


/*public class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    int front;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        if (s1.isEmpty()) front = x;
        s1.push(x);
    }

    public int pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) s2.push(s1.pop());
        }
        return s2.pop();
    }

    public int peeK() {
        if (!s2.isEmpty()) return s2.peek();
        return front;
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}*/

class Main{
    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(3);
        int param2 =obj.pop();
        System.out.println(param2);
        int param3 = obj.peeK();
        System.out.println(param3);
        boolean param4 = obj.empty();
        System.out.println(param4);
    }
}