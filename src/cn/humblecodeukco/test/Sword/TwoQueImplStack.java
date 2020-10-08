package cn.humblecodeukco.test.Sword;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author lyr
 * @Date 2020/9/24 18:54
 * @Version 1.0
 * @Description 两个队列实现栈，栈和队列的扩展题目
 */
public class TwoQueImplStack<T> {
    private Queue<T> queue1 = new LinkedList<>();
    private Queue<T> queue2 = new LinkedList<>();

    public boolean push(T t) {
        if (!queue1.isEmpty()) {
            return queue1.offer(t);
        } else {
            return queue2.offer(t);
        }
    }

    public T pop() {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        if (!queue1.isEmpty() && queue2.isEmpty()) {
            while (queue1.size() > 1) {
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        }
        if (queue1.isEmpty() && !queue2.isEmpty()) {
            while (queue2.size() > 1) {
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        }
        return null;
    }

    @Override
    public String toString() {
        return this.queue1.toString() + ", " + this.queue2.toString();
    }

    public static void main(String[] args) {
        TwoQueImplStack<Integer> s = new TwoQueImplStack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.pop();
        System.out.println(s);
        s.push(4);
        s.push(5);
        s.pop();
        System.out.println(s);
    }
}
