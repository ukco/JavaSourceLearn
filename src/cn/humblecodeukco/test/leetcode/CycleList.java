package cn.humblecodeukco.test.leetcode;

import cn.humblecodeukco.test.DataStructure.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author lyr
 * @Date 2020/11/13 12:22
 * @Version 1.0
 * @Description 141
 */
public class CycleList {
}

class CycleListSolution {
    /**
     * 哈希表
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        while (head != null) {
            if (!seen.add(head)) return true;
            head = head.next;
        }
        return false;
    }

    /**
     * 快慢指针
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
