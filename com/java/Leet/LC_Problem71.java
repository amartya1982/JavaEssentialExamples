package com.java.Leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class LC_Problem71 {
    public static String simplifyPath(String path) {
       // path ="/home/";
        Stack<String> st = new Stack();

        String[] str = path.split("/");

       // System.out.print(Arrays.deepToString(str));
        st.push("/");
        for(int i =1; i<str.length-1; i++){
            if(str[i].equals("..") && !st.empty()){
                st.pop(); st.pop();
            }else if(str[i]==""){
                continue;
            }
            else{
                st.push(str[i]);st.push("/");
            }
            //i++;
        }
        st.push(str[str.length-1]);

        return st.stream()
                .map(Object::toString)
                .collect(Collectors.joining());
    }

    public static void main(String args[]){
        //System.out.print(simplifyPath("/home/user/Documents/../Pictures"));
        Stack st = new Stack();
        st.push("HI");
        st.push("Name");
        st.push("is");
        st.push("Amartya");
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.insert(0, "/"+st.pop());
            //System.out.print(st.pop());
        }

        System.out.print(sb.toString());

    }

    // problem 54 ///
    public List<Integer> spiralOrder(int[][] matrix) {
        //int row = matrix.length;
        //int col = matrix[0].length;
        List<Integer> listint = new ArrayList<>();
        int[][] visited = new int[matrix.length][matrix[0].length];
        //listint.add(matrix[0][0]);
        dfs(matrix, 0, 0, listint, visited, false);
        return listint;
    }

    static void dfs(int[][] matrix, int row, int col, List<Integer> integerList,
                    int[][] visited, boolean goingup){
        if((row > matrix.length || row < 0) || (col> matrix[0].length || col <0) || visited[row][col] ==1){
            return;
        }
        visited[row][col] =1;
        integerList.add(matrix[row][col]);

        if(goingup){
            dfs(matrix,row-1,col,integerList,visited,true);
        }
        dfs(matrix,row,col+1,integerList,visited, false);
        dfs(matrix,row+1,col,integerList,visited, false);
        dfs(matrix,row,col-1,integerList,visited, false);
        dfs(matrix,row-1,col,integerList,visited, true);

    }
}
