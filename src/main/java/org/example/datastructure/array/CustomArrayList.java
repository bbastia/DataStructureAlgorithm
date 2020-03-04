package org.example.datastructure.array;

import java.util.Arrays;
import java.util.Objects;

public class CustomArrayList {
    public static void main(String[] args) {

        MyArrayList<String> arrayList = new MyArrayList<String>();
        arrayList.add("banda");
        arrayList.add("pela");
        arrayList.add("banda");
        arrayList.add("pela");
        arrayList.add("banda");
        arrayList.add("pela");
        arrayList.add("banda");
        arrayList.add("pela");
        arrayList.add("banda");
        arrayList.add("pela");
        arrayList.add("banda");
        arrayList.add("pela");

        arrayList.printElement();
        System.out.println(arrayList.size);

    }

    static class MyArrayList<T> {

        private int size;

        Object[] elementData;

        private static final int DEFAULT_CAPACITY = 10;

        MyArrayList(int initialCapacity) {
            this.size = initialCapacity;
            elementData = new Object[initialCapacity];
        }

        MyArrayList() {
            elementData = new Object[DEFAULT_CAPACITY];
        }


        public void add(Object o) {
            ensureCapacity();
            elementData[size++] = o;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void ensureCapacity() {
            if (size == DEFAULT_CAPACITY) {
                int newCapacity = DEFAULT_CAPACITY * 2 + 1;
                elementData = Arrays.copyOf(elementData, newCapacity);
            }
        }

        public void printElement() {
            boolean set = false;
            System.out.print("[ ");

            for (Object elem : elementData) {
                if (Objects.nonNull(elem)) {
                    if (set) System.out.print(", ");
                    if(!set) set = true;
                    System.out.print(elem);
                }

            }

            System.out.print("]");
            System.out.println();

        }

        public int getSize() {
            return this.size;
        }

    }
}
