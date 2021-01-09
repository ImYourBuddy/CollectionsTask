package com.mycompany.comparecollections;

import com.mycompany.firsttask.shapes.Circle;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Sets {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        TreeSet<String> treeSet = new TreeSet<>();
        long startOperation;
        long endOperation;
        for (int i = 0; i < 100000; i++) {
            hashSet.add("element" + i);
            linkedHashSet.add("element" + i);
            treeSet.add("element" + i);
        }
        System.out.println("Add test.");
        startOperation = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            hashSet.add("test add");
        }
        endOperation = System.nanoTime();
        System.out.println("HashSet: " + (endOperation - startOperation));

        startOperation = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            linkedHashSet.add("test add");
        }
        endOperation = System.nanoTime();
        System.out.println("LinkedHashSet: " + (endOperation - startOperation));

        startOperation = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            treeSet.add("test add");
        }
        endOperation = System.nanoTime();
        System.out.println("TreeSet: " + (endOperation - startOperation));
        System.out.println();

        System.out.println("Search test.");
        startOperation = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            hashSet.contains("test add");
        }
        endOperation = System.nanoTime();
        System.out.println("HashSet: " + (endOperation - startOperation));

        startOperation = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            linkedHashSet.contains("test add");
        }
        endOperation = System.nanoTime();
        System.out.println("LinkedHashSet: " + (endOperation - startOperation));

        startOperation = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            treeSet.contains("test add");
        }
        endOperation = System.nanoTime();
        System.out.println("TreeSet: " + (endOperation - startOperation));
        System.out.println();

        System.out.println("Delete test.");
        startOperation = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            hashSet.remove("test add");
        }
        endOperation = System.nanoTime();
        System.out.println("HashSet: " + (endOperation - startOperation));

        startOperation = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            linkedHashSet.remove("test add");
        }
        endOperation = System.nanoTime();
        System.out.println("LinkedHashSet: " + (endOperation - startOperation));

        startOperation = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            treeSet.remove("test add");
        }
        endOperation = System.nanoTime();
        System.out.println("TreeSet: " + (endOperation - startOperation));
        System.out.println();
    }
}
