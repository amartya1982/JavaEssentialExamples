package com.java.EasyAlgo;


import java.util.LinkedList;

class Node {

    Node next;
    int value;

    Node(int value) {
        this.value = value;
        this.next = null;
    }
}

 class CustomLinkedList{

    CustomLinkedList(){

    }
    Node head;
    public void insert(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node curr = head;
        while(curr.next !=null){
            curr = curr.next;
        }
        curr.next = newNode;
    }

    public void delete(int data){
        if(head==null) return;

        if(head.value == data){
            head = head.next;
            return;
        }
        Node curr = head;
        if(curr.next !=null && curr.next.value != data){
            curr = curr.next;
        }

        if(curr.next !=null){
            curr.next = curr.next.next;
        }
    }

    public void display(){
        Node curr = head;
        while(curr !=null){
            System.out.print(curr.value + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public void reverse(){
        Node next_node = null;
        Node prev_node = null;
        while(head != null){
            next_node = head.next;
            head.next = prev_node;
            prev_node = head;
            head = next_node;
        }
        head = prev_node;
    }
}
public class ReverseLinkedList {
    public static void main(String args[]){
        CustomLinkedList list1 = new CustomLinkedList();
        list1.insert(10);
        list1.insert(20);
        list1.insert(30);
        list1.display();
        System.out.println("Doing it");
        list1.reverse();
        list1.display();
    }
}
