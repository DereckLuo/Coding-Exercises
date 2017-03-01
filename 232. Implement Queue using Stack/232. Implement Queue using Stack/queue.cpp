/**
 *	232. Implement Queue using Stacks
 *	 Implement the following operations of a queue using stacks 
 *		push(x) -- push element x to the back of queue.
 *		pop() -- Removes the element from in front of queue
 *		peek() -- Get the front element
 *		empty() -- Return whether the queue is empty
 *	Notes:
 *		You must use only standard operations of a stack -- which means only push to top, peak/pop from top, 
 *	size, and is empty operations are valid 
 *		Depending on your language, stack may not be supported natively. You may simulate a stack by using a list
 *	or deque, as long as you use only standard oeprations of a stack
 *		You may assume that all operations are valid 
 **/

#include<stack>

using namespace std;

/**
 * O(n) time for push
 * O(1) time for pop, peek and empty
 **/
class Queue {
public:
	// Push element x to the back of queue.
	void push(int x) {
		while (!nums.empty()) {
			helper.push(nums.top());
			nums.pop();
		}
		nums.push(x);
		while (!helper.empty()) {
			nums.push(helper.top());
			helper.pop();
		}
		
	}

	// Removes the element from in front of queue.
	void pop(void) {
		nums.pop();
	}

	// Get the front element.
	int peek(void) {
		return nums.top();
	}

	// Return whether the queue is empty.
	bool empty(void) {
		return nums.empty();
	}

private:
	stack<int> helper, nums;
};