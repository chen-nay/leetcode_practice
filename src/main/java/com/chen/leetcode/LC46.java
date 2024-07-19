package com.chen.leetcode;

import java.util.*;

/**
 * Created by zhoucy on 2024/7/19
 *
 * LC46、回溯
 * 关键在于剔除掉已经在路径path上的元素；暴力方案就是直接使用path.contains();
 *
 * 使用辅助数组，记录当前path是否已经有元素被使用
 **/


public class LC46 {

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    Set<Integer> pathSet = new HashSet<>();
    private boolean[] onPath;

    public List<List<Integer>> permute(int[] nums) {
        onPath = new boolean[nums.length];
        dfs(nums, nums[0]);

        return res;
    }

    public void dfs(int[] nums, int begin) {
        if (path.size() == nums.length) {
            res.add(new ArrayList(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {

            if (!onPath[i]) {
                path.add(nums[i]);
                onPath[i] = true;
                dfs(nums, nums[i]);
                path.removeLast();
                onPath[i] = false;
            }

        }
    }

}
