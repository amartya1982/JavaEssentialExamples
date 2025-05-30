package com.java.Leet.Pattern.BTReversal;
//Input: root = [3,1,4,null,2], k = 1
//Output: 1
// implement inorder traversal

import java.util.ArrayList;
import java.util.List;

public class LCProblem230 {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        return list.get(k-1);
    }

    public void inorder(TreeNode root, List<Integer> list){
        if(root==null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right,list);
    }
}
