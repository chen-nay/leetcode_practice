package com.chen.leetcode;

/**
 * Created by zhoucy on 2024/8/3
 * LC53
 * 动态规划、分治算法
 **/


public class LC53 {

    public static void main(String[] args) {
        int[] a = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(a));
        System.out.println(maxSubArrayV2(a));
    }

    // 暴力解法
    public static int maxSubArray(int[] nums) {
        if(nums.length == 1) return nums[0];
        int max = Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++) {
            int current = nums[i];
            max = Math.max(max, current);
            int j = i+1;
            while (j<=nums.length-1) {
                current = current + nums[j];
                max = Math.max(max, current);
                j++;
            }
        }
        return max;
    }

    public static int maxSubArrayV2(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int max = nums[0];
        int pre = -1;
        for (int i = 0; i < nums.length; i++) {
            if (pre > 0) {
                pre = nums[i];
                continue;
            }

            int current = nums[i];
            max = Math.max(max, current);
            int j = i + 1;
            while (j <= nums.length - 1) {
                current = current + nums[j];
                max = Math.max(max, current);
                j++;
            }
            pre = nums[i];
        }
        return max;
    }
}
