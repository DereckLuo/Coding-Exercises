package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);  l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6); l2.next.next = new ListNode(4);

        Solution sol = new Solution();

        ListNode output = sol.addTwoNumbers(l1, l2);
        printList(output);
    }

    public static void printList(ListNode node){
        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
