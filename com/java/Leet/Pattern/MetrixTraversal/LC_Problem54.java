package com.java.Leet.Pattern.MetrixTraversal;

import java.util.ArrayList;
import java.util.List;

public class LC_Problem54 {

    public static void main(String args[]){
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(spiralOrder(matrix));

    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> intArray = new ArrayList<>();
        int[][] visited = new int[matrix.length][matrix[0].length];

      /*  intArray.add(matrix[0][0]);
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j< matrix[0].length; j++){
                dfs(matrix, i, j, intArray, visited,false);
            }
        }*/
        dfs(matrix, 0, 0, intArray, visited,false);
        return intArray;
    }

    public static void dfs(int[][] matrix, int i, int j, List<Integer> intArray,int[][] visited ,boolean goingup){
        if(i<0 || i >= matrix.length || j< 0 || j >= matrix[0].length ||
                visited[i][j] ==1)
        {
            return;
        }
        intArray.add(matrix[i][j]);
        visited[i][j] =1;
        if(goingup){
            dfs(matrix,i-1,j,intArray,visited, true);
        }

        dfs(matrix,i,j+1,intArray,visited,false);
        dfs(matrix,i+1,j,intArray,visited,false);
        dfs(matrix,i,j-1,intArray,visited,false);
        dfs(matrix,i-1,j,intArray,visited,true);
        // dfs(matrix,i,j+1,intArray,intArray1);

    }
}
