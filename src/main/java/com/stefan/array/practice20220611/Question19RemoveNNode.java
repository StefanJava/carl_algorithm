package com.stefan.array.practice20220611;

import java.util.Scanner;

public class Question19RemoveNNode {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,
                new ListNode(5, new ListNode(6))))));

        System.out.println("请输入删除倒数第几个结点: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        ListNode newHead = removeNthFromEnd(head, n);
        newHead.print();
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {

        int count = 0;
        ListNode dummyNode = new ListNode(0, head);

        ListNode slow = dummyNode;
        ListNode fast = head;

        while (fast != null) {
            fast = fast.next;
            count++;
            // 先让fast移动n次
            if (count > n) {
                slow = slow.next;
            }
        }

        slow.next = slow.next.next;

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
