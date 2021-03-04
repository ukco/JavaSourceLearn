package cn.humblecodeukco.test.leetcode;

import cn.humblecodeukco.test.DataStructure.ListNode;

/**
 * @Author lyr
 * @Date 2021/3/4 9:21
 * @Version 1.0
 * @Description 24. 两两交换链表中的节点
 */
public class SwapPairs {
    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) { return head; }

        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }

    /**
     * 非递归
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;
        while (temp.next != null && temp.next.next != null) {
            ListNode start = temp.next;
            ListNode end = temp.next.next;
            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }
        return pre.next;
    }
}
