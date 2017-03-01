/**
 *	133. Clone Graph:
 *		Clone an undirected graph. Each node in the graph contains a 
 *	label and a list of its neighbors. 
 *	OJ's undirected graph serialization:
 *		Nodes are labeled uniquely.
 *	We use # as a seperator for each node, and , as a seperator for node
 *	label and each neighbor of the node. 
 *	As an example, consider the serialized graph {0,1,2#1,2#2,2}
 *	The graph has a total of three nodes, and therefore contains three
 *	parts as seperated by #
 *		1. First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 *		2. Second node is labeled as 1. Connect node 1 and to node 2.
 *		3. Third node is labeled as 2. Connect node 2 to node 2(itself), thus forming a self-cycle.
 *	Visually, the graph lloks like the following:
 *			1
 *		   / \
 *		  /   \
 *		 0 --- 2
 *			  / \
 *			  \_/
**/

#include<stdio.h>
#include<vector>
#include<iostream>
#include<queue>
#include<stack>
#include<map>


using namespace std;

/**
* Definition for undirected graph.*/
 struct UndirectedGraphNode {
     int label;
     vector<UndirectedGraphNode *> neighbors;
     UndirectedGraphNode(int x) : label(x) {};
 };

class Solution {
public:
	UndirectedGraphNode *cloneGraph(UndirectedGraphNode *node) {
		map<int, UndirectedGraphNode *> map;

		queue<UndirectedGraphNode *> graph;

		UndirectedGraphNode* ret = NULL; 

		//case empty graph
		if (node == NULL)
			return ret;

		ret->label = node->label;
		graph.push(node); //push first node
		map[node->label] = ret; //clone first node

		while (!graph.empty()) {
			//while que is not empty 
			UndirectedGraphNode* temp = graph.front();

			graph.pop(); //pop off the front of queue
			map[temp->label]->label = temp->label; //clone label
			//clone children
			for (int i = 0; i < temp->neighbors.size(); i++) {
				//loop through all children 
				if (map[temp->neighbors[i]->label] == NULL) {
					//not in map, first time visit 
					UndirectedGraphNode *child = NULL;
					map[temp->neighbors[i]->label] = child; //store child
					graph.push(temp->neighbors[i]); //push into queue
				}
				map[temp->label]->neighbors.push_back(map[temp->neighbors[i]->label]);
			}
		}

		return ret;


	}
};

/*Strategy: using BFS to search graph and store in vector*/

int main() {

	
}


