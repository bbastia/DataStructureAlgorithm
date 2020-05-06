package org.example.datastructure.queue;


public class MyQueue {

    private int DEFAULT_CAPACITY = 10;
    private int size ;
    private int capacity = 10;
    private int rear = -1;
    private int front = -1;
    int[] queue;

    MyQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
    }

    MyQueue(){
        this.capacity = DEFAULT_CAPACITY;
        queue = new int[DEFAULT_CAPACITY];
    }

    private void enQueue(int element){
        if(isFull()) throw new RuntimeException("Queue is FULL");
        if(front == -1) front = 0;
        queue[++rear] = element;
        size++;
    }

    private int deQueue(){
        if(isEmpty()) throw new RuntimeException("Queue is EMPTY");
        size--;
        return queue[front++];
    }


    private boolean isFull() {
        return size == capacity;
    }


    private boolean isEmpty() {
       return size == 0;
    }

    private int peek(){
        if(isEmpty()) throw new RuntimeException("Queue is EMPTY");
        return queue[rear];
    }


    private void delete(){
        size = 0;
        queue = null;
    }

    public static void main(String[] args) {

        MyQueue queue = new MyQueue();
        queue.enQueue(23);
        queue.enQueue(24);
        queue.enQueue(25);
        queue.enQueue(26);

        while (!queue.isEmpty()){
            System.out.print(queue.deQueue()+" ");
        }

    }

}
