package com.java.Leet;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
/*
try with these test case which is not matching
[1,9,9,9,9,9,9,9,9,9]
[9]
*/
import java.util.Stack;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class LC_Problem2 {
        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Stack<Integer> st = new Stack();
            int count =0;
            while(l1!=null){
                st.push(l1.val);
                count++;
                l1 = l1.next;
            }
            count = count-1;
            int first_number =0;
            while(!st.empty()&& count > -1){
                first_number = first_number + (st.pop() * (int) Math.pow(10,count));
                count--;
            }

            Stack<Integer> st1 = new Stack();
            count =0;
            while(l2!=null){
                st1.push(l2.val);
                count++;
                l2 = l2.next;
            }

            int second_number =0;
            count = count-1;

            while(!st1.empty()&& count > -1){
                second_number = second_number + (st1.pop() * (int) Math.pow(10,count));
                count--;
            }

            int finalnumber = first_number + second_number;
            ListNode head = null;
            Stack<Integer> finalStack = new Stack();

            while (finalnumber > 0){
                int last_number = finalnumber%10;
                finalStack.push(last_number);
            //    ListNode result = new ListNode();
            //    result.val = last_number;
            //    result.next = head;
             //   head = result;
                finalnumber = finalnumber/10;
            }

            while(!finalStack.empty()){
                ListNode result = new ListNode();
                result.val = finalStack.pop();
                result.next = head;
                head = result;
            }
            return head;
        }

        public static void main(String args[]) {
            ListNode first = new ListNode(2);
            ListNode second = new ListNode(4);
            ListNode third = new ListNode(3);
            first.next = second;
            second.next = third;

            ListNode first1 = new ListNode(5);
            ListNode second1 = new ListNode(6);
            ListNode third1 = new ListNode(4);
            first1.next = second1;
            second1.next = third1;

            ListNode nodeResult = addTwoNumbers(first,first1);

            int Value = 12345;
            ListNode head = null;
            while(Value > 0){
                ListNode newNode = new ListNode();
                newNode.val = Value%10;
                newNode.next = head;
                head = newNode;
                Value = Value/10;
            }
            while(head!=null){
                int vale = head.val;
                System.out.print(vale);
                if(head.next!=null) System.out.print("->");
                head = head.next;

            }
            System.out.println("");


            while(nodeResult!=null){
                int val = nodeResult.val;
                System.out.print(val);
                if(nodeResult.next!=null) System.out.print( " ->");
                nodeResult = nodeResult.next;
            }
        }

}
