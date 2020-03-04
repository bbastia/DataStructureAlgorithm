package org.example.datastructure.linkedlist;


import java.util.Objects;

public class SingleLinkedList<E> {

    public static void main(String[] args) {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        list.add(23);
        list.add(24);
        list.add(25);
        list.addAtFirst(20);
        list.addLast(30);
        list.addAt(10, 0);
        list.deleteNode(10);


        for (Object item : list.toArray()) {
            System.out.println(item);
        }

        System.out.println("Does exists: "+list.isExist(20));
    }

    private boolean isExist(E element) {
        Node tempNode = head;

        while (tempNode != null && tempNode.data != null){
            if(tempNode.data.equals(element)){
                return true;
            }
            tempNode = tempNode.next;
        }
        return false;
    }

    private void delete() {
        head = null;
        size = 0;
    }

    private void deleteNode(int data) {
        Node tempNode = head;

        if(head != null && head.data.equals(data)){
            head = tempNode.next;
            size--;
            return;
        }

        while (tempNode.next != null && tempNode.next.data != null) {
            if (tempNode.next.data.equals(data)) {
                tempNode.next = tempNode.next.next;
                break;
            }
            tempNode = tempNode.next;

        }
        size--;
    }

    /* 1,2,3,4  3rd position add 5
     * 1,2,5,3,4     */
    private void addAt(E e, int position) {
        if (position > size) throw new RuntimeException("Invalid location");
        Node<E> node = new Node<>(e);
        if (size == 0) throw new RuntimeException("Empty LinkedList");
        Node tempNode = head;
        size++;
        if (position == 0) {
            node.next = tempNode;
            this.head = node;
            return;
        }

        for (int i = 0; i < position - 1; i++) {
            tempNode = tempNode.next;
        }

        node.next = tempNode.next;
        tempNode.next = node;

    }

    private void addLast(E e) {
        Node<E> node = new Node<>(e);
        size++;

        if (Objects.isNull(head)) head = node;
        else {
            Node tempNode = head;

            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }
            tempNode.next = node;
        }
    }

    private void addAtFirst(E e) {
        Node<E> node = new Node<>(e);
        Node tempNode = head;
        head = node;
        head.next = tempNode;
        size++;

    }

    private Node head;
    private int size;

    public SingleLinkedList() {

    }

    public void add(E element) {
        Node<E> node = new Node(element);
        size++;

        if (Objects.isNull(head)) head = node;

        else {
            Node tempNode = head;
            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }
            tempNode.next = node;
        }
    }

    public Object[] toArray() {
        Object[] objects = new Object[size];
        if (head != null) {
            Node tempNode = head;
            int i = 0;
            while (tempNode != null) {
                objects[i++] = tempNode.data;
                tempNode = tempNode.next;
            }
        }

        return objects;
    }


    private static class Node<T> {
        private T data;
        private Node next;

        Node(T t) {
            this.data = t;
        }
    }
}
