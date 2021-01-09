package com.mycompany.comparecollections;

import com.mycompany.firsttask.shapes.Circle;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayListAndLinkedList {
    public static void main(String[] args) {
        ArrayList<Circle> arrayList = new ArrayList<>();
        LinkedList<Circle> linkedList = new LinkedList<>();
        long startOperation;
        long endOperation;
        for (int i = 0; i < 100000; i++) {
            if (i >= 0 && i < 20000) {
                arrayList.add(new Circle(i + 1, "black"));
                linkedList.add(new Circle(i + 1, "black"));
            }
            if (i >= 20000 && i < 40000) {
                arrayList.add(new Circle(i, "blue"));
                linkedList.add(new Circle(i, "blue"));
            }
            if (i >= 40000 && i < 60000) {
                arrayList.add(new Circle(i, "red"));
                linkedList.add(new Circle(i, "red"));
            }
            if (i >= 60000 && i < 80000) {
                arrayList.add(new Circle(i, "yellow"));
                linkedList.add(new Circle(i, "yellow"));
            }
            if (i >= 80000 && i < 100000) {
                arrayList.add(new Circle(i, "green"));
                linkedList.add(new Circle(i, "green"));
            }
        }

        System.out.println("Add first.");
        startOperation = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(0, new Circle(10.5, "purple"));
        }
        endOperation = System.nanoTime();
        System.out.println("ArrayList: " + (endOperation - startOperation));

        startOperation = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            linkedList.add(0, new Circle(10.5, "purple"));
        }
        endOperation = System.nanoTime();
        System.out.println("LinkedList: " + (endOperation - startOperation));
        System.out.println();

        System.out.println("Add last.");
        startOperation = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(arrayList.size(), new Circle(0.5, "brown"));
        }
        endOperation = System.nanoTime();
        System.out.println("ArrayList: " + (endOperation - startOperation));

        startOperation = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            linkedList.add(linkedList.size(), new Circle(0.5, "brown"));
        }
        endOperation = System.nanoTime();
        System.out.println("LinkedList: " + (endOperation - startOperation));
        System.out.println();

        System.out.println("Add in the middle");
        startOperation = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(arrayList.size() / 2, new Circle(5.0, "orange"));
        }
        endOperation = System.nanoTime();
        System.out.println("ArrayList: " + (endOperation - startOperation));

        startOperation = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            linkedList.add(linkedList.size() / 2, new Circle(5.0, "orange"));
        }
        endOperation = System.nanoTime();
        System.out.println("LinkedList: " + (endOperation - startOperation));
        System.out.println();

        System.out.println("Search by index");
        startOperation = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            arrayList.get(arrayList.size() / 2);
        }
        endOperation = System.nanoTime();
        System.out.println("ArrayList: " + (endOperation - startOperation));

        startOperation = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            linkedList.get(linkedList.size() / 2);
        }
        endOperation = System.nanoTime();
        System.out.println("LinkedList: " + (endOperation - startOperation));
        System.out.println();

        System.out.println("Search by value");
        startOperation = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            arrayList.indexOf("test addLast");
        }
        endOperation = System.nanoTime();
        System.out.println("ArrayList: " + (endOperation - startOperation));

        startOperation = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            linkedList.indexOf("test addLast");
        }
        endOperation = System.nanoTime();
        System.out.println("LinkedList: " + (endOperation - startOperation));
        System.out.println();

        System.out.println("Delete");
        startOperation = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            arrayList.remove(arrayList.size() / 2);
        }
        endOperation = System.nanoTime();
        System.out.println("ArrayList: " + (endOperation - startOperation));

        startOperation = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            linkedList.remove(linkedList.size() / 2);
        }
        endOperation = System.nanoTime();
        System.out.println("LinkedList: " + (endOperation - startOperation));
    }
}
