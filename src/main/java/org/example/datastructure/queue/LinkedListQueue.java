package org.example.datastructure.queue;
import java.util.stream.IntStream;

public class LinkedListQueue {

    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();
        IntStream.rangeClosed(1,50).forEach(queue::enQueue);

        while (!queue.isEmpty()){
            System.out.print(queue.deQueue()+" ");
        }
    }

    private Node head;
    private Node rear;

    public void enQueue(int element){
        Node node = new Node(element);

        if(isEmpty()) {
            rear = node;
            head = rear;
        }else{
            rear.next = node;
            rear = rear.next;
        }
    }

    public int deQueue(){
        if(isEmpty()) throw new RuntimeException("Queue is Empty");
        int data = head.data;
        head = head.next;
        return data;
    }

    private boolean isEmpty() {
        return head == null;
    }

    static class Node{
        private int data;
        private Node next;
        Node(int data){
            this.data = data;
        }
    }
}
