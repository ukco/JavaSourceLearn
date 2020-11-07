package cn.humblecodeukco.test.leetcode;

import cn.humblecodeukco.test.DataStructure.ListNode;

/**
 * @Author lyr
 * @Date 2020/11/7 19:45
 * @Version 1.0
 * @Description 203
 */
public class RemoveListElement {
}

class RemoveListElementSolution {
    /**
     * 设置哨兵节点
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode prev = sentinel, curr = head;
        while (curr != null) {
            if (curr.val == val) prev.next = curr.next;
            else prev = curr;
            curr = curr.next;
        }
        return sentinel.next;
    }

    /**
     * 不设置哨兵节点
     * @param head
     * @param val
     * @return
     */
    /*public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) head = head.next;
        ListNode prev = head;
        if (prev != null) {
            while (prev.next != null) {
                if (prev.next.val == val) prev.next = prev.next.next;
                else prev = prev.next;
            }
        }
        return head;
    }*/

    /**
     * 递归
     * @param head
     * @param val
     * @return
     */
    /*public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }*/
}
