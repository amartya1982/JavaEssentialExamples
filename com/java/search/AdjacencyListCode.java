package com.java.search;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;

class Node{
    char data;
    Node(char data){
        this.data = data;
    }
}

class Graph{
    ArrayList<LinkedList<Node>> adjList;
    public Graph(){
        adjList = new ArrayList<>();
    }

    public void addNode(Node node){
        LinkedList<Node> linkNode = new LinkedList<>();
        linkNode.add(node);
        adjList.add(linkNode);
    }

    public void addEdge(int src, int dest){
        LinkedList<Node> currentNode = adjList.get(src);
        Node destNode = adjList.get(dest).get(0);
        currentNode.add(destNode);
    }

    public boolean checkEdge(int src , int dest){
        LinkedList<Node> currentList = adjList.get(src);
        Node destNode = adjList.get(dest).get(0);

        for(Node node : currentList){
            if(node == destNode){
                return true;
            }
        }
        return false;
    }

    public void printGraph(){
        for(LinkedList<Node> nodeList : adjList){
            for(Node node : nodeList){
                System.out.print(node.data + " -> ");
            }
            System.out.println();
        }
    }
}

public class AdjacencyListCode {

    public static void main(String args[]){
        Graph gh = new Graph();
        gh.addNode(new Node('A'));  // index 1
        gh.addNode(new Node('B'));  // index 2
        gh.addNode(new Node('C'));  // index 3
        gh.addNode(new Node('D'));  // index 4
        gh.addNode(new Node('E'));  // index 5

        gh.addEdge(0,1); // A -> B
        gh.addEdge(1,2); // B -> C
        gh.addEdge(1,4); // B -> E
        gh.addEdge(2,3); // C -> D
        gh.addEdge(2,4); // C -> E
        gh.addEdge(4,0); // E -> A
        gh.addEdge(4,2); // E -> C

        gh.printGraph();

    }
}
