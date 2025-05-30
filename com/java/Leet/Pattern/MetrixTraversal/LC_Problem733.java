package com.java.Leet.Pattern.MetrixTraversal;

public class LC_Problem733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] visited = new int[image.length][image[0].length];
        for(int i=0; i< image.length; i++){
            for(int j=0; j<image[0].length; j++){
                if( sr == i && sc ==j ){
                    dfs(image, i, j, color,image[i][j], visited);
                }
            }
        }
        return image;
    }

    public void dfs(int[][] image, int i, int j, int color, int oldcolor, int[][] visited){

        if( i<0 || i >= image.length || j<0 || j >= image[0].length
                || image[i][j]!= oldcolor || visited[i][j] ==1){
            return;
        }
        visited[i][j] =1;
        image[i][j] = color;
        dfs(image,i-1,j,color,oldcolor,visited);
        dfs(image,i+1,j,color,oldcolor,visited);
        dfs(image,i,j-1,color,oldcolor,visited);
        dfs(image,i,j+1,color,oldcolor,visited);

        visited[i][j] =0;
    }
}
