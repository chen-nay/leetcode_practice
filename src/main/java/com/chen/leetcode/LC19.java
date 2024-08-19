package com.chen.leetcode;

/**
 * Created by zhoucy on 2024/7/27
 * LC19
 * 链表
 **/


public class LC19 {
    public LC84.ListNode removeNthFromEnd(LC84.ListNode head, int n) {
        // 遍历找长度
        int length = 0;
        LC84.ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        // 如果要删除头结点
        if (length == n) {
            head = head.next;
            return head;
        }

        // 不删除头结点的情况下，常规思路是需要保存当前节点的上一个节点
        // 但是可以 变为 找目标节点 的 上一个节点
        int indexNeedRemovePre = length - n;
        int indexCurrent = 0;
        current = head;
        while (current != null) {
            indexCurrent++;
            if (indexCurrent == indexNeedRemovePre) {
                current.next = current.next.next;
                break;
            }
            current = current.next;
        }
        return head;
    }


}
