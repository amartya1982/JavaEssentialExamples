package com.java;

import java.util.*;

public class casualTestForWarmUp {

    public static void main(String args[]){
        HashMap<Integer, String> hm = new HashMap<>();
        hm.put(63,"Babai");
        hm.put(23,"Tubai");
        hm.put(111,"Sobai");
        hm.put(12,"Dubai");

       // System.out.println(hm.get(63));

        TreeMap<Integer, String> ts = new TreeMap<>();
        for(Map.Entry<Integer,String> entry : hm.entrySet()){
            System.out.println(entry.getKey() + "  -> "+ entry.getValue());
            ts.put(entry.getKey(),entry.getValue());
        }
        System.out.println("HOHOHOHOHOHOHOOHOHOHOHOHOHOHOHOH");

        for(Map.Entry<Integer,String> entry : ts.entrySet()){
            System.out.println(entry.getKey() + "  -> "+ entry.getValue());
        }
        int input = 12;
        String appendStr = "Stupid";
        if(hm.containsKey(input)){
            appendStr = appendStr + " " +hm.get(input);
            hm.put(input,appendStr);
        }else{
            hm.put(input,appendStr);
        }
        System.out.println("HOHOHOHOHOHOHOOHOHOHOHOHOHOHOHOH");

        for(Map.Entry<Integer,String> entry : hm.entrySet()){
            System.out.println(entry.getKey() + "  -> "+ entry.getValue());
        }

        List<Map.Entry<Integer,String>> list = new ArrayList<>(hm.entrySet());
        list.sort(Map.Entry.comparingByValue());
        list.sort(Map.Entry.comparingByKey());
        list.sort((a,b) -> b.getValue().compareTo(a.getValue()));

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        for(Map.Entry<Integer,String> entry : list){
            System.out.println(entry.getKey() + "  -> "+ entry.getValue());
        }

        TreeMap<Integer,String > treeMap = new TreeMap<>(Collections.reverseOrder());
        treeMap.putAll(hm);

        System.out.println("++++++++++++++++++++");

        for(Map.Entry<Integer,String> entry : treeMap.entrySet()){
            System.out.println(entry.getKey() + "  -> "+ entry.getValue());
        }
    }


}
