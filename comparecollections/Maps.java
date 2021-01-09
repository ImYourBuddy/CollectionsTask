package com.mycompany.comparecollections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class Maps {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        long startOperation;
        long endOperation;
        for (int i = 0; i < 10000; i++) {
            hashMap.put(i, "element" + i);
            linkedHashMap.put(i, "element" + i);
            treeMap.put(i, "element" + i);
        }

        System.out.println("Add test.");
        startOperation = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            hashMap.put(hashMap.size() + i, "test add");
        }
        endOperation = System.nanoTime();
        System.out.println("HashMap: " + (endOperation - startOperation));

        startOperation = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            linkedHashMap.put(linkedHashMap.size() + i, "test add");
        }
        endOperation = System.nanoTime();
        System.out.println("LinkedHashMap: " + (endOperation - startOperation));

        startOperation = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            treeMap.put(treeMap.size() + i, "test add");
        }
        endOperation = System.nanoTime();
        System.out.println("TreeMap: " + (endOperation - startOperation));
        System.out.println();

        System.out.println("Search key test.");
        startOperation = System.nanoTime();
        for (int i = 4000; i < 5000; i++) {
            hashMap.containsKey(i);
        }
        endOperation = System.nanoTime();
        System.out.println("HashMap: " + (endOperation - startOperation));

        startOperation = System.nanoTime();
        for (int i = 4000; i < 5000; i++) {
            linkedHashMap.containsKey(i);
        }
        endOperation = System.nanoTime();
        System.out.println("LinkedHashMap: " + (endOperation - startOperation));

        startOperation = System.nanoTime();
        for (int i = 4000; i < 5000; i++) {
            treeMap.containsKey(i);
        }
        endOperation = System.nanoTime();
        System.out.println("TreeMap: " + (endOperation - startOperation));
        System.out.println();

        System.out.println("Search value test.");
        startOperation = System.nanoTime();
        for (int i = 4000; i < 5000; i++) {
            hashMap.containsValue("element" + i);
        }
        endOperation = System.nanoTime();
        System.out.println("HashMap: " + (endOperation - startOperation));

        startOperation = System.nanoTime();
        for (int i = 4000; i < 5000; i++) {
            linkedHashMap.containsValue("element" + i);
        }
        endOperation = System.nanoTime();
        System.out.println("LinkedHashMap: " + (endOperation - startOperation));

        startOperation = System.nanoTime();
        for (int i = 4000; i < 5000; i++) {
            treeMap.containsValue("element" + i);
        }
        endOperation = System.nanoTime();
        System.out.println("TreeMap: " + (endOperation - startOperation));
        System.out.println();

        System.out.println("Delete test.");
        startOperation = System.nanoTime();
        for (int i = 4000; i < 5000; i++) {
            hashMap.remove(i);
        }
        endOperation = System.nanoTime();
        System.out.println("HashMap: " + (endOperation - startOperation));

        startOperation = System.nanoTime();
        for (int i = 4000; i < 5000; i++) {
            linkedHashMap.remove(i);
        }
        endOperation = System.nanoTime();
        System.out.println("LinkedHashMap: " + (endOperation - startOperation));

        startOperation = System.nanoTime();
        for (int i = 4000; i < 5000; i++) {
            treeMap.remove(i);
        }
        endOperation = System.nanoTime();
        System.out.println("TreeMap: " + (endOperation - startOperation));
        System.out.println();
    }
}
