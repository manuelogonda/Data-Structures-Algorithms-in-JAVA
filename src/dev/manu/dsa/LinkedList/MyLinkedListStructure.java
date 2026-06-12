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
        // O(1) — insert at the front
        public void prepend (int value) {
            Node node = new Node(value);
            head.next = head;
            head = node;

        }
//        2 . append O(n) Linear Time (Without a tracking tail pointer)
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
}
