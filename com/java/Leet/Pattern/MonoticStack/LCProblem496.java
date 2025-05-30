package com.java.Leet.Pattern.MonoticStack;

import java.util.Arrays;

// I solve this problem without MonoticStack
public class LCProblem496 {

    public static void main(String args[]){
        int[] num1 = new int[]{4,1,2};
        int[] num2 = new int[]{1,3,4,2};
        int[] result = nextGreaterElement(num1,num2);
        Arrays.stream(result).forEach(x -> System.out.println(x));
      //  System.out.print(Arrays.deepToString(result));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int[] result = new int[nums1.length];
            int x=0;
            boolean isPresent = false;
            for(int i=0; i< nums1.length; i++){
                int value = nums1[i];
                for(int j=0; j< nums2.length; j++){
                    isPresent=false;
                    if(nums2[j] == value){
                        for(int k=j+1; k <  nums2.length; k++){
                            if(nums2[k] > value){
                                result[x] = nums2[k];
                                x++;
                                isPresent = true;
                                break;
                            }
                        }
                        if(!isPresent) { result[x] = -1; x++; }
                    }
                }
            }
            return result;
    }
}
