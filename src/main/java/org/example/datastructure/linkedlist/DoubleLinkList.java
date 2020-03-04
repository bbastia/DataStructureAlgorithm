package org.example.datastructure.linkedlist;

public class DoubleLinkList {

    public static void main(String[] args) {
        DoubleLinkList list = new DoubleLinkList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        for(int i: list.toArray()){
            System.out.println(i);
        }
        list.printReverse();

    }

    private void printReverse() {
        Node tempNode = tail;
        while (tempNode != null){
            System.out.print(tempNode.data+" ");
            tempNode = tempNode.prev;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void add(int el) {
        Node node = new Node(el);

        if (head == null && tail == null) {
            head = node;
            tail = node;
            size++;
            return;
        }

        Node tempNode = head;
        while (tempNode != tail) {
            tempNode = tempNode.next;
        }
        tempNode.next = node;
        node.prev = tempNode;
        tail = node;
        size++;

    }

    public int[] toArray() {
        Node tempNode = head;
        int[] arr= new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = tempNode.data;
            tempNode = tempNode.next;
        }
        return arr;
    }

    private class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
        }
    }
}
