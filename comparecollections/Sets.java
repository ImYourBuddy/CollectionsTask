package com.mycompany.comparecollections;

import com.mycompany.firsttask.shapes.Circle;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Sets {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        TreeSet<String> treeSet = new TreeSet<>();
        for (int i = 0; i < 100000; i++) {
            hashSet.add("element" + i);
            linkedHashSet.add("element" + i);
            treeSet.add("element" + i);
        }
        System.out.println("Add test.");
        addTest(hashSet);
        addTest(linkedHashSet);
        addTest(treeSet);
        System.out.println();

        System.out.println("Search test.");
        searchTest(hashSet);
        searchTest(linkedHashSet);
        searchTest(treeSet);
        System.out.println();

        System.out.println("Delete test.");
        deleteTest(hashSet);
        deleteTest(linkedHashSet);
        deleteTest(treeSet);

    }

    private static void addTest (Set set) {
        long startOperation = 0;
        long endOperation = 0;
        startOperation = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            set.add("test add" + i);
        }
        endOperation = System.nanoTime();
        System.out.println(set.getClass().getSimpleName() + ": " + (endOperation - startOperation));
    }
    private static void deleteTest (Set set) {
        long startOperation = 0;
        long endOperation = 0;
        startOperation = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            set.remove("element" + i);
        }
        endOperation = System.nanoTime();
        System.out.println(set.getClass().getSimpleName() + ": " + (endOperation - startOperation));
    }
    private static void searchTest (Set set) {
        long startOperation = 0;
        long endOperation = 0;
        startOperation = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            set.contains("element" + i);
        }
        endOperation = System.nanoTime();
        System.out.println(set.getClass().getSimpleName() + ": " + (endOperation - startOperation));
    }
}
