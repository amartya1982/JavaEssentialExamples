package com.java.Leet.Pattern.SlidingWindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
**/
public class LC_Problem643 {

    public static void main(String args[]){
        System.out.println(findMaxAverage(new int[]{0,1,1,3,3},4));
       // System.out.println(findMaxAverage(new int[]{12},1));

    }

    public static int highestValue(int[] nums){
        return Arrays.stream(nums).max().orElseThrow();
    }
    public static double findMaxAverage(int[] nums, int k) {
        if(k ==1) return (double)highestValue(nums);
        double res = 0.0;
        int count=0;
        int sum =0;
        while (count+k <= nums.length ) {
            sum=0;
            for (int i = 0; i < k; i++) {
                sum = sum + nums[count + i];
            }
            count++;
            double middob = (double)sum/k;
            res = Math.max(res,middob);
        }

        return res;
    }
}
