package com.java.search;

import java.util.*;

/**
 * Problem: Perform DFS on an unweighted graph represented using an adjacency list, starting from a given node.
 *     0 -- 1 -- 3
 *     |    |
 *     2    4
 *
 * DFS Algorithm:
 * Use recursion or a stack to explore as deeply as possible before backtracking.
 * Keep track of visited nodes to avoid revisiting.
 */
public class DFS {
    public static void main(String args[]){

        // Create a graph using an adjacency list
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(0, 3, 4));
        graph.put(2, Arrays.asList(0));
        graph.put(3, Arrays.asList(1));
        graph.put(4, Arrays.asList(1));

        // Create a set to keep track of visited nodes
        Set<Integer> visited = new HashSet<>();

        // Start DFS from node 0
        System.out.println("DFS Traversal:");
        dfsAlgorithm(graph, 0, visited);

    }

    public static void dfsAlgorithm(Map<Integer, List<Integer>> graph, int node, Set<Integer> visited){

        if(visited.contains(node)){
            return;
        }
        // Mark the current node as visited and print it
        visited.add(node);
        System.out.println("Visited node: " + node);

        for(int neighbour : graph.get(node)){
            if(!visited.contains(neighbour)){
                dfsAlgorithm(graph,neighbour,visited);
            }
        }
    }
}
