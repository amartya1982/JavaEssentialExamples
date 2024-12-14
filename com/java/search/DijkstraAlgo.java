package com.java.search;

public class DijkstraAlgo{

    public static int minDistance(int dist[] ,boolean isVisited[] ){
        int min =Integer.MAX_VALUE;
        int index = -1;
        for(int i=0; i<5; i++){
            if(isVisited[i]==false && dist[i] <= min){
                min = dist[i];
                index =i;
            }
        }
        return index;
    }

    public static void printGraph(int dis[], int x){
        System.out.println("Distance from Source "+x+" to Destination : ");
        for(int i=0;i<5;i++){
            System.out.println(i+"-----"+dis[i]);
        }
    }

    public static void dijlstra(int[][] graph, int src){
        int dist[] = new int[5];
        boolean isVisited[] = new boolean[5];

        for(int i=0;i<5;i++){
            dist[i] = Integer.MAX_VALUE;
            isVisited[i] = false;
        }

        dist[0] =0;
        for(int i=0;i<5;i++){
            int u = minDistance(dist,isVisited);
            isVisited[u] = true;
            for(int j=0;j<5;j++){
                if(!isVisited[j] && graph[u][j]!=0 && dist[u]!= Integer.MAX_VALUE && dist[u]+graph[u][j]<dist[j]){
                    dist[j] = dist[u]+graph[u][j];
                }
            }
            printGraph(dist,src);
        }

    }
    public static void main(String args[]){
        int[][] graph = new int[][]
                {
                        {0,4,0,0,7},
                        {4,0,1,2,0},
                        {0,1,0,6,0},
                        {0,2,6,0,0},
                        {7,0,0,0,0}
                };
        dijlstra(graph,0);

    }
}