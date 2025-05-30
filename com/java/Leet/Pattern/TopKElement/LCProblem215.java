package com.java.Leet.Pattern.TopKElement;

import java.util.PriorityQueue;

public class LCProblem215 {

    public static void main(String args[]){
        String s = "pwwkew";
        System.out.print(" The answer is "+findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},4));
    }
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i< nums.length; i++){
            pq.add(nums[i]);
            if(pq.size() > k){
                pq.remove();
            }
        }
        return pq.remove();
    }
}