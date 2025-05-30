package com.java.Leet.Pattern.OverLappingInterval;

import java.util.Arrays;

public class LC_Problem435 {
    public static void main (String args[]){
        int[][] arr = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };

        System.out.println(Arrays.deepToString(arr));
        System.out.println("------------ After run -----------");

        System.out.println(eraseOverlapIntervals(arr));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int prev = 0;
        int cnt = 1;

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= intervals[prev][1]) {
                prev = i;
                cnt++;
            }
        }

        return n - cnt;
    }
}
