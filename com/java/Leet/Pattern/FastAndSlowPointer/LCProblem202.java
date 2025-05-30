package com.java.Leet.Pattern.FastAndSlowPointer;

import java.util.ArrayList;
import java.util.List;

public class LCProblem202 {

    public static void main(String args[]){
        System.out.println(isHappy(7));
    }

    static int sumAdd(List<Integer> arrList){
        return arrList.stream().mapToInt(n -> n * n).sum();
    }
    public static boolean isHappy(int n) {
        if(n == 1) return true;
    //     if(n < 10) return false;
        ArrayList<Integer> arrInt = new ArrayList<>();

        while(n > 1){
            arrInt = new ArrayList<>();
            int x = n%10;  // 9
            arrInt.add(x);
            if(n/10 < 10)
                arrInt.add(n/10);
            else {
                n = n/10;
                while(n > 9){
                    arrInt.add(n%10);
                    n = n/10;
                }
                arrInt.add(n);
            }
            n = sumAdd(arrInt);
            if(n==1) return true;
        }
        return false;
    }
}
