package cn.humblecodeukco.test.Sword;


import cn.humblecodeukco.test.DataStructure.ListNode;

/**
 * @Author lyr
 * @Date 2020/10/9 10:01
 * @Version 1.0
 * @Description JZ15, 24
 */
public class ReverseLinkedList {
    public static void main(String[] args) {

    }
}

class ReverseLinkedListSolution {
    public ListNode ReverseList(ListNode head) {
        ListNode pReversedHead = null;
        ListNode pNode = head;
        ListNode pPrev = null;
        while (pNode != null) {
            ListNode pNext = pNode.next;
            if (pNext == null) pReversedHead = pNode;

            pNode.next = pPrev;
            pPrev = pNode;
            pNode = pNext;
        }
        return pReversedHead;
    }
}