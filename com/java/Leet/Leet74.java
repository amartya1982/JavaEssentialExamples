package com.java.Leet;

public class Leet74 {
    public static boolean searchMatrix(int[][] matrix, int target) {
            boolean isPresent = false;
            int row = matrix.length;
            int col = matrix[0].length;
            int low =0;
            int high = row*col -1;
            while(low <= high){
                int mid = (high + low)/2;
                if(matrix[mid/col][mid%col]== target){
                    return true;
                }else if (matrix[mid/col][mid%col] < target){
                    low = mid +1;
                }else if (matrix[mid/col][mid%col] > target){
                    high = mid -1;
                }
            }
            return isPresent;
    }


    public static void main(String agrs[]){
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        System.out.println(searchMatrix(matrix, 3));
    }
}
