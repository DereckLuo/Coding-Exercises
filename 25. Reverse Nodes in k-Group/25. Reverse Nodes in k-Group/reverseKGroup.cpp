/** 
 *	25. Reverse Nodes in k-Group
 *		Given a linked list, reverse the nodes of a linked list k at a time and return its modified list
 *	if the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is
 *	You may not alter the values in the nodes, only nodes itself may be changed
 *	Only constant memory is alowed.
 *	For example,
 *	Given this linked list: 1->2->3->4->5
 *	For k = 2, you should return 2->1->4->3->5
 *	For k = 3, you should return 3->2->1->4->5
 *	For k = 4, you should return 4->3->2->1->5
 **/

#include<iostream>
#include<stack>
#include<queue>


using namespace std;

/**
* Definition for singly-linked list.*/
 struct ListNode {
     int val;
     ListNode *next;
     ListNode(int x) : val(x), next(NULL) {}
 };

class Solution {
public:
	/**
	 *	Only constant memory required, therefore should reverse in place?
	 *	swap node value will be hard to do, cuz singly linked list
	 *	using a queue to do reverse operation 
	 **/
	ListNode* reverseKGroup(ListNode* head, int k) {
		ListNode* track = head; ListNode* ret = head;
		ListNode* prev_link = NULL; //the pointer to link between prev reverse and next reverse 
		queue<ListNode*> store; //the stack to do reverse operation 
		//base case
		if (k <= 1) return head;
		if (head == NULL) return head;
		//find new head
		for (int i = 0; i < k-1; i++) {
			ret = ret->next;
			if (ret == NULL) return head;
		}
		//reverse operation
		ListNode* rev_head; ListNode* rev_tail; //two pointer to point at head and tail of reversed subpart
		while (1) {
			for (int i = 0; i < k; i++) { //push k number of nodes into stack
				if (track == NULL) return ret; //case hit the end without enough nodes
				ListNode* temp = track;
				store.push(temp); //push in the node 
				track = track->next; //move to next node 	 
			}
			rev_head = store.back(); rev_tail = store.front(); 
			//track points at the beginning of next node
			//reconstruct first segment
			ListNode* link = track;
			while (!store.empty()) {
				//store.front()->next = NULL; //detach the first node 
				ListNode* top = store.front(); //point at first node 
				top->next = link;
				link = top;
				store.pop();
			}
			//link with previous link and update previous link
			if (prev_link != NULL) {
				prev_link->next = rev_head;
			}
			prev_link = rev_tail;
		}
	}

	/**
	 *	Function to build list on heap
	 **/
	ListNode* buildlist() {
		ListNode* ret = new ListNode(4); 
		for (int i = 3; i > 0; i--) {
			auto temp = new ListNode(i);
			temp->next = ret;
			ret = temp;
		}
		return ret;
	}
	
	/**
	 *	Function to free list on heap
	 **/
	void freelist(ListNode* head) {
		auto temp = head;
		while (head != NULL) {
			head = head->next;
			delete temp;
			temp = head;
		}
		delete temp;
	}

	/** 
	 *	Function to print out the list 
	 **/
	void printlist(ListNode* head) {
		while (head != NULL) {
			cout << head->val << " ";
			head = head->next;
		}
		cout << "\n";
	}
};

int main() {
	cout << "Function Starts ! \n";

	Solution sol;

	auto list = sol.buildlist();
	cout << "Input list is : ";
	sol.printlist(list); cout << "\n";

	list = sol.reverseKGroup(list, 2);

	cout << "Reversed list is : ";
	sol.printlist(list); cout << "\n";

	sol.freelist(list); 

	return 0;
}