package cn.humblecodeukco.test.leetcode;

import cn.humblecodeukco.test.DataStructure.ListNode;

import java.util.Stack;

/**
 * @Author lyr
 * @Date 2021/3/18 12:59
 * @Version 1.0
 * @Description 92. 反转链表II
 */
public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) { return null; }
        Stack<ListNode> stack = new Stack<>();
        ListNode prev = new ListNode(0, head);
        ListNode ans = prev;
        ListNode current = head;
        int count = 1;
        while (current != null && count < left) {
            prev = prev.next;
            current = current.next;
            count++;
        }
        while (current != null && count <= right) {
            stack.push(current);
            current = current.next;
            count++;
        }
        ListNode post = current;
        while (!stack.isEmpty()) {
            prev.next = stack.pop();
            prev = prev.next;
        }
        prev.next = post;
        return ans.next;
    }

}
