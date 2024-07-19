package com.chen.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chen on 2024/7/13
 * LC84
 * # 双指针、单调栈
 * 对比 接雨水LC42
 **/

public class LC84 {



    /***
     * 暴力法是对的，但是超时间限制了；往左边枚举，往右边枚举，那2个while循环是套路
     * */
    public int largestRectangleArea(int[] heights) {

        int leftCount = 0;
        int rightCount = 0;
        int area = heights[0];
        for (int i = 0; i < heights.length; i++) {
            leftCount = 0;
            rightCount = 0;
            int index = i;
            // 左枚举
            while (index > 0) {
                index--;
                if (heights[index] >= heights[i]) {
                    leftCount++;
                } else {
                    break;
                }
            }
            // 右枚举
            index = i;
            while (index < heights.length - 1) {
                index++;
                if (heights[index] >= heights[i]) {
                    rightCount++;
                } else {
                    break;
                }
            }
            // 计算面积
            area = Math.max(area, heights[i] * (leftCount + rightCount + 1));

        }

        return area;
    }

    public static String getSmallestString(String s) {
        char[] cs = s.toCharArray();
        for (int i = 0; i<s.length()-1;i++) {
            int j=i+1;
            if(cs[i]>cs[j] && judge(cs[i], cs[j])) {
                char temp = cs[i];
                cs[i] = cs[j];
                cs[j] = temp;
                return new String(cs);
            }
        }
        return s;
    }

    private static boolean judge(int num1, int num2) {
        if (num1 % 2 == 0) {
            return num2 % 2 == 0;
        }
        if (num1 % 2 == 1) {
            return num2 % 2 == 1;
        }
        return false;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{9,2,5};
        ListNode node = new ListNode();
        node.val =1;
        node.next = new ListNode(2,new ListNode(10,new ListNode(9,null)));
        System.out.println(modifiedList(nums, node));

    }

static class ListNode {
      int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
    public static ListNode modifiedList(int[] nums, ListNode head) {

        Set<Integer> numsSet = new HashSet<>();
        for (int num : nums) {
            numsSet.add(num);
        }

        ListNode current = head;
        ListNode pre = null;

        while (current != null) {
            // 如果当前节点数据不存在，直接往下
            if (!numsSet.contains(current.val)) {
                pre = current;
                current = current.next;
            } else {
                // 如果当前节点的数据存在
                // 如果是头结点，重新赋值头结点
                if (current == head) {
                    head = current.next;
                    current = current.next;
                } else {
                    pre.next = current.next;
                    current = current.next;
                }
            }

        }

        return head;

    }
}
