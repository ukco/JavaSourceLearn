package cn.humblecodeukco.test.leetcode;

/**
 * @Author lyr
 * @Date 2020/10/7 12:28
 * @Version 1.0
 * @Description 21
 */
public class MergeTwoOrderLinkedLists {
    public static void main(String[] args) {

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}

// 递归
// list1[0] + merge(list1[1:], list2) list1[0] < lsit2[0]
// list2[0] + merge(list1, list2[1:]) otherwise
// 也就是说，两个链表头部值较小的一个节点与剩下元素的 merge 操作结果合并
//class MergeTwoOrderLinkedListsSolution {
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if (l1 == null) return l2;
//        else if (l2 == null) return l1;
//        else if (l1.val < l2.val) {
//            l1.next = mergeTwoLists(l1.next, l2);
//            return l1;
//        } else {
//            l2.next = mergeTwoLists(l1, l2.next);
//            return l2;
//        }
//    }
//}

// 迭代
class MergeTwoOrderLinkedListsSolution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode preV = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                preV.next = l1;
                l1 = l1.next;
            } else {
                preV.next = l2;
                l2 = l2.next;
            }
            preV = preV.next;
        }
        preV.next = l1 == null ? l2 : l1;
        return prehead.next;
    }
}