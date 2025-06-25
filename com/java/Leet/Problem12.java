package com.java.Leet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem12 {

        public static void main(String args[]){
            System.out.println(intToRoman(1));
          //  System.out.println(getFirstDigitCal(912));

        }

    static int getFirstDigitCal(int num) {
        num = Math.abs(num); // handle negative numbers
        int count =0;
        while (num >= 10) {
            num /= 10;
            count++;
        }
        if(num ==4 || num ==9){
            num = num * (int) Math.pow(10, count);
        } else num =0;
        return num;
    }


    public static String intToRoman(int num) {
            StringBuffer st = new StringBuffer();
            int[] lt = new int[]{1,5,10,50,100,500,1000};

            HashMap<Integer, String> hm = new HashMap<>();
            hm.put(1,"I");hm.put(5,"V");hm.put(10,"X");hm.put(50,"L");
            hm.put(100,"C");hm.put(500,"D");hm.put(1000,"M");
            int num1 =0;
            HashMap<Integer, String> hm1 = new HashMap<>();
            hm1.put(4,"IV");hm1.put(9,"IX");hm1.put(40,"XL");hm1.put(90,"XC");
            hm1.put(400,"CD");hm1.put(900,"CM");

        while(num > 1) {
                for(int i =0; i<=lt.length-1; i++){

                    /**
                     * 4 (IV), 9 (IX), 40 (XL), 90 (XC), 400 (CD) and 900 (CM).
                     */
                    if(hm1.containsKey(getFirstDigitCal(num))){
                        st.append(hm1.get(getFirstDigitCal(num)));
                        num = num - getFirstDigitCal(num);
                        i=0;
                    }else if(lt[i] > num){
                        num = num - lt[i-1];
                        st.append(hm.get(lt[i-1]));
                        i=0;
                    }else if(lt[i] < num){
                        if(i+1 == lt.length){
                            num = num - lt[i];
                            st.append(hm.get(lt[i]));
                        }
                    }else if(lt[i] == num){
                        num = num - lt[i];
                        st.append(hm.get(lt[i]));
                    }

                    if(num ==0) break;
                }
            }
                return st.toString().equalsIgnoreCase("")?"I":st.toString();
            }

}
