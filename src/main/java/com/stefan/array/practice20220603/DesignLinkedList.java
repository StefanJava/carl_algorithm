package com.stefan.array.practice20220603;

public class DesignLinkedList {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);
        linkedList.get(1);
        linkedList.deleteAtIndex(0);
        linkedList.get(0);
    }
}

class MyLinkedList {

    private int size;

    private final LinkedNode head;
    private LinkedNode tail;
    private static class LinkedNode {
        public int val;
        public LinkedNode next;

        public LinkedNode() {
        }

        public LinkedNode(int val) {
            this.val = val;
        }
    }

    public MyLinkedList() {
        head = new LinkedNode();
        tail = head;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        LinkedNode indexNode = getNodeByIndex(index);

        if (indexNode != null) {
            return indexNode.val;
        } else {
            return -1;
        }
    }

    private LinkedNode getNodeByIndex(int index) {
        int count = 0;
        for (LinkedNode curNode = head.next; curNode != null; curNode = curNode.next) {
            if (count == index) {
                return curNode;
            }
            count++;
        }
        return null;
    }

    public void addAtHead(int val) {
        LinkedNode newNode = new LinkedNode(val);
        newNode.next = head.next;
        head.next = newNode;
        if (size == 0) {
            tail = newNode;
        }
        size++;
    }

    public void addAtTail(int val) {
        LinkedNode newNode = new LinkedNode(val);
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index <= 0) {
            addAtHead(val);
        }
        if (index > 0 && index <= size) {
            LinkedNode nodeByIndex = getNodeByIndex(index - 1);
            LinkedNode newNode = new LinkedNode(val);
            if (nodeByIndex != null) {
                newNode.next = nodeByIndex.next;
                nodeByIndex.next = newNode;
                if (index == size) {
                    tail = newNode;
                }
                size++;
            }
        }
    }

    public void deleteAtIndex(int index) {
        if (index >= 0 && index < size) {
            LinkedNode nodeByIndex = getNodeByIndex(index - 1);
            if (nodeByIndex != null) {
                nodeByIndex.next = nodeByIndex.next.next;
                if (index == size - 1) {
                    tail = nodeByIndex;
                }
                size--;
            } else {
                head.next = head.next.next;
                if (index == size - 1) {
                    tail = head;
                }
            }
        }
    }
}
