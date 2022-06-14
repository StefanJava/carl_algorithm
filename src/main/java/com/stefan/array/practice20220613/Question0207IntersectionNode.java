package com.stefan.array.practice20220613;

public class Question0207IntersectionNode {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node7.next = node8;
        node8.next = node6;
        node6.next = node3;

        ListNode intersectionNode = getIntersectionNode(node1, node7);
        assert intersectionNode != null;
        System.out.println(intersectionNode);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode curA = headA;
        ListNode curB = headB;

        int lenA = 0, lenB = 0;

        while (curA != null) {
            lenA++;
            curA = curA.next;
        }

        while (curB != null) {
            lenB++;
            curB = curB.next;
        }

        int subLen = lenA - lenB;

        if (subLen > 0) {
            while (subLen > 0) {
                assert headA != null;
                headA = headA.next;
                subLen--;
            }
        } else {
            while (subLen < 0) {
                assert headB != null;
                headB = headB.next;
                subLen++;
            }
        }

        while (true) {
            if (headA == headB) {
                return headA;
            }
            if (headA == null || headB == null) {
                break;
            }
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}
