package org.example.datastructure.linkedlist;

public class CircularLinkedList {

    private int size;
    private Node head;
    private Node tail;

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }


    public static void main(String[] args) {

        CircularLinkedList list = new CircularLinkedList();
        list.add(17);
        list.add(19);
        list.add(20);
        list.add(21);
        list.add(23);
        list.add(54);
        list.addFront(10);
        list.addFront(0);
        list.addRear(100);
        list.deleteNode(0);
        //list.delete();

        for (int item : list.toArray()) {
            System.out.println(item);
        }

        list.printCircular();
    }

    private void delete() {
        head = null;
        tail = null;
        size = 0;
    }

    private void deleteNode(int el) {

        if(size == 0) throw new RuntimeException("Empty CircularList");

        if(size == 1 && head.data == el) {
            head = null;
            tail = null;
        }

        Node tempNode = head;

        if(tempNode.data == el){
            head = head.next;
        }

        while (tempNode.next != null && tempNode.next.data != el){
            tempNode = tempNode.next;
        }
        tempNode.next = tempNode.next.next;
        size--;
    }

    private void addRear(int el) {
        Node node = new Node(el);
        tail.next = node;
        tail = node;
        tail.next = head;
        size++;
    }

    private void addFront(int no) {
        Node node = new Node(no);
        node.next = head;
        head = node;
        tail.next = node;
        size++;
    }



    public void add(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            tail = node;
            tail.next = head;
        } else {

            Node tempNode = head;
            while (tempNode != tail) {
                tempNode = tempNode.next;
            }
            tail.next = node;
            tail = node;
            tail.next = head;
        }
        size++;
    }

    public int[] toArray() {
        Node tempNode = head;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = tempNode.data;
            tempNode = tempNode.next;
        }
        return arr;
    }

    public void printCircular() {
        Node tempNode = head;

        for (int i = 0; i < size; i++) {
            System.out.print(tempNode.data+"->");
            tempNode = tempNode.next;
        }
       if(tail != null) System.out.print(tail.next.data);
    }


}
