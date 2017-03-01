/**
 *	84. Largest Rectangle in Histogram
 *  Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the 
 *	area of largest rectangle in the histogram
 *	Example:
 *		Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3]
 *	The largest rectangle is shown in the shaded area, which has area of 10 units
 **/

#include<iostream>
#include<vector>
#include<algorithm>


using namespace std;

class Solution {
public:
	/**
	 *	Algorithm solution:
	 *		For any bar i the maximum rectangle is of width R - L - 1 where R is the last coordinate of the 
	 *	bar to the right with height h[r] >= h[i] and L is the last coordinate of the bar to the left which
	 *	height h[L] >= h[i]
	 *	Therefore 
	 *	int maxArea = 0;
	 *	for(int i = 0; i < height.length; i++){
	 *		maxArea = max(maxArea, height[i] * (lessFromRight[i] - lessFromeLeft[i] -1));
	 *	}
	 *	The trick is to calculate lessFromRight and lessFromLeft array in less than O(n^2)
	 *	Using DP instead of loops to calculate the two arrays 
	 **/
	int largestRectangleArea(vector<int> & heights) {
		int length = heights.size(); 
		if (length == 0) return 0; //base case
		if (length == 1) return heights[0];

		//two vector lessFromRight lessFromLeft
		vector<int> lessFromRight(length, 0);
		vector<int> lessFromLeft(length, 0);
		lessFromRight[length - 1] = length; lessFromLeft[0] - 1; //set two boundaries

		//for loop to find the leftmost array 
		for (int i = 1; i < length; i++) { //looping through the array from 1st element 
			if (heights[i] > heights[i - 1]) { //case current bar taller than left 
				lessFromLeft[i] = i - 1; //store index 
			}
			else {	//case current bar shorter than left 
				int p = i - 1; //position start at left one bar 
				//while p im bound and barheight is >= current barheight, keep jumping to find leftmost
				while (p >= 0 && heights[p] >= heights[i]) p == lessFromLeft[p];
				lessFromLeft[i] = p;
			}
		}
		//for loop to find the rightmost array 
		for (int i = length - 2; i >= 0; i--) {
			if (heights[i] > heights[i + 1]) {//case current bar taller than left 
				lessFromRight[i] = i + 1; //store index
			}
			else { //case current bar shorter than right
				int p = i + 1;
				while (p < length && heights[p] >= heights[i]) p = lessFromRight[p];
				lessFromRight[i] = p;
			}
		}

		//actual area calculation
		int maxArea = 0;
		for (int i = 0; i < length; i++) {
			maxArea = max(maxArea, heights[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
		}
		return maxArea;
	}

	/** 
	 *	Trying DP solution for this question 
	 *  Does not work to certain cases 
	 **/
	int largestRectangleAreaAlmost(vector<int>& heights) {
		//base case
		int length = heights.size(); //number of columns
		if (length == 0) return 0;
		
		//DP starts 
		int max_rect = 0; //the variable to store max rectangle area
		pair<int, int> temp(0, 0);
		vector<pair<int, int>> table(length, temp); //the table to store the best area solution on each index
		//the pair<int, int> = pair<x, y>
		table[0].first = 1; table[0].second = heights[0]; //store first value
		max_rect = table[0].first * table[0].second; //store first max
		int i = 1; //iterator to loop through entire array 
		while (i < length) {
			int ind_area = heights[i]; //the individual area
			int comb_area = min(heights[i], table[i - 1].second)*(table[i - 1].first + 1); //max prev + itself possible
			//compare and store solution
			if (ind_area > comb_area) {
				//store table
				table[i].first = 1; table[i].second = heights[i];
				if (ind_area > max_rect) max_rect = ind_area;
			}
			else {
				//store table 
				table[i].first = table[i - 1].first + 1; table[i].second = min(heights[i], table[i - 1].second);
				if (comb_area > max_rect) max_rect = comb_area;
			}
			i++;
		}
		vector<pair<int, int>> table2(length, temp);
		table2[length-1].first = 1; table2[length-1].second = heights[length - 1];
		i = length - 2;
		while (i >= 0) {
			int ind_area = heights[i]; //the individual area
			int comb_area = min(heights[i], table2[i + 1].second)*(table2[i + 1].first + 1); //max prev + itself possible
																						   //compare and store solution
			if (ind_area >= comb_area) {
				//store table
				table2[i].first = 1; table2[i].second = heights[i];
				if (ind_area > max_rect) max_rect = ind_area;
			}
			else {
				//store table 
				table2[i].first = table2[i + 1].first + 1; table2[i].second = min(heights[i], table2[i + 1].second);
				if (comb_area > max_rect) max_rect = comb_area;
			}
			i--;
		}
		
		return max_rect;
	}
};

int main() {
	cout << " Function Starts ! \n";
	Solution sol;

	vector<int> input = {1,1,1,1,5,1,1,1};

	auto ret = sol.largestRectangleArea(input);

	cout << " largest rectangle has area of : " << ret << " units \n";
	return 0;
}