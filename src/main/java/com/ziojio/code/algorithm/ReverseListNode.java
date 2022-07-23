package com.ziojio.code.algorithm;

import java.util.HashMap;

public class ReverseListNode {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        HashMap<Node, Integer> oldMap = new HashMap<>();
        HashMap<Integer, Node> newMap = new HashMap<>();
        Node m = head;
        Node ptr = null;
        Node node = null;
        for (int i = 0; m != null; i++) {
            oldMap.put(m, i);
            if(i == 0){
                ptr = new Node(m.val);
                node = ptr;
            } else {
                node.next = new Node(m.val);
            }
            newMap.put(i, node);
            m = m.next;
            node = node.next;
        }
        Node n = head;
        Node r = ptr;
        while (n != null) {
            if(n.random != null){
                 r.random = newMap.get(oldMap.get(n.random));
            }
            n = n.next;
        }
        return ptr;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode head = node;
        for (int i = 2; i < 8; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }
        printListNode(head);
        printListNode(reverseList(head));
    }

    static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " => ");
            head = head.next;
        }
        System.out.println("NULL");
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;
        while (next != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = curr.next;
        }
        curr.next = prev;
        return curr;
    }

}
