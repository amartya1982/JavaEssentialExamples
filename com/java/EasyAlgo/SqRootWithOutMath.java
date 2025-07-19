package com.java.EasyAlgo;

public class SqRootWithOutMath {
    public static void main(String args[]){
        System.out.println(sqareRootNumber(100));
    }


    static double sqareRootNumber(double number){
        double high = number;
        double low =0;

        double precession = 1e-10;
        double mid;

    /*    while( (high - low) > precession){
            mid = (high+low)/2;
            if(mid * mid > number){
                high = mid;
            }else{
                low = mid;
            }
        }*/

        while ((high - low) > precession) {
            mid = (low + high) / 2;
            if (mid * mid > number) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return (high+low)/2;
    }

        public static double squareRoot(double number) {
            if (number < 0) {
                throw new IllegalArgumentException("Negative number cannot have real square root");
            }
            if (number == 0 || number == 1) {
                return number;
            }

            double low = 0;
            double high = number;
            double mid;

            // For numbers less than 1 (like 0.04), high should be 1
            if (number < 1) {
                high = 1;
            }

            double precision = 1e-6;

            while ((high - low) > precision) {
                mid = (low + high) / 2;
                if (mid * mid > number) {
                    high = mid;
                } else {
                    low = mid;
                }
            }

            return (low + high) / 2;
        }



}
