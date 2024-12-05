package com.java.search;

import java.util.*;

/**
 * Problem: Find the shortest path in an unweighted graph from a given starting node to all other nodes.
 *     Graph:
 *     0 -- 1 -- 3
 *     |    |
 *     2    4
 * Adjacency list representation:
        0: [1, 2]
        1: [0, 3, 4]
        2: [0]
        3: [1]
        4: [1]

     BFS Algorithm:
     Use a Queue to explore nodes level by level.
     Mark each node as visited when it's added to the queue.
     Track distances from the starting node using an array.

 **/

public class BFS {
    public static void main(String[] args) {
        // Create a graph using an adjacency list
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(0, 3, 4));
        graph.put(2, Arrays.asList(0));
        graph.put(3, Arrays.asList(1));
        graph.put(4, Arrays.asList(1));

        // Start BFS from node 0
        bfsAlgo(graph, 0);
    }

    public static void bfsAlgo(Map<Integer, List<Integer>> graph, int start) {
        Set<Integer> visitedArray = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> distant = new HashMap<>();

        queue.add(start);
        visitedArray.add(start);
        distant.put(start,0);

        while(!queue.isEmpty()){
            int current = queue.poll();
            System.out.println("Visiting node: " + current);
            for(int neighbor : graph.get(current)){
                if(!visitedArray.contains(neighbor)){
                    visitedArray.add(neighbor);
                    queue.add(neighbor);
                    distant.put(neighbor, distant.get(current)+1);
                }
            }
        }

        System.out.println("\nShortest distances from node " + start + ":");
        distant.forEach((k,v) -> System.out.println("Node " +k + ": " +v));

    }
}
