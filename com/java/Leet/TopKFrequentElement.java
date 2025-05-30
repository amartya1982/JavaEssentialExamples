package com.java.Leet;

import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequentElement {

    public static void main(String args[]){
        int[] intArray = new int[]{1,2,3,1,1,2,4,4,4,4,4};
        int k = 3;
        int[] resultArray = getTopKFrequestElement(intArray, k);
        System.out.println(" The result values are : ");
        Arrays.stream(resultArray).forEach(x -> System.out.println(x));
    }

    public static int[] getTopKFrequestElement(int[] intArray, int k){
        if(k< 1 || intArray.length <1) return new int[]{0};
        int[] resultArray = new int[k];

        HashMap<Integer, Integer> resultMap = new HashMap<>();
        for(int i = 0; i< intArray.length; i++){
            if(resultMap.containsKey(intArray[i])){
                resultMap.put(intArray[i],resultMap.get(intArray[i])+1);
            }else{
                resultMap.put(intArray[i],1);
            }
        }

        resultMap = resultMap.entrySet().stream().sorted(Map.Entry.<Integer,Integer>comparingByValue().reversed())
                .collect(Collectors.toMap
                        (Map.Entry::getKey,Map.Entry::getValue,
                                (e1,e2) ->e1, LinkedHashMap::new));

        Iterator<Integer> iterator = resultMap.keySet().iterator();

        for(int j=0; j<k ; j++ ){
            if(iterator.hasNext()){
                resultArray[j] = iterator.next();
            }
        }


        return resultArray;
    }
}
