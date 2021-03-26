package cn.humblecodeukco.test.leetcode;

import cn.humblecodeukco.test.DataStructure.ListNode;

/**
 * @Author lyr
 * @Date 2020/10/22 20:01
 * @Version 1.0
 * @Description 83. 删除排序链表中的重复元素
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev = new ListNode(0, head);
        ListNode dummy = prev;
        ListNode current = head;
        ListNode next;
        while (current != null && current.next != null) {
            next = current.next;
            if (current.val == next.val) {
                prev.next = next;
            } else {
                prev = current;
            }
            current = next;
        }
        return dummy.next;
    }
}

class DeleteDuplicatesSolution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}
