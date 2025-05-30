package com.java.Leet.Pattern.LinkedListReversal;

  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class LC_Problem206 {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr;
        curr = head;
        while(curr !=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }


}
