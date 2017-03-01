/**
 *	328. Odd Even Linked List 
 *		Given a singly linked list, group all odd nodes together followed by the 
 *	even nodes. Please note here we are talking about the node number and not the 
 *	value in the nodes. 
 *	You should try to do it in place. The program should run in O(1) space complexity
 *	and O(nodes) time complexity.
 *
 *	Example:
 *		Given 1->2->3->4->5->NULL
 *		Return 1->3->5->2->4->NULL
 *
 *	Note:
 *		The relative order inside both the even and odd groups should remain as it was in the
 *	input. The first node is considered odd, the second node even and so on...
**/


#include <iostream>
#include <stdio.h>



using namespace std;


/** Definition for singly-linked list**/
 struct ListNode {
     int val = 0;
     ListNode *next = NULL;
     //ListNode(int x) : val(x), next(NULL) {}
 };

class Solution {
public:
	ListNode* oddEvenList(ListNode* head) {

		ListNode* ret = head; //return pointer
		if (head == NULL || head->next == NULL)
			return ret;

		ListNode* even_head = NULL;
		ListNode* even_track = NULL; //track even LL 

		if (head->next != NULL) {
			even_head = head->next;
			even_track = ret;
		}
	

		ListNode* ptr = ret; //tracking on original LL

		while (ptr->next != NULL) {
			even_track->next = ptr->next;
			even_track = ptr->next;

			if (ptr->next->next == NULL) {
				ptr->next = NULL;
			}
			else {
				ptr->next = ptr->next->next; 
				ptr = ptr->next;
			}
		}

		even_track->next = NULL;
		ptr->next = even_head;
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


	for (int i = 1; i < 9; i++) {
		ListNode* node = new ListNode;

		node->val = i;
		pre->next = node; pre = node;
	}


	sol.printlist(head);

	ret = sol.oddEvenList(head);

	sol.printlist(ret);

	sol.free(head);

	return 0;

}