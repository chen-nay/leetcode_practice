package com.chen.leetcode;

/**
 * Created by zhoucy on 2024/7/26
 * 链表
 * 快慢指针
 * 142. 环形链表 II
 * note : 这一题的关键在于，如果环中相遇，则fast从head开始，与slow共同走+1步，则
 * 会在入环节点出相遇
 * 但是关键：
 *      fast和slow必须从head开始+1,区别与LC141这道题，这题的起始是slow=head.next
 *
 *      <而这道题，起始的fast和slow都是head />
 **/


public class LC142 {

    public static void main(String[] args) {


        LC84.ListNode n_4 = new LC84.ListNode(-4,null);

        LC84.ListNode n0 = new LC84.ListNode(0,n_4);

        LC84.ListNode n2 = new LC84.ListNode(2,n0);
        LC84.ListNode head = new LC84.ListNode(3,n2);
        n_4.next = n2;

        System.out.println(detectCycle(head));
    }

    public static LC84.ListNode detectCycle(LC84.ListNode head) {
        if (head == null || head.next == null)
            return null;

        LC84.ListNode slow = head;
        LC84.ListNode fast = head;
        while (fast != null) {
// slow +1
            slow = slow.next;

            // fast +2
            fast = fast.next == null ? null : fast.next.next;
            if (slow == fast) {

                fast = head;
                while (fast != slow) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;

            }



        }

        return null;
    }
}
