package com.java.Leet;

public class Atoi {
    public static void main(String args[]){
        System.out.println(sol("32"));
    }

    static int sol(String s){
        StringBuffer result = new StringBuffer();
        char[] charArray = s.toCharArray();
        for(int i=0; i<charArray.length; i++){
           if(charArray[i] != ' ' && result.isEmpty()){
                if(charArray[i] == '-'){
                    result.append(charArray[i]);
                }else if (!Character.isDigit(charArray[i])){
                    break;
                }
           }else if (Character.isDigit(charArray[i])){
               result.append(charArray[i]);
           }else if(!Character.isDigit(charArray[i])){
               break;
           }
        }
        return Integer.parseInt(result.toString());
    }
}
