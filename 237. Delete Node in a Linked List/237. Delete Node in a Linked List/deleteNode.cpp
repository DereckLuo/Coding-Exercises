/** 
 *	237. Delete Node in a Linked List
 *		Write a function to delete a node (except the tail) in a singly linked list, given only access to that node
 *	Supposed the linked list is 1->2->3->4 and you are given the third node with value 3, the linked list should 
 *	become 1->2->4 after calling your function 
 **/

#include<iostream>
#include<memory>

using namespace std;

/**
* Definition for singly-linked list. */
 struct ListNode {
     int val;
     ListNode *next;
     ListNode(int x) : val(x), next(NULL) {}
 };

class Solution {
public:
	/** 
	 *	Deleteing a single node in the list, NOT THE LAST ONE 
	 **/
	void deleteNode(ListNode* node) {
		ListNode* temp = node->next;
		//make this node the next node 
		node->val = node->next->val;
		node->next = node->next->next;
		delete temp;
	}

	/** 
	 *Creating a linked list 
	 **/
	ListNode* createList(int n) {
		ListNode* ret = new ListNode(int(0));
		ListNode* track = ret;
		for (int i = 1; i < n; i++) {
			ListNode* temp = new ListNode(int(i));
			track->next = temp; track = temp;
		}
		return ret;
	}

	/** 
	 *	Deleteing a linked list 
	 *	Recursive deleting method 
	 **/
	void deleteList(ListNode* node) {
		if (node->next == NULL) {
			delete node;
			return;
		}
		deleteList(node->next);
		delete node;
	}

	/** 
	 *	Printing a linked list 
	 **/
	void printList(ListNode* node) {
		while (node != NULL) {
			cout << node->val << " ";
			node = node->next;
		}
		cout << "\n";
	}
};

int main() {
	cout << "Function starts ! \n";
	Solution sol;

	ListNode* list = sol.createList(5);
	sol.printList(list);
	sol.deleteList(list);


	return 0;
}

