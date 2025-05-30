package com.java.Leet.Pattern.FastAndSlowPointer;

 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }
public class LCProblem141 {
    public boolean hasCycle(ListNode head) {
        ListNode slow,fast;
        slow = head;
        fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }
}
