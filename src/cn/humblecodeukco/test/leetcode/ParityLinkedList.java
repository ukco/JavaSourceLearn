package cn.humblecodeukco.test.leetcode;

import cn.humblecodeukco.test.DataStructure.ListNode;

/**
 * @Author lyr
 * @Date 2020/11/14 18:58
 * @Version 1.0
 * @Description 328
 */
public class ParityLinkedList {
}

class ParityLinkedListSolution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode evenHead = head.next;
        ListNode odd = head, even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public ListNode oddEvenList2(ListNode head) {
        // 分别定义奇偶链表的 虚拟头结点 和 尾节点
        ListNode oddHead = new ListNode();
        ListNode oddTail = oddHead;
        ListNode evenHead = new ListNode();
        ListNode evenTail = evenHead;
        // 遍历原链表，根据 isOdd 标识位决定将当前结点插入到奇链表还是偶链表（尾插法）
        boolean isOdd = true;
        while (head != null) {
            if (isOdd) {
                oddTail.next = head;
                oddTail = oddTail.next;
            } else {
                evenTail.next = head;
                evenTail = evenTail.next;
            }
            head = head.next;
            isOdd = !isOdd;
        }
        // 将奇链表后面拼接上偶链表，并将偶链表的next设置为null
        oddTail.next = evenHead.next;
        evenTail.next = null;
        return oddHead.next;
    }
}
