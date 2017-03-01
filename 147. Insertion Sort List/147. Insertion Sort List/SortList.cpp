/**
 *	147. Insertion Sort List 
 *	Sort a linked list using insertion sort 
 *	Insertion sort algorithm:
 *		sorting one element at a time, by inserting into correct place 
 *	not efficent comparing with other algorithm, but good for short list 
 *	easy to implement 
 **/

#include <iostream>

using namespace std;


// Definition for singly-linked list.
// this is a singly linked list 
 struct ListNode {
     int val;
     ListNode *next;
     ListNode(int x) : val(x), next(NULL) {}
 };

class Solution {
public:
	/**
	 *	insertion sort on singly linked list 
	 **/
	ListNode* insertionSortList(ListNode* head) {
		//base case 
		if (head == NULL || head->next == NULL) return head; //list <= 1 element no need to sort 

		ListNode* ret = head; //return pointer 
		ListNode* loop; //the node loop through the entire array 
		ListNode* prv_loop; 
		prv_loop = head; loop = head->next;

		while (loop != NULL) { //while not hit the end of the list 
			if (loop->val < prv_loop->val) { //case need to be sorted 
				ListNode* prv_track; ListNode* track; 
				prv_track = NULL; track = ret;
				while (track->val < loop->val) { //find the insert position, will be between prv_track and track 
					prv_track = track; track = track->next;
				}
				//unlink current node 
				ListNode* temp = loop; loop = loop->next; prv_loop->next = loop;
				//insert into correct position 
				if (prv_track == NULL) {
					ret = temp; temp->next = track;
				}
				else {
					prv_track->next = temp; temp->next = track;
				}
			}
			else {
				prv_loop = loop; loop = loop->next;
			}
		}
		return ret;
	}

	/**
	 *	Function to create a linked list 
	 **/
	ListNode* createList() {
		ListNode* head = new ListNode(6);
		ListNode* node1 = new ListNode(5);
		ListNode* node2 = new ListNode(3);
		ListNode* node3 = new ListNode(1);
		ListNode* node4 = new ListNode(8);
		ListNode* node5 = new ListNode(7);
		ListNode* node6 = new ListNode(2);
		ListNode* node7 = new ListNode(4);

		head->next = node1; node1->next = node2; node2->next = node3;
		node3->next = node4; node4->next = node5; node5->next = node6;
		node6->next = node7;

		return head;
	}

	/**
	 *	Function to print the list 
	 **/
	void printList(ListNode* head) {
		while (head != NULL) {
			cout << head->val << " ";
			head = head->next;
		}
		cout << "\n";
	}

	/**
	 *	Function to free the entire list 
	 */
	void free(ListNode* head) {
		if (head->next == NULL) {
			delete head;
			return;
		}

		free(head->next);
		delete head;
	}
};



int main() {
	cout << "Function Starts ! \n";

	Solution sol;

	auto input = sol.createList(); 

	sol.printList(input);

	auto output = sol.insertionSortList(input);

	sol.printList(output);

	sol.free(output);

	return 0;
}