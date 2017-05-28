package com.company;

/**
 * 2. Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative integers. The
 * digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself
 *
 * Input (2->4->3) + (5->6->4)
 * Output 7->0->8
 * Created by Dereck on 0001, March 1, 2017.
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode sum = new ListNode(0);
        ListNode track = sum;
        int overflow = 0;
        while(l1 != null || l2 != null){
            int leftval = 0; int rightval = 0;
            if(l1 != null){
                leftval = l1.val; l1 = l1.next;
            }
            if(l2 != null){
                rightval = l2.val; l2 = l2.next;
            }
            int cur_sum = overflow + leftval + rightval;
            if(cur_sum >= 10){
                overflow = 1;
            }
            else{ overflow = 0;}

            track.next = new ListNode(cur_sum % 10);
            track = track.next;
        }
        if (overflow != 0) track.next = new ListNode(overflow);
        return sum.next;
    }

}
