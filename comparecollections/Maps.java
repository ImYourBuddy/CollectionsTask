package com.mycompany.comparecollections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
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
        addTest(hashMap);
        addTest(linkedHashMap);
        addTest(treeMap);
        System.out.println();

        System.out.println("Search key test.");
        searchKeyTest(hashMap);
        searchKeyTest(linkedHashMap);
        searchKeyTest(treeMap);
        System.out.println();

        System.out.println("Search value test.");
        searchValueTest(hashMap);
        searchValueTest(linkedHashMap);
        searchValueTest(treeMap);
        System.out.println();

        System.out.println("Delete test.");
        deleteTest(hashMap);
        deleteTest(linkedHashMap);
        deleteTest(treeMap);
        System.out.println();
    }

    public static void addTest(Map map) {
        long startOperation = 0;
        long endOperation = 0;
        startOperation = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            map.put(map.size() + i, "test add");
        }
        endOperation = System.nanoTime();
        System.out.println(map.getClass().getSimpleName() + ": " + (endOperation - startOperation));
    }

    public static void searchKeyTest(Map map) {
        long startOperation = 0;
        long endOperation = 0;
        startOperation = System.nanoTime();
        for (int i = 4000; i < 5000; i++) {
            map.containsKey(i);
        }
        endOperation = System.nanoTime();
        System.out.println(map.getClass().getSimpleName() + ": " + (endOperation - startOperation));
    }

    public static void searchValueTest(Map map) {
        long startOperation = 0;
        long endOperation = 0;
        startOperation = System.nanoTime();
        for (int i = 4000; i < 5000; i++) {
            map.containsValue("element" + i);
        }
        endOperation = System.nanoTime();
        System.out.println(map.getClass().getSimpleName() + ": " + (endOperation - startOperation));
    }

    public static void deleteTest(Map map) {
        long startOperation = 0;
        long endOperation = 0;
        startOperation = System.nanoTime();
        for (int i = 4000; i < 5000; i++) {
            map.remove(i);
        }
        endOperation = System.nanoTime();
        System.out.println(map.getClass().getSimpleName() + ": " + (endOperation - startOperation));
    }
}
