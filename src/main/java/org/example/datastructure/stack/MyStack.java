package org.example.datastructure.stack;

public class MyStack {

    private int top = -1;
    private int DEFAULT_CAPACITY = 10;
    private int capacity = DEFAULT_CAPACITY;
    private int[] stack;

    MyStack(){
        stack = new int[DEFAULT_CAPACITY];
    }

    MyStack(int capacity){
        stack = new int[capacity];
        this.capacity = capacity;
    }

    public void push(int data){
        if(isFull()) throw new RuntimeException("Stack is Full");
        stack[++top] = data;
    }

    private boolean isFull() {
        return top == capacity-1;
    }

    public int pop(){
        if(isEmpty()) throw  new RuntimeException("Stack is Empty");
        int element = stack[top];
        stack[top--] = 0;
        return element;
    }

    public int peek(){
        return stack[top];
    }

    private boolean isEmpty() {
        return top == -1;
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack(5);
        stack.push(12);
        stack.push(13);
        stack.push(14);
        stack.push(15);
        stack.push(16);

      while (!stack.isEmpty()){
          System.out.print(stack.pop()+" ");
      }
    }
}



