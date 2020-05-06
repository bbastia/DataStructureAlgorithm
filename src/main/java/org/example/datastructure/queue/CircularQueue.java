package org.example.datastructure.queue;

public class CircularQueue {


    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue();
        queue.enQueue(2);
        queue.enQueue(4);
        queue.enQueue(6);
        queue.enQueue(8);
        queue.enQueue(10);
        queue.enQueue(12);
        queue.enQueue(14);
        queue.enQueue(16);
        queue.enQueue(18);
        queue.enQueue(20);
        queue.enQueue(21);
        queue.enQueue(22);

      for(int i=0; i< queue.size;i++){
          System.out.print(queue.deQueue()+" ");
      }

    }


    private int capacity;
    private int front = -1;
    private int size = 0;
    private int rear = -1;
    private int[] queue;

    CircularQueue() {
        this.capacity = 10;
        this.size = capacity;
        queue = new int[capacity];
    }

    public void enQueue(int element) {
        if (isFull()) {
            front = -1;
        }
        queue[++front] = element;
    }

    public int deQueue(){
        if(isEmpty()) throw new RuntimeException("Queue is Empty");
        if(rear+1 == size) rear = -1;
        return queue[++rear];

    }

    private boolean isEmpty() {
        return queue.length == 0 ;
    }

    private boolean isFull() {
        return front == size - 1;
    }

}
