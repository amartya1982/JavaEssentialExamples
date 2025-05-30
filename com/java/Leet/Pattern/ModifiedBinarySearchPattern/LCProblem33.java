package com.java.Leet.Pattern.ModifiedBinarySearchPattern;
//[4,5,6,7,0,1,2]
//Target 0
// answer should be 4 but use
//You must write an algorithm with O(log n) runtime complexity.
public class LCProblem33 {

    public static int search(int[] nums, int target) {

        int left =0;
        int right = nums.length-1;

        while(left <= right){
            int mid = left+right/2;
            if(nums[mid] == target){
                return mid;
            }

            if (nums[left] <= nums[mid]){
                if(nums[left] <= target && nums[mid] >= target) {
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else{
                if(nums[right] >= target && nums[mid] <= target){
                    left = mid +1;
                }else{
                    right = mid -1;
                }
            }
        }
        return -1;
    }


}
