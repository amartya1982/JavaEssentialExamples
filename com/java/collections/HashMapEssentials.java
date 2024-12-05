package com.java.collections;

import java.util.*;
import java.util.stream.Collectors;

public class HashMapEssentials {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Cherry", 30);

        // how to print each element
        map.forEach((k, v) -> System.out.println("Key " + k + "Value " + v));
        System.out.println("------------------------------------------");
        // get the key having value greater than 10
        map.entrySet().stream().filter(
                k -> k.getValue() > 10
        ).forEach(k -> System.out.println("the key values greater than 10  " + k));
        System.out.println("------------------------------------------");

        for (String s : map.keySet()) {
            System.out.println("Using key Set " + s);
        }
        for (Integer i : map.values()) {
            System.out.println("Using value  " + i);
        }
        System.out.println("------------------------------------------");

        // using iteraror
        for (Map.Entry<String, Integer> prop_map : map.entrySet()) {
            System.out.println("With normal method Key " + prop_map.getKey() + " With normal method Value " + prop_map.getValue());
        }
        System.out.println("------------------------------------------");

        map.computeIfAbsent("Mango", v -> 34);
        map.computeIfPresent("Banana", (k,v) -> v+30);
        map.merge("Apple",5, (old, newVal) -> old+newVal);

        map.forEach((k,v) -> System.out.println("Updated key "+k+" and its value "+v));

        System.out.println("------------------------------------------");
        int[] arr = {1, 2, 3, 4, 5};
        List<Integer> ar = Arrays.stream(arr).boxed().collect(Collectors.toList());
        System.out.print(ar);    }
}
