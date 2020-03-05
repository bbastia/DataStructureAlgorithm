package org.example.datastructure.stack;

public class StackUsingLinkedList {

    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    private Node head;
    private Node tail;
    private int size;

    public void push(int element) {
        Node node = new Node(element);
        if (head == null) {
            head = node;
            size++;
            return;
        } else {
            Node tempNode = head;

            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }
            tempNode.next = node;
            size++;
        }
    }

    public int pop() {
        if (head == null) throw new RuntimeException("Stack is Empty");
        Node tempNode = head;

        if (size == 1) {
            int element = tempNode.data;
            tempNode = null;
            return element;
        }

        while (tempNode.next != null && tempNode.next.next != null) {
            tempNode = tempNode.next;
        }
        int element = tempNode.next.data;
        tempNode.next = null;
        size--;
        return element;
    }

    private class Node {
        private int data;
        private Node next;

        Node(int data) {
            this.data = data;
        }
    }
}
