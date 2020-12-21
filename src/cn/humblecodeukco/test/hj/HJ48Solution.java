package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author lyr
 * @Date 2020/12/21 11:06
 * @Version 1.0
 * @Description HJ48 从单向链表中删除指定值的节点
 */
public class HJ48Solution {
    private static class Node {
        Node next;
        int val;
        Node(int val) {
            this.val = val;
            next = null;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = reader.readLine()) != null) {
            if (str.equals("")) { continue; }
            String[] params = str.split(" ");
            int n = Integer.parseInt(params[0]);
            Node head = new Node(Integer.parseInt(params[1]));
            for (int i = 1; i < n; ++i) {
                int pre = Integer.parseInt(params[2 * i + 1]), nxt = Integer.parseInt(params[2 * i]);
                Node temp = head;
                while (temp.val != pre) { temp = temp.next; }
                Node node = new Node(nxt);
                node.next = temp.next;
                temp.next = node;
            }
            int del = Integer.parseInt(params[2 * n]);
            StringBuilder ans = new StringBuilder();
            Node temp = head;
            while (temp != null) {
                if (temp.val != del) { ans.append(temp.val).append(" "); }
                temp = temp.next;
            }
            System.out.println(ans.toString());
        }
    }
}
