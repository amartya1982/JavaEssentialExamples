package com.java.stackAndqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Problem Statement: Write a program to check if a given string is a palindrome using a stack and queue.
 *
 * Example:
 *
 * Input: "madam"
 * Output: true
 */
public class PalindromeCheck {
    public static void main(String args[]){
        String str = "madam";
        if(checkPalindram(str)) System.out.println("yes this is a palindram");
        else System.out.println("NO this NOT a palindram");
    }
    public static boolean checkPalindram(String input){
        char[] charArr = input.toCharArray();
        Stack<Character> stackOP = new Stack<>();
        Queue<Character> queueOP = new LinkedList<>();

        for(char ch : input.toCharArray()){
            stackOP.push(ch);
            queueOP.offer(ch);
        }
        while(!stackOP.empty()){
            if(stackOP.pop() != queueOP.poll()){
                return false;
            }
        }
        return true;
    }
}
