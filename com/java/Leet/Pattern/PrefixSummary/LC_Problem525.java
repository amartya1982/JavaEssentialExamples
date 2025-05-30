package com.java.Leet.Pattern.PrefixSummary;

import java.util.HashMap;

public class LC_Problem525 {

    public static void main(String args[]){
        System.out.println(findMaxLength(new int[]{0,1,0}));
    }

    public static int findMaxLength(int[] nums) {
        int result =0;
        int ans=0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0,-1);
        for(int i=0; i< nums.length; i++){
            if(nums[i] == 1){
                result++;
            }else{
                result--;
            }
            if(hm.containsKey(result)){
                ans = Math.max(ans, i- hm.get(result));
            }else {
                hm.put(result, i);
            }
        }
        return ans;
    }
}
