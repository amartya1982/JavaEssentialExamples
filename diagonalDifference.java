import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.joining;

class Result {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
        int right3Left =0;
        int left2right =0;
        for(int i=0; i< arr.size(); i++){
            for(int j=i; j< arr.get(i).size();j++){
                left2right+=arr.get(i).get(i);
                break;
            }
        }
        for(int i=0; i< arr.size(); i++){
            for(int j=(arr.size()-1)-i; j >= 0;j--){
                right3Left+=arr.get(i).get(j);
                break;
            }
        }
        return Math.abs(right3Left - left2right);
    }

}

 class Solution {
    public static void main(String[] args) throws IOException {


        List<List<Integer>> arr = new ArrayList<>();
        arr.add(Arrays.asList(11, 2, 4));
        arr.add(Arrays.asList(4, 5, 6));
        arr.add(Arrays.asList(10, 8, -12));
        int result = Result.diagonalDifference(arr);
        System.out.println(result);
    }
}
