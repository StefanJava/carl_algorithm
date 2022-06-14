package com.stefan.array.practice20220614;

/**
 * 142. 环形链表 II
 * 给定一个链表的头节点 head，返回链表开始入环的第一个节点。如果链表无环，则返回null。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 不允许修改 链表。
 */
public class Question142CycleLink {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(4);
        node5.next = node6;
        node6.next = node5;

        ListNode cycleNode = detectCycle(node5);
        System.out.println(cycleNode);
    }

    public static ListNode detectCycle(ListNode head) {

        ListNode intersectionNode = findIntersectionNode(head);

        if (intersectionNode == null) {
            return null;
        } else {
            while (true) {
                if (intersectionNode == head) {
                    return head;
                }
                intersectionNode = intersectionNode.next;
                head = head.next;
            }
        }
    }

    private static ListNode findIntersectionNode(ListNode head) {

        ListNode fastNode = head;
        ListNode slowNode = head;

        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
            if (fastNode == slowNode) {
                return fastNode;
            }
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