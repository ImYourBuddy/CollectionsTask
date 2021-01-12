package com.mycompany.mylist;


import java.util.LinkedList;

public class MainTest {
    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        LinkedList<String> linkedList = new LinkedList<>();
        for (int i = 0; i < 10000; i++) {
            myLinkedList.add("element" + i);
            linkedList.add("element" + i);
        }

        System.out.println("Add first.");
        addTest(myLinkedList, linkedList, 0);
        System.out.println();

        System.out.println("Add in the middle");
        addTest(myLinkedList, linkedList, myLinkedList.size() / 2);
        System.out.println();

        System.out.println("Add last.");
        addTest(myLinkedList, linkedList, myLinkedList.size());
        System.out.println();

        System.out.println("Search by index first element");
        searchByIndexTest(myLinkedList, linkedList, 0);
        System.out.println();

        System.out.println("Search by index middle element");
        searchByIndexTest(myLinkedList, linkedList, myLinkedList.size() / 2);
        System.out.println();

        System.out.println("Search by index last element");
        searchByIndexTest(myLinkedList, linkedList, myLinkedList.size() - 1);
        System.out.println();

        System.out.println("Search by value");
        searchByValueTest(myLinkedList, linkedList, "test add");
        System.out.println();

        System.out.println("Delete from first position");
        deleteTest(myLinkedList, linkedList, 0);
        System.out.println();

        System.out.println("Delete from middle position");
        deleteTest(myLinkedList, linkedList, myLinkedList.size() / 2);
        System.out.println();

        System.out.println("Delete from last position");
        deleteTest(myLinkedList, linkedList, myLinkedList.size() - 1);
        System.out.println();

    }

    private static void addTest(MyLinkedList myLinkedList, LinkedList linkedList, int index) {
        long startOperation = 0;
        long endOperation = 0;

        if (index == myLinkedList.size()) {
            startOperation = System.nanoTime();
            for (int i = 0; i < 1000; i++) {
                myLinkedList.add(myLinkedList.size(), "test add");
            }
            endOperation = System.nanoTime();
            System.out.println("MyLinkedList: " + (endOperation - startOperation));

            startOperation = System.nanoTime();
            for (int i = 0; i < 1000; i++) {
                linkedList.add(linkedList.size(), "test add");
            }
            endOperation = System.nanoTime();
            System.out.println("LinkedList: " + (endOperation - startOperation));
        } else {
            startOperation = System.nanoTime();
            for (int i = 0; i < 1000; i++) {
                myLinkedList.add(index, "test add");
            }
            endOperation = System.nanoTime();
            System.out.println("MyLinkedList: " + (endOperation - startOperation));

            startOperation = System.nanoTime();
            for (int i = 0; i < 1000; i++) {
                linkedList.add(index, "test add");
            }
            endOperation = System.nanoTime();
            System.out.println("LinkedList: " + (endOperation - startOperation));
        }
    }

    private static void searchByIndexTest(MyLinkedList myLinkedList, LinkedList linkedList, int index) {
        long startOperation = 0;
        long endOperation = 0;

        if (index == myLinkedList.size() - 1) {
            startOperation = System.nanoTime();
            for (int i = 0; i < 1000; i++) {
                myLinkedList.get(myLinkedList.size() - 1);
            }
            endOperation = System.nanoTime();
            System.out.println("MyLinkedList: " + (endOperation - startOperation));

            startOperation = System.nanoTime();
            for (int i = 0; i < 1000; i++) {
                linkedList.get(linkedList.size() - 1);
            }
            endOperation = System.nanoTime();
            System.out.println("LinkedList: " + (endOperation - startOperation));
        } else {
            startOperation = System.nanoTime();
            for (int i = 0; i < 1000; i++) {
                myLinkedList.get(index);
            }
            endOperation = System.nanoTime();
            System.out.println("MyLinkedList: " + (endOperation - startOperation));

            startOperation = System.nanoTime();
            for (int i = 0; i < 1000; i++) {
                linkedList.get(index);
            }
            endOperation = System.nanoTime();
            System.out.println("LinkedList: " + (endOperation - startOperation));
        }
    }

    private static <E> void searchByValueTest(MyLinkedList<E> myLinkedList, LinkedList<E> linkedList, E value) {
        long startOperation = 0;
        long endOperation = 0;

        startOperation = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            myLinkedList.indexOf(value);
        }
        endOperation = System.nanoTime();
        System.out.println("MyLinkedList: " + (endOperation - startOperation));

        startOperation = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            linkedList.indexOf(value);
        }
        endOperation = System.nanoTime();
        System.out.println("LinkedList: " + (endOperation - startOperation));
        System.out.println();
    }

    private static void deleteTest(MyLinkedList myLinkedList, LinkedList linkedList, int index) {
        long startOperation = 0;
        long endOperation = 0;

        if (index == myLinkedList.size() - 1) {
            startOperation = System.nanoTime();
            for (int i = 0; i < 1000; i++) {
                myLinkedList.remove(myLinkedList.size() - 1);
            }
            endOperation = System.nanoTime();
            System.out.println("MyLinkedList: " + (endOperation - startOperation));

            startOperation = System.nanoTime();
            for (int i = 0; i < 1000; i++) {
                linkedList.remove(myLinkedList.size() - 1);
            }
            endOperation = System.nanoTime();
            System.out.println("LinkedList: " + (endOperation - startOperation));
        } else {
            startOperation = System.nanoTime();
            for (int i = 0; i < 1000; i++) {
                myLinkedList.remove(index);
            }
            endOperation = System.nanoTime();
            System.out.println("MyLinkedList: " + (endOperation - startOperation));

            startOperation = System.nanoTime();
            for (int i = 0; i < 1000; i++) {
                linkedList.remove(index);
            }
            endOperation = System.nanoTime();
            System.out.println("LinkedList: " + (endOperation - startOperation));
        }
    }
}
