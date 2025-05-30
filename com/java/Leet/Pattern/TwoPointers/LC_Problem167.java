package com.java.Leet.Pattern.TwoPointers;

public class LC_Problem167 {

    public int[] twoSum(int[] numbers, int target) {

        int i=0;
        int j = numbers.length -1;

        while(i<j){
            int total = numbers[i]+numbers[j];
            if(target == total){
                return new int[]{i+1,j+1};
            } else if (total > target){
                j--;
            }else{
                i++;
            }
        }
        return new int[]{-1,-1};
    }
}
