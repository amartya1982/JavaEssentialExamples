package com.java.Leet.Pattern.TopKElement;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LCProblem347 {

    public static void main(String args[]){
        Arrays.stream(
                topKFrequent(
                        new int[]{1,1,1,2,2,3}, 2)
        ).forEach(x-> System.out.print(x));
    }
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] result = new int[k];

        for(int i=0; i< nums.length; i++){
            if(hm.containsKey(nums[i])){
                int count = hm.get(nums[i]);
                hm.put(nums[i], count+1);
            }else{
                hm.put(nums[i],1);
            }
        }
        Map<Integer, Integer> sortedMap = hm.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, // in case of duplicates (not likely in this context)
                        LinkedHashMap::new // maintain insertion (sorted) order
                ));
        int i =0;

        for(Map.Entry<Integer,Integer> data : sortedMap.entrySet()){
            if(i<k) {
                result[i] = data.getKey();
            }
            i++;
        }

        return result;
    }
}
