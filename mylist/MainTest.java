package com.mycompany.mylist;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class MainTest {
    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        LinkedList<String> linkedList = new LinkedList<>();
        long startOperation;
        long endOperation;
        for (int i = 0; i < 10000; i++) {
            myLinkedList.add("element" + i);
            linkedList.add("element" + i);
        }

        System.out.println("Add first.");
        startOperation = System.nanoTime();
        myLinkedList.add(0, "test addFirst");
        endOperation = System.nanoTime();
        System.out.println("MyLinkedList: " + (endOperation - startOperation));

        startOperation = System.nanoTime();
        linkedList.add(0, "test addFirst");
        endOperation = System.nanoTime();
        System.out.println("LinkedList: " + (endOperation - startOperation));
        System.out.println();

        System.out.println("Add last.");
        startOperation = System.nanoTime();
        myLinkedList.add(myLinkedList.size(), "test addLast");
        endOperation = System.nanoTime();
        System.out.println("MyLinkedList: " + (endOperation - startOperation));

        startOperation = System.nanoTime();
        linkedList.add(linkedList.size(), "test addLast");
        endOperation = System.nanoTime();
        System.out.println("LinkedList: " + (endOperation - startOperation));
        System.out.println();

        System.out.println("Add in the middle");
        startOperation = System.nanoTime();
        myLinkedList.add(5000, "test addMid");
        endOperation = System.nanoTime();
        System.out.println("MyLinkedList: " + (endOperation - startOperation));

        startOperation = System.nanoTime();
        linkedList.add(5000, "test addMid");
        endOperation = System.nanoTime();
        System.out.println("LinkedList: " + (endOperation - startOperation));
        System.out.println();

        System.out.println("Search by index");
        startOperation = System.nanoTime();
        myLinkedList.get(10000);
        endOperation = System.nanoTime();
        System.out.println("MyLinkedList: " + (endOperation - startOperation));

        startOperation = System.nanoTime();
        linkedList.get(10000);
        endOperation = System.nanoTime();
        System.out.println("LinkedList: " + (endOperation - startOperation));
        System.out.println();

        System.out.println("Search by value");
        startOperation = System.nanoTime();
        myLinkedList.indexOf("test addLast");
        endOperation = System.nanoTime();
        System.out.println("MyLinkedList: " + (endOperation - startOperation));

        startOperation = System.nanoTime();
        linkedList.indexOf("test addLast");
        endOperation = System.nanoTime();
        System.out.println("LinkedList: " + (endOperation - startOperation));
        System.out.println();

        System.out.println("Delete");
        startOperation = System.nanoTime();
        myLinkedList.remove(10000);
        endOperation = System.nanoTime();
        System.out.println("MyLinkedList: " + (endOperation - startOperation));

        startOperation = System.nanoTime();
        linkedList.remove(10000);
        endOperation = System.nanoTime();
        System.out.println("LinkedList: " + (endOperation - startOperation));
    }
}
