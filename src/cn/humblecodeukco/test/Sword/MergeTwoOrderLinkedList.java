package cn.humblecodeukco.test.Sword;

import cn.humblecodeukco.test.DataStructure.ListNode;

/**
 * @Author lyr
 * @Date 2020/10/10 10:23
 * @Version 1.0
 * @Description JZ16, 25
 */
public class MergeTwoOrderLinkedList {
    public static void main(String[] args) {

    }
}

class MergeTwoOrderLinkedListSolution {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode pHead = null;
        if (list1.val < list2.val) {
            pHead = list1;
            pHead.next = Merge(list1.next, list2);
        } else {
            pHead = list2;
            pHead.next = Merge(list1, list2.next);
        }
        return pHead;
    }
}