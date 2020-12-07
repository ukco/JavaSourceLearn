package cn.humblecodeukco.test.leetcode;

import cn.humblecodeukco.test.DataStructure.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author lyr
 * @Date 2020/12/7 10:49
 * @Version 1.0
 * @Description 19. 删除链表的倒数第N个节点
 */
public class RemoveNthFromEnd {
    /**
     * 计算链表长度
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        int length = getLength(head);
        ListNode cur = dummy;
        for (int i = 1; i < length - n + 1; ++i) { cur = cur.next; }
        cur.next = cur.next.next;
        return dummy.next;
    }
    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }

    /**
     * 栈
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<>();
        ListNode cur = dummy;
        while (null != cur) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; ++i) { stack.pop(); }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        return dummy.next;
    }

    /**
     * 一次遍历
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) { first = first.next; }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
