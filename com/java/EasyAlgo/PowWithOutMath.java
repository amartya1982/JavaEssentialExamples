package com.java.EasyAlgo;

public class PowWithOutMath {
    public static void main(String args[]){
        System.out.println(calPow(2,10));
        System.out.println(power(2,10));
    }

    public static int  calPow(int number, int pow){
        int result =1;
        for(int i=1; i<= pow; i++){
            result = result  *number;
        }
        return result;
    }


    private static double power(double base, int exp) {
        if (exp == 0) return 1.0;

        double result = 1.0;
        double currentPower = base;

        while (exp > 0) {
            if (exp % 2 == 1) {
                result *= currentPower;
            }
            currentPower *= currentPower;
            exp /= 2;
        }

        return result;
    }
}
