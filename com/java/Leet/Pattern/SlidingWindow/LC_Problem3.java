package com.java.Leet.Pattern.SlidingWindow;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class LC_Problem3 {

    public static void main(String args[]){
        String s = "pwwkew";
        System.out.print(" The answer is "+lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();
        int left =0;
        int right =0;
        int result =0;

        while(right < s.length()){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                result = Math.max(result, right-left+1);
                right++;
            }else{
                set.remove(s.charAt(left));
                left ++;
            }
        }
        return result;
    }
}
