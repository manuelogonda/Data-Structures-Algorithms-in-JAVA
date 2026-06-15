package dev.manu.dsa.LinkedList;

public class MyLinkedListStructure {
    static void main(String[] args) {
        LinkedList20 list = new LinkedList20();
        list.append(10);
        list.append(20);
        list.append(30);
        list.printList();

        list.prepend(5);
        list.printList();

        list.delete(20);
        list.printList();

        list.delete(5);
        list.printList();
    }
    public static  class Node {
        int value;
        Node next;
        Node (int value) {
            this.value = value;
            this.next = null;
        }
    }
    //Basic operations
    public static class LinkedList20 {
        Node head;
        public void prepend (int value) {
            Node node = new Node(value);
            head.next = head;
            head = node;
        }
//  2 . append O(n) Linear Time (Without a tracking tail pointer)
        public void append (int value) {
            Node newNode = new Node(value);
            if (head == null) {
                head = newNode;
                return;
            }
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
//        3. Delete by Value: O(n) Search + O(1) Re-linking
        public void delete(int value) {
            if (head == null) return;
            if (head.value == value) {
                head = head.next;
                return;
            }
            Node current = head;
            while (current.next != null && current.next.value != value) {
                current = current.next;
            }
            if (current.next != null) {
                current.next = current.next.next;
            }
        }

        public void printList() {
            StringBuilder sb = new StringBuilder();
            Node current = head;
            while (current != null) {
                sb.append(current.value).append(" -> ");
                current = current.next;
            }
            sb.append("null");
            System.out.println(sb.toString());
        }
    }

    //Classic Linked List Algorithms
//    1. Floyd's Cycle Detection — Tortoise & Hare
    public boolean hasCycle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
//    2. Find Middle Node
    public Node findMiddle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
//    3. Reverse a node
    public Node reverse(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

//    4. Merge Two Sorted Lists
    public Node mergeSorted(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.value <= l2.value) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if (l1 != null) curr.next = l1;
        if (l2 != null) curr.next = l2;

        return dummy.next;
    }
}
