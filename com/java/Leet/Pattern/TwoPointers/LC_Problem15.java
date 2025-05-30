package com.java.Leet.Pattern.TwoPointers;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_Problem15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for(int i =0; i < nums.length; i++){

            int j = i+1;
            int k = nums.length -1;
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum > 0 ){
                    k--;
                }else if (sum < 0){
                    j++;
                }else{
                    result.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    while(nums[j] == nums[j-1] && j< k){
                        j++;
                    }
                }
            }
        }
        return result;
    }
}
