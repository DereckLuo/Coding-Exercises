/**
 * 24. Swap Nodes in Pairs 
 *		Given a linked list, swap every two adjacent nodes and return its head
 *	For example, 
 *	Given 1->2->3->4, you should return the list as 2->1->4->3
 *	Your algorithm should use only constant space, You may not modify the 
 *	values in the list, only nodes itself can be changed 
**/


#include <iostream>
#include <stdio.h>
#include <list>


using namespace std;

/*Definition for singly-linked list.*/

 struct ListNode {
     int val = 0;
     ListNode *next = NULL;
     //ListNode(int x) : val(x), next(NULL) {}
 };

class Solution {
public:
	ListNode* swapPairs(ListNode* head) {

		ListNode* ret;
		ListNode* top;
		ListNode* prv;
		bool check = true; 
		ret = head; 
		top = head;
		prv = head;

		if (head == NULL)
			return ret;

		while (top->next != NULL) {

			if (check)
				ret = top->next;
			check = false; 

			ListNode* temp = top->next;

			prv->next = temp;
			top->next = temp->next;
			temp->next = top; 

			prv = top; top = top->next;
			if (top == NULL)
				break;
		}

		return ret;

	}

	void printlist(ListNode* head) {
		cout << "Linked List Print out : ";
		ListNode* ret;
		ret = head;
		while (ret != NULL) {
			cout << ret->val;
			ret = ret->next;
		}
		cout << "\n";
	}

	void free(ListNode* head) {
		ListNode* node;
		ListNode* temp;
		node = head;

		while (node != NULL) {
			temp = node;
			node = node->next;
			delete temp;
		}
	}
};



int main() {

	Solution sol;


	ListNode* head = new ListNode;
	head->val = 0;

	ListNode* pre = head;
	ListNode* ret;


	for (int i = 1; i < 8; i++) {
		ListNode* node = new ListNode;

		node->val = i;
		pre->next = node; pre = node;
	}


	sol.printlist(head);

	ret = sol.swapPairs(head);

	sol.printlist(ret);

	sol.free(head);

	return 0;
}