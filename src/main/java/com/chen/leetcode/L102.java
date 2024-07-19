package com.chen.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
   Created by zhoucy on 2024/7/15
    LC102
   二叉树
   层序遍历，且需要记录每一个层
   ***/


public class L102 {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> levelNode = new LinkedList<>();

        if (root != null)
            levelNode.add(root);

        while (!levelNode.isEmpty()) {
            // 开始遍历这一层的元素 开辟临时queue
            List<Integer> temp = new LinkedList<>();
            // 因为一边从levelNode里面取元素，一边又往里面放元素，所以快照当前层的元素个数
            int currentLevelNodeSize = levelNode.size();
            for (int i = 0; i < currentLevelNodeSize; i++) {
                TreeNode node = levelNode.poll();
                temp.add(node.val);
                if (node.left != null)
                    levelNode.add(node.left);
                if (node.right != null)
                    levelNode.add(node.right);
            }
            result.add(temp);
        }

        return result;

    }

    public class TreeNode {
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
