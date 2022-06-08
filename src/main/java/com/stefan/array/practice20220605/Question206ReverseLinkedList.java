package com.stefan.array.practice20220605;

/**
 *206.反转链表
 *
 * 题意：反转一个单链表。
 *
 * 示例: 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL
 */
public class Question206ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3,
                new ListNode(4, new ListNode(5)))));
        head.print();
//        ListNode newListNode = reverseNode(head);
        ListNode newListNode = reverseList2(head);
        assert newListNode != null;
        newListNode.print();
    }

    private static ListNode reverseList(ListNode head) {
        return recursion(null, head);
    }

    private static ListNode recursion(ListNode prev, ListNode cur) {
        if (cur == null) return prev;
        ListNode tmp = cur.next;
        cur.next = prev;
        return recursion(cur, tmp);
    }

    private static ListNode reverseList2(ListNode head) {
        return recursion2(head);
    }

    private static ListNode recursion2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode last = recursion2(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    private static ListNode reverseNode(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur;
            cur = cur.next;
            tmp.next = prev;
            prev = tmp;
        }
        return prev;
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
