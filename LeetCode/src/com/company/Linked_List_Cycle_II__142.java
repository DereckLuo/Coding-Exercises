package com.company;

import sun.awt.image.ImageWatched;

import java.util.HashMap;

/**
 * 142. Linked List Cycle II
 *      Given a linked list, return the node where the cycle begins. If there is no cycle,
 *      return null.
 *
 *      Solve without extra space
 */
public class Linked_List_Cycle_II__142 {
    private class ListNode extends ImageWatched.Link{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head){
        /**
         * O(n) Memory solution
         */
        HashMap<ListNode, Integer> map = new HashMap<>();

        while(head != null){
            if(map.containsKey(head)) return head;
            map.put(head, 1);
            head = head.next;
        }
        return null;
    }

    public ListNode detectCycleNoMem(ListNode head){
        /**
         * O(1) Memory solution
         * my solution is like this: using two pointers, one of them one step at a time. another pointer
         * each take two steps. Suppose the first meet at step k,the length of the Cycle is r. so..2k
         * -k=nr,k=nr
         Now, the distance between the start node of list and the start node of cycle is s. the
         distance between the start of list and the first meeting node is k(the pointer which wake one step
         at a time waked k steps).the distance between the start node of cycle and the first meeting node
         is m, so...s=k-m,
         s=nr-m=(n-1)r+(r-m),here we takes n = 1..so, using one pointer start from the start node of
         list, another pointer start from the first meeting node, all of them wake one step at a time,
         the first time they meeting each other is the start of the cycle.
         */
        return null;
    }
}
