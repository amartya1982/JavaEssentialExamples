import java.util.*;

public class QT1 {

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
    public static void main1(String args[]){
        PriorityQueue<Integer> pr = new PriorityQueue<>(Collections.reverseOrder());
        Deque<Integer> dq = new LinkedList<>();
        pr.add(3);
        pr.add(2);
        pr.add(1);
        pr.add(5);
        pr.add(6);
        pr.add(4);

        dq.add(10);
        dq.add(60);
        dq.add(15);


        while(pr.size()> 0){
            System.out.println(pr.peek());
        }
     //   System.out.print(pr.peek());
     //   System.out.print(pr.remove());
        Object[] arr = pr.toArray();
        //System.out.print(arr[arr.length-1]);
        //.    System.out.print(dq.peekLast());

        int x = findKthLargest(new int[]{3,2,1,5,6,4}, 2);

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] arrArray = new int[nums.length];
        int x=0;
        while(x<=nums.length-k){
            int[] newArray = new int[k];
            int count=0;
            for(int j=x; j<(x+k); j++){
                newArray[count] = nums[j];
                count++;
            }
            arrArray[x] = sortTheNumber(newArray);
            x++;
        }
        return arrArray;
    }

    static int sortTheNumber(int[] nums){
        PriorityQueue<Integer> pr = new PriorityQueue(Collections.reverseOrder());
        for(int k=0; k<nums.length; k++){
            pr.add(nums[k]);
        }
        return pr.peek();
    }

    public static void main(String args[]){
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));

        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(10);
        dq.add(60);
        dq.add(15);

        System.out.println(dq.peek());
        long[] S = new long[]{11, 6, 14};
        getMaxAdditionalDinersCount(15,2,3,S);
    }


    public static long getMaxAdditionalDinersCount(long N, long K, int M, long[] S) {
        // Write your code here
        int result = 0;
        // N is the totla number of seat
        int gap = (int)K;

        // step 1 : calculate the seat cover with S(loc ith) +K and S(loc ith) -K
        long[] totalSeatArray = new long[(int)N];

        for(int i=0; i< S.length; i++){
            int idex = (int)S[i] -1;
            totalSeatArray[idex] = 1;
            for(int x=1; x<=(int)K ; x++){
                if(idex+x<N)totalSeatArray[idex+x] = 2;
                if(idex-x>0)totalSeatArray[idex-x] = 2;
            }
        }
        for(int i=0; i<totalSeatArray.length; i++){
            if(totalSeatArray[i] ==0 ){
                if (i-gap> 0 && totalSeatArray[i-gap] == 2){
                    result++;
                    totalSeatArray[i] =1;
                }
                else if ( i-gap > 0 && totalSeatArray[i-gap] == 1){
                    result++;
                }
            }
        }

        return result;
    }
}
