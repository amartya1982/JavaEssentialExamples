package com.java.Leet.Pattern.BTReversal;

import java.util.ArrayList;
import java.util.List;

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
public class LC_Problem257 {
    public List<String> binaryTreePaths(TreeNode root) {
            List<String> strArray = new ArrayList<>();
            String st = "";
            preorder(root, strArray, st);
            return strArray;
    }

    public static void preorder(TreeNode root, List<String> strArray, String st){
        if(root == null) return;
        st = st+Integer.toString(root.val);
        if(root.left == null && root.right ==null)
            strArray.add(st);

        preorder(root.left, strArray,st +"->");
        preorder(root.right, strArray,st +"->");
    }

}
