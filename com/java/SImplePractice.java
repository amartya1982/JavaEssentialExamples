package com.java;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SImplePractice {
    public static void main(String[] args){
        String[] strArray = {"cf","ase","amartya","ascd","a"};

        List<String> strArrayList = Arrays.stream(strArray).collect(Collectors.toList());
        List<String> strArrayList1 =Arrays.stream(strArray).sorted(Comparator.naturalOrder()).collect(Collectors.toList());

        strArrayList1.forEach(x -> System.out.println(x));

        HashMap<String,Integer> hm = new HashMap<>();
        for(String str : strArrayList){
            hm.put(str,str.length());
        }
        System.out.println("---------------------------");
        HashMap<String,Integer> newLinkedHashMap = hm.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1,e2)-> e1, LinkedHashMap::new));

        newLinkedHashMap.forEach((z,y) -> System.out.println(z));

        System.out.println("---------------------------");

        int[] sorted = IntStream.of(1234) .boxed() .sorted(Comparator.reverseOrder()) .mapToInt(i -> i) .toArray();

        System.out.println("---------------------------");

            System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
            // Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
            System.out.println(groupAnagrams(new String[]{""}));
            // Output: [[""]]
            System.out.println(groupAnagrams(new String[]{"a"}));
            // Output: [["a"]

        System.out.println("---------------------------");

        HashMap<String, Integer> map = new HashMap<>();
        map.put("Apple", 10);
        map.put("Banana", 30);
        map.put("Cherry", 20);
        map.put("Date", 40);
        map.put("Mango", 11);

        for(Map.Entry<String, Integer> m : map.entrySet()){
            Integer str = m.getValue() + 10;
            map.put(m.getKey(),str);
        }

        System.out.print(map.values());
    }

    public static List<List<String>> groupAnagrams(String[] input){
        HashMap<String, List<String>> resultMap = new HashMap<>();
        for(int i=0; i< input.length; i++){
            char[] charArray = input[i].toCharArray();
            Arrays.sort(charArray);
            String ketStr = new String(charArray);
            if(!resultMap.containsKey(ketStr)){
                List<String> listr = new ArrayList<>();
                listr.add(input[i]);
                resultMap.put(ketStr,listr);
            }else{
                resultMap.get(ketStr).add(input[i]);
            }
        }
      //  List<List<String>> strListResult = new ArrayList<>();
       // resultMap.forEach((x,v) -> strListResult.add(v));
        return new ArrayList<>(resultMap.values());
    }
}
