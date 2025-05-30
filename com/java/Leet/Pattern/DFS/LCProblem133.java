package com.java.Leet.Pattern.DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
public class LCProblem133 {
    HashMap<Node,Node> hm = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Node curr = new Node(node.val);
        hm.put(node, curr);
        for(Node newNode : node.neighbors){
            if(!hm.containsKey(newNode)) cloneGraph(newNode);
            curr.neighbors.add(hm.get(newNode));
        }
        return curr;
    }
}

