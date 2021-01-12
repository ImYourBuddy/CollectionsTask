package com.mycompany.comparecollections;

import com.mycompany.firsttask.shapes.Circle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListAndLinkedList {
    public static void main(String[] args) {
        ArrayList<Circle> arrayList = new ArrayList<>();
        LinkedList<Circle> linkedList = new LinkedList<>();
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
        addTest(arrayList, 0);
        addTest(linkedList, 0);
        System.out.println();

        System.out.println("Add last.");
        addTest(arrayList, arrayList.size());
        addTest(linkedList, linkedList.size());
        System.out.println();

        System.out.println("Add in the middle");
        addTest(arrayList, arrayList.size() / 2);
        addTest(linkedList, linkedList.size() / 2);
        System.out.println();

        System.out.println("Search by index from start");
        searchByIndexTest(arrayList, 0);
        searchByIndexTest(arrayList, 0);
        System.out.println();

        System.out.println("Search by index from end");
        searchByIndexTest(arrayList, arrayList.size());
        searchByIndexTest(linkedList, linkedList.size());
        System.out.println();

        System.out.println("Search by index from middle");
        searchByIndexTest(arrayList, arrayList.size() / 2);
        searchByIndexTest(linkedList, linkedList.size() / 2);
        System.out.println();

        System.out.println("Search by value");
        searchByValueTest(arrayList, new Circle(0.5, "purple"));
        searchByValueTest(linkedList, new Circle(0.5, "purple"));
        System.out.println();

        System.out.println("Delete from start");
        deleteTest(arrayList, 0);
        deleteTest(linkedList, 0);
        System.out.println();

        System.out.println("Delete from end");
        deleteTest(arrayList, arrayList.size());
        deleteTest(linkedList, linkedList.size());
        System.out.println();

        System.out.println("Delete from end");
        deleteTest(arrayList, arrayList.size() / 2);
        deleteTest(linkedList, linkedList.size() / 2);

    }

    public static void addTest(List list, int index) {
        long startOperation = 0;
        long endOperation = 0;
        if (list.size() == index) {
            startOperation = System.nanoTime();
            for (int i = 0; i < 10000; i++) {
                list.add(list.size(), new Circle(0.5, "purple"));
            }
            endOperation = System.nanoTime();
        } else {
            startOperation = System.nanoTime();
            for (int i = 0; i < 10000; i++) {
                list.add(index, new Circle(0.5, "purple"));
            }
            endOperation = System.nanoTime();
        }
        System.out.println(list.getClass().getSimpleName() + ": " + (endOperation - startOperation));
    }

    public static void searchByIndexTest(List list, int index) {
        long startOperation = 0;
        long endOperation = 0;
        if (list.size() == index) {
            startOperation = System.nanoTime();
            for (int i = 0; i < 10000; i++) {
                list.get(list.size() - 1);
            }
            endOperation = System.nanoTime();
        } else {
            startOperation = System.nanoTime();
            for (int i = 0; i < 10000; i++) {
                list.get(index);
            }
            endOperation = System.nanoTime();
        }
        System.out.println(list.getClass().getSimpleName() + ": " + (endOperation - startOperation));
    }

    public static <E> void searchByValueTest(List<E> list, E value) {
        long startOperation = 0;
        long endOperation = 0;
        startOperation = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            list.indexOf(value);
        }
        endOperation = System.nanoTime();
        System.out.println(list.getClass().getSimpleName() + ": " + (endOperation - startOperation));
    }

    public static void deleteTest(List list, int index) {
        long startOperation = 0;
        long endOperation = 0;
        if (list.size() == index) {
            startOperation = System.nanoTime();
            for (int i = 0; i < 10000; i++) {
                list.remove(list.size() - 1);
            }
            endOperation = System.nanoTime();
        } else {
            startOperation = System.nanoTime();
            for (int i = 0; i < 10000; i++) {
                list.remove(index);
            }
            endOperation = System.nanoTime();
        }
        System.out.println(list.getClass().getSimpleName() + ": " + (endOperation - startOperation));
    }
}
