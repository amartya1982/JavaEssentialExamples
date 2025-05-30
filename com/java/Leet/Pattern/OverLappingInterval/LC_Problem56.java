package com.java.Leet.Pattern.OverLappingInterval;

import java.util.Arrays;

//[[1,3],[2,6],[8,10],[15,18]]
public class LC_Problem56 {

    public static void main (String args[]){
        int[][] arr = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };

        System.out.println(Arrays.deepToString(arr));
        System.out.println("------------ After run -----------");

        System.out.println(Arrays.deepToString(merge(arr)));
    }

    public static int[][] merge(int[][] intervals) {
        int k=0;
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        for(int i=1; i< intervals.length; i++){
            if( intervals[k][1] >= intervals[i][0]){
                intervals[k][1] = Math.max(intervals[k][1],intervals[i][1]);
            }else{
                k++;
                intervals[k] = intervals[i];
            }
        }
        return Arrays.copyOfRange(intervals,0, k+1 );
    }

}
