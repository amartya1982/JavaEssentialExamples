package com.java.Leet.Pattern.MonoticStack;

import java.util.Arrays;
import java.util.Stack;

// again this solution is not with Monotic Stack
public class LCProblem739 {

    public static void main(String args[]){
        Arrays.stream(dailyTemperatures(new int[]{30,60,90})).forEach( x -> System.out.print(x));
    }
    public static int[] dailyTemperatures(int[] temperatures) {
        int[]  result = new int[temperatures.length];
        Stack<Integer> st = new Stack();

        for(int i = temperatures.length-1; i>=0; i--){
            while(!st.empty() && temperatures[st.peek()]<= temperatures[i]){
                st.pop();
            }
            if(!st.empty()){
                result[i] = st.peek() -i;
            }else{
                result[i] = 0;
            }

            st.push(i);
        }
        return result;
    }


    public static int[] dailyTemperatures1(int[] temperatures) {
        int[] result = new int[temperatures.length];
        for(int i=0; i< temperatures.length; i++){
            int count =0;
          //  boolean isthere = false;
            for(int j =i+1, k=0; j < temperatures.length; j++,k++){
                if(temperatures[j] > temperatures[i]){
            //        isthere = true;
                    count ++;
                    break;
                }
                if(j+1 != temperatures.length) count++;
            }
            result[i] = count;
        }
        return result;
    }
}
