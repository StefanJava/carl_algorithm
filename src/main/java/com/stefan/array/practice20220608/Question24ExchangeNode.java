package com.stefan.array.practice20220608;

public class Question24ExchangeNode {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,
                new ListNode(5, new ListNode(6))))));
        head.print();
        ListNode newHead = exchangeNode(head);
        newHead.print();
    }

    private static ListNode exchangeNode(ListNode head) {

        ListNode dummyNode = new ListNode(0, head);

        ListNode prev = dummyNode;
        ListNode cur = head;

        while (cur != null && cur.next != null) {
            prev.next = cur.next;
            cur.next = cur.next.next;
            prev.next.next = cur;
            prev = prev.next.next;
            cur = cur.next;
        }

        return dummyNode.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {

    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void print() {
        ListNode curNode = this;
        while (curNode != null) {
            System.out.print(curNode.val + " ");
            curNode = curNode.next;
        }
        System.out.println();
    }
}
