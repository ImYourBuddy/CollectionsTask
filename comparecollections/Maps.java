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
        hashMap.put(5000, "test add");
        endOperation = System.nanoTime();
        System.out.println("HashMap: " + (endOperation - startOperation));

        startOperation = System.nanoTime();
        linkedHashMap.put(5000, "test add");
        endOperation = System.nanoTime();
        System.out.println("LinkedHashMap: " + (endOperation - startOperation));

        startOperation = System.nanoTime();
        treeMap.put(5000, "test add");
        endOperation = System.nanoTime();
        System.out.println("TreeMap: " + (endOperation - startOperation));
        System.out.println();

        System.out.println("Search key test.");
        startOperation = System.nanoTime();
        hashMap.containsKey(5000);
        endOperation = System.nanoTime();
        System.out.println("HashMap: " + (endOperation - startOperation));

        startOperation = System.nanoTime();
        linkedHashMap.containsKey(5000);
        endOperation = System.nanoTime();
        System.out.println("LinkedHashMap: " + (endOperation - startOperation));

        startOperation = System.nanoTime();
        treeMap.containsKey(5000);
        endOperation = System.nanoTime();
        System.out.println("TreeMap: " + (endOperation - startOperation));
        System.out.println();

        System.out.println("Search value test.");
        startOperation = System.nanoTime();
        hashMap.containsValue("test add");
        endOperation = System.nanoTime();
        System.out.println("HashMap: " + (endOperation - startOperation));

        startOperation = System.nanoTime();
        linkedHashMap.containsValue("test add");
        endOperation = System.nanoTime();
        System.out.println("LinkedHashMap: " + (endOperation - startOperation));

        startOperation = System.nanoTime();
        treeMap.containsValue("test add");
        endOperation = System.nanoTime();
        System.out.println("TreeMap: " + (endOperation - startOperation));
        System.out.println();

        System.out.println("Delete test.");
        startOperation = System.nanoTime();
        hashMap.remove(5000);
        endOperation = System.nanoTime();
        System.out.println("HashMap: " + (endOperation - startOperation));

        startOperation = System.nanoTime();
        linkedHashMap.remove(5000);
        endOperation = System.nanoTime();
        System.out.println("LinkedHashMap: " + (endOperation - startOperation));

        startOperation = System.nanoTime();
        treeMap.remove(5000);
        endOperation = System.nanoTime();
        System.out.println("TreeMap: " + (endOperation - startOperation));
        System.out.println();
    }
}
