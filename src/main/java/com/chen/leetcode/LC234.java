package com.chen.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by zhoucy on 2024/7/25
 * LC234 链表
 **/


public class LC234 {

    public static void main(String[] args) {
        System.out.println(isPalindrome(new LC84.ListNode(1,new LC84.ListNode(2,new LC84.ListNode(2,new LC84.ListNode(1,null)
        )))));

    }

    public static boolean isPalindrome(LC84.ListNode head) {
        if (head.next == null)
            return true;
        Deque<LC84.ListNode> deque = new LinkedList<>();
        int length = 0;
        LC84.ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        current = head;
        for (int i = 1; i <= length / 2; i++) {
            deque.push(current);
            current = current.next;
        }
        // 奇数
        if (length % 2 == 1) {
            current = current.next;
        }
        while(current != null) {
            if(deque.pop().val != current.val) {
                return false;
            } else {
                current = current.next;
            }
        }

        return true;
    }
}

