package com.java.DoubleLinkedList;

class DoubleLinkedLList{
    Node head;
    Node tail;
    class Node{
        Node prev;
        Node next;
        int data;
        Node(int data){
            this.prev = null;
            this.next = null;
            this.data = data;
        }
    }
    DoubleLinkedLList(){
        head = null;
        tail = null;
    }

    public void append(int data){
        Node newNode = new Node(data);
        if(head == null){
            head=newNode;
            tail=newNode;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void prepend(int data){
        Node newNode = new Node(data);
        if(head ==null){
            head = newNode;
            tail = newNode;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void printLinkedList(){
        Node current = head;
        while(head != null){
            System.out.println(head.data);
            head = head.next;
        }
    }
}

public class DoubleLinkedListExample {

}
