package com.java;
import java.util.*;

public class QuickTest {


    public static void main(String[] args){
       // System.out.println(findKthLargest(new int[]{3,2,1,5,6,4}, 2));
      //  System.out.println(groupAnagrams(
      //          new String[]{"eat","tea","tan","ate","nat","bat"}));
      //  System.out.println(""+367%10);
        int[][] result = generateMatrix(3);
        System.out.print(Arrays.deepToString(result));
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pr = new PriorityQueue<>();
        for(int i=0; i< nums.length; i++){
            pr.add(nums[i]);
            if(pr.size() > k){
                pr.remove();
            }
        }
        return pr.remove();
    }
    public static int subarraySum(int[] nums, int k) {
        int result =0;
        int count =0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            hm.put(i, nums[i]);
        }


  /*      for(Map.Entry<Integer,Integer> ele : hm.entrySet() ){
            if(ele.getValue() == k){
                count++;
                result = result - ele.getValue();;
            }
            if((ele.getKey() < k)){
                result = result + ele.getValue();
                if (result == k){
                    count++;
                    result = result - ele.getValue();
                }
            }

        }*/
        for(Map.Entry<Integer,Integer> ele : hm.entrySet() ){
            if(ele.getValue() < k){
                int newSearch = k - ele.getValue();
                for(Map.Entry<Integer,Integer> ele1 : hm.entrySet() ){

                }
            }else if(ele.getValue() ==k){
                count++;
            }
        }

        return count;
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> hm1HashMap = new HashMap<>();

        for(int i=0; i< strs.length; i++){
            String str1 = strs[i];
            char[] charArray = str1.toCharArray();
            Arrays.sort(charArray);
            if(hm1HashMap.containsKey(String.copyValueOf(charArray))){
                hm1HashMap.get(String.copyValueOf(charArray)).add(str1);
            }else{
                List<String> strList = new ArrayList<>();
                strList.add(str1);
                hm1HashMap.put(String.copyValueOf(charArray), strList);
            }
        }

        List<List<String>> answerList = new ArrayList<>();
        for(Map.Entry<String,List<String>> elemenet : hm1HashMap.entrySet()){
            answerList.add(elemenet.getValue());
        }
        return answerList;
    }
    public static int subarraySum1(int[] arr, int K) {
        int sum = 0;
        int count =0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for(int i=0; i<arr.length; i++){
            sum = sum + arr[i];

            count += map.getOrDefault(sum-K, 0);

            map.put(sum, map.getOrDefault(sum, 0)+1);
        }

        return count;
    }

    public static int[][] generateMatrix(int n) {

        int[][] result = new int[n][n];
        int[][] isCovered = new int[n][n];
        ArrayList<Integer> intList = new ArrayList<>();
        dfs(intList, 0,0,isCovered,1, false,n);
        int i=0;
        //for(int i=0; i<intLits.size(); i++){
        for(int x =0 ; x<n; x++){
            for( int y=0; y<n; y++){
                result[x][y] = intList.get(i);
                i++;
            }
        }

        //}
        return result;
    }
public static void dfs(ArrayList matrix, int i, int j, int[][] visited, int value, boolean isUpwards,
                        int n){
        if(i<0 || i >= n || j< 0 || j >= n || visited[i][j] ==1)
        {
            return;
        }
        matrix.add(value);
        value++;
        visited[i][j] =1;
        if(isUpwards){
            dfs(matrix,i-1,j,visited, value,true,n);
        }

        dfs(matrix,i,j+1,visited, value,true,n);
        dfs(matrix,i+1,j,visited, value,true,n);
        dfs(matrix,i,j-1,visited, value,true,n);
        dfs(matrix,i-1,j,visited, value,true,n);
        // dfs(matrix,i,j+1,intArray,intArray1);

    }
}
