package com.chen.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhoucy on 2024/7/18
 * LC77、组合、回溯
 **/


public class LC77 {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int pathSize=0;

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);

        return result;
    }

    // n 是树的宽度；k 是树的高度；path是遍历的时候的状态变量，纵深的节点
    public void backtracking(int n, int k, int startIndex) {
        // DFS的结束条件
        if (pathSize == k) {
            result.add(new ArrayList(path));
            return;
        }

        if (((n - startIndex) + pathSize+1) < k) {
            return;
        }

        // 开for循环，就是往下一层，也即，递归一次
        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            pathSize++;
            backtracking(n, k, i + 1);
            path.removeLast();
            pathSize--;
        }
    }

}
