package com.java.Leet.Pattern.DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class LCProblem113 {
    private List<List<Integer>> resultList = new ArrayList<List<Integer>>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null) return resultList;
        Stack<Integer> st = new Stack<>();
        preorder(root,targetSum,st);
        return resultList;
    }

    public void preorder(TreeNode root, int targetSum, Stack<Integer> path){
        path.push(root.val);
        if(root.left == null && root.right == null){
            if(targetSum == root.val) {
                resultList.add(new ArrayList<Integer>(path));
            }
        }
        if(root.left!=null) preorder(root.left,targetSum - root.val,path);
        if(root.right!=null) preorder(root.right,targetSum - root.val,path);
        path.pop();
    }
}