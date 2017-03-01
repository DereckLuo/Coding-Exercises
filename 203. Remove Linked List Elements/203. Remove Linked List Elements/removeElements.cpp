/**
 *	203. Remove Linked List Elements
 *		Remove all elements from a linked list of integers that have value val. 
 *	Example:
 *		Given: 1->2->6->3->4->5->6, val = 6
 *		Return 1->2->3->4->5
 **/


#include<iostream>
#include<list>

using namespace std; 



//Definition for singly-linked list.
 struct ListNode {
     int val = 0;
     ListNode *next = NULL;
    // ListNode(int x) : val(x), next(NULL) {}
 };

class Solution {
public:
	/*remove nodes with value in the list */
	ListNode* removeElements(ListNode* head, int val) {
		ListNode* track = head; ListNode* track_prev = NULL;

		while (track != NULL) {
			if (track->val == val) {//case track is the value
				ListNode* temp = track;
				if (track == head) head = track->next;
				if (track_prev != NULL) {
					track_prev->next = track->next; track = track->next;
				}
				else {
					track = track->next;
				}
				delete temp;
			}
			else {
				track_prev = track; track = track->next;
			}
		}
		return head;
	}


	/* function to free a linked list */
	void deleteList(ListNode* head) {
		ListNode* curr = head;
		ListNode* next;
		if (head == NULL) return;

		next = curr->next;
		while (next != NULL) {
			delete curr;
			curr = next; next = next->next;
		}
		delete curr;
		return;
	}

	/* function to create a linked list */
	ListNode* createList(int n) {
		ListNode* head = new ListNode; //the head of the linked list 
		ListNode* track = head;
		for (int i = 1; i < n; i++) {//creating n nodes for the linked list 
			ListNode* temp = new ListNode;
			temp->val = i;
			track->next = temp; track = temp;
		}
		return head;
	}

	/* function to print a linked list */
	void printList(ListNode* head) {
		ListNode* curr = head;
		while (curr != NULL) {
			cout << curr->val << "->";
			curr = curr->next;
		}
		cout << "null\n";
	}
};


int main() {

	cout << "Function Starts ! \n";

	Solution sol;
	ListNode* input = sol.createList(5);
	sol.printList(input);
	ListNode* output = sol.removeElements(input, 0);
	sol.printList(output);
	sol.deleteList(output);

	return 0;
}