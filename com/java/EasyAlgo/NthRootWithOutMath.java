package com.java.EasyAlgo;

public class NthRootWithOutMath {
    public static void main(String[] args) {
        // Test cases
        System.out.println(nthRootCal(8,3));
    }
    public static double nthRootCal(double number, int base){
        double result =1;
        double low =0;
        double high = number;
        double prec = 1e-10;
        while( (high-low) > prec){
            double mid = (high + low)/2;
            double midval = powCal(mid,base);
            if(midval < number){
                low = mid;
            }else{
                high = mid;
            }
        }
        return (high+low)/2;
    }

    public static double powCal(double number, int base){
        double result =1;
        for(int i=1; i<=base; i++){
            result = result*number;
        }
        return result;
    }

    public static double nthRoot(double number, int n) {
        if (n == 0) return 1;
        if (n == 1) return number;
        if (number == 0) return 0;

        // Handle negative numbers
        boolean isNegative = false;
        if (number < 0) {
            if (n % 2 == 0) {
                throw new IllegalArgumentException("Even root of negative number");
            }
            isNegative = true;
            number = -number;
        }

        double precision = 1e-9; // 9 decimal places precision
        double low = 0;
        double high = number > 1 ? number : 1;

        while (high - low > precision) {
            double mid = (low + high) / 2.0;
            double midPowerN = powCal(mid, n);

            if (midPowerN < number) {
                low = mid;
            } else {
                high = mid;
            }
        }

        double result = (low + high) / 2.0;
        return isNegative ? -result : result;
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
