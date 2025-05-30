package com.java.Leet.Pattern.DoubleLinkedList;

import java.util.*;

//Input: list1 = [1,2,4], list2 = [1,3,4]
//Output: [1,1,2,3,4,4]
 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; this.next =null;}
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      void addNode(ListNode head, int value){
          ListNode curr = head;
          while(curr.next!=null){
              curr = curr.next;
          }
          curr.next = new ListNode(value);

      }
 }
public class LCProblem21 {

     public static void main(String args[]){
         ListNode l1 = new ListNode(1);
         l1.addNode(l1,2);
         l1.addNode(l1,4);
         ListNode l2 = new ListNode(1);
         l2.addNode(l2,3);
         l2.addNode(l2,4);
        mergeTwoLists(l1,l2);
     }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        List<Integer> hs = new ArrayList<>();
        while(list1!=null && list1.next!=null ){
            hs.add(list1.val);
            list1= list1.next;
        }

        hs.add(list1.val);
        while(list2!=null && list2.next!=null ){
            hs.add(list2.val);
            list2 = list2.next;
        }
        hs.add(list2.val);
        Collections.sort(hs);
        ListNode ns = new ListNode(hs.get(0));

        for(int i=1; i< hs.size();i++){
            ListNode curr = ns;
            while(curr.next!=null){
                curr = curr.next;
            }
            curr.next = new ListNode(hs.get(i));
            //ns.addNode(ns,hs.get(i));
        }
        return ns;
    }

 }
