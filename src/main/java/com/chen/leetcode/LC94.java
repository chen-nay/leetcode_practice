package com.chen.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhoucy on 2024/7/15
 * LC94
 * 二叉树，二叉搜索树，中序遍历
 **/


public class LC94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        // 递归终止条件
        if(root == null) {
            return;
        }
        // 中序遍历，就是左根右
        // 前序，根左右
        // 后序，左右根
        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);

    }



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

}
