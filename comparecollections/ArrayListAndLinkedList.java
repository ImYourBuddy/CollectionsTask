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
        for (int i = 0; i < 1000000; i++) {
            if (i >= 0 && i < 200000) {
                arrayList.add(new Circle(i + 1, "black"));
                linkedList.add(new Circle(i + 1, "black"));
            }
            if (i >= 200000 && i < 400000) {
                arrayList.add(new Circle(i, "blue"));
                linkedList.add(new Circle(i, "blue"));
            }
            if (i >= 400000 && i < 600000) {
                arrayList.add(new Circle(i, "red"));
                linkedList.add(new Circle(i, "red"));
            }
            if (i >= 600000 && i < 800000) {
                arrayList.add(new Circle(i, "yellow"));
                linkedList.add(new Circle(i, "yellow"));
            }
            if (i >= 800000 && i < 1000000) {
                arrayList.add(new Circle(i, "green"));
                linkedList.add(new Circle(i, "green"));
            }
        }

        System.out.println("Add first.");
        startOperation = System.nanoTime();
        arrayList.add(0, new Circle(10.5, "purple"));
        endOperation = System.nanoTime();
        System.out.println("ArrayList: " + (endOperation - startOperation));

        startOperation = System.nanoTime();
        linkedList.add(0, new Circle(10.5, "purple"));
        endOperation = System.nanoTime();
        System.out.println("LinkedList: " + (endOperation - startOperation));
        System.out.println();

        System.out.println("Add last.");
        startOperation = System.nanoTime();
        arrayList.add(arrayList.size(), new Circle(0.5, "brown"));
        endOperation = System.nanoTime();
        System.out.println("ArrayList: " + (endOperation - startOperation));

        startOperation = System.nanoTime();
        linkedList.add(linkedList.size(), new Circle(0.5, "brown"));
        endOperation = System.nanoTime();
        System.out.println("LinkedList: " + (endOperation - startOperation));
        System.out.println();

        System.out.println("Add in the middle");
        startOperation = System.nanoTime();
        arrayList.add(50000, new Circle(5.0, "orange"));
        endOperation = System.nanoTime();
        System.out.println("ArrayList: " + (endOperation - startOperation));

        startOperation = System.nanoTime();
        linkedList.add(50000, new Circle(5.0, "orange"));
        endOperation = System.nanoTime();
        System.out.println("LinkedList: " + (endOperation - startOperation));
        System.out.println();

        System.out.println("Search by index");
        startOperation = System.nanoTime();
        arrayList.get(50000);
        endOperation = System.nanoTime();
        System.out.println("ArrayList: " + (endOperation - startOperation));

        startOperation = System.nanoTime();
        linkedList.get(50000);
        endOperation = System.nanoTime();
        System.out.println("LinkedList: " + (endOperation - startOperation));
        System.out.println();

        System.out.println("Search by value");
        startOperation = System.nanoTime();
        arrayList.indexOf("test addLast");
        endOperation = System.nanoTime();
        System.out.println("ArrayList: " + (endOperation - startOperation));

        startOperation = System.nanoTime();
        linkedList.indexOf("test addLast");
        endOperation = System.nanoTime();
        System.out.println("LinkedList: " + (endOperation - startOperation));
        System.out.println();

        System.out.println("Delete");
        startOperation = System.nanoTime();
        arrayList.remove(50000);
        endOperation = System.nanoTime();
        System.out.println("ArrayList: " + (endOperation - startOperation));

        startOperation = System.nanoTime();
        linkedList.remove(50000);
        endOperation = System.nanoTime();
        System.out.println("LinkedList: " + (endOperation - startOperation));
    }
}
