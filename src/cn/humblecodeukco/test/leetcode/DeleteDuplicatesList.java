package cn.humblecodeukco.test.leetcode;

import cn.humblecodeukco.test.DataStructure.ListNode;

/**
 * @Author lyr
 * @Date 2021/3/25 14:18
 * @Version 1.0
 * @Description 82. 删除排序链表中的重复元素II
 */
public class DeleteDuplicatesList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) { return head; }
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;

        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else { cur = cur.next; }
        }
        return dummy.next;
    }
}
