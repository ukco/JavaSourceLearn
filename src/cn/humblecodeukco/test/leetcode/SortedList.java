package cn.humblecodeukco.test.leetcode;

import cn.humblecodeukco.test.DataStructure.ListNode;

/**
 * @Author lyr
 * @Date 2020/11/21 13:17
 * @Version 1.0
 * @Description 148
 */
public class SortedList {
}

class SortedListSolution {
    /**
     * 插入排序
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode lastSorted = head, curr = head.next;
        while (curr != null) {
            if (lastSorted.val <= curr.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode prev = dummyHead;
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;
        }
        return dummyHead.next;
    }

    /**
     * 自顶向下归并排序
     * @param head
     * @return
     */
    public ListNode sortList2(ListNode head) {
        return sortList(head, null);
    }
    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        ListNode sorted = merge(list1, list2);
        return sorted;
    }
    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }

    /**
     * 自底向上归并排序
     * @param head
     * @return
     */
    public ListNode sortedList3(ListNode head) {
        if (head == null) {
            return head;
        }
        int length = 0;
        ListNode node = head;
        // 统计链表长度
        while (node != null) {
            length++;
            node = node.next;
        }
        ListNode dummyHead = new ListNode(0, head);

        // 每次将链表拆分成若干个长度为subLength的子链表，并按照每两个子链表一组进行合并
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            ListNode prev = dummyHead, curr = dummyHead.next; // curr用于记录拆分链表的位置
            while (curr != null) { // 若链表没有被拆分完
                // 拆分subLength长度的链表1
                ListNode head1 = curr; // 第一个链表的头 即curr初始的位置
                for (int i = 1; i < subLength && curr.next != null; ++i) { // 拆分出长度为subLen的链表1
                    curr = curr.next;
                }
                // 拆分subLength长度的链表2
                ListNode head2 = curr.next; // 第二个链表的头，即链表1尾部的下一个位置
                curr.next = null; // 断开第一个链表和第二个链表的连接
                curr = head2; // 第二个链表头 重新赋值给curr
                for (int i = 1; i < subLength && curr != null && curr.next != null; ++i) { // 再拆分出长度为subLen的链表2
                    curr = curr.next;
                }
                // 再次断开 第二个链表最后的next的连接
                ListNode next = null;
                if (curr != null) {
                    next = curr.next; // next用于记录 拆分完两个链表的结束位置
                    curr.next = null; // 断开连接
                }
                // 合并两个subLen长度的有序链表
                ListNode merged = merge(head1, head2);
                prev.next = merged; // prev.next指向排好序链表的头
                while (prev.next != null) { // while循环 将prev移动到subLen*2的位置后去
                    prev = prev.next;
                }
                curr = next; // next用于记录 拆分完两个链表的结束位置
            }
        }
        // 返回排好序的链表
        return dummyHead.next;
    }

    /**
     * 快速排序
     * @param head
     * @return
     */
    public ListNode sortedList4(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0, head);
        return quickSort(dummyHead, null);
    }
    // 带头结点的链表的快速排序
    public ListNode quickSort(ListNode head, ListNode end) {
        if (head == end || head.next == end || head.next.next == end) {
            return head;
        }
        // 将小于划分点的值存储在临时链表中
        ListNode tmpHead = new ListNode(-1);
        // partition 为划分点，p为链表指针，tp为临时链表指针
        ListNode partition = head.next, p = partition, tp = tmpHead;
        // 将小于划分点的节点放到临时链表中
        while (p.next != end) {
            if (p.next.val < partition.val) {
                tp.next = p.next;
                tp = tp.next;
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        // 合并临时链表和原链表，将原链表接到临时链表后面即可
        tp.next = head.next;
        // 将临时链表插回原链表，注意是插回（不做这一步在对右半部分处理时就断链了）
        head.next = tmpHead.next;
        quickSort(head, partition);
        quickSort(partition, end);
        return head.next;
    }
}
