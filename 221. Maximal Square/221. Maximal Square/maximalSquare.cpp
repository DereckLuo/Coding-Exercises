/**
 *	211. Maximal Square:
 *		Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area
 *	For example, given the following matrix:
 *	1 0 1 0 0 
 *	1 0 1 1 1 
 *	1 1 1 1 1 
 *	1 0 0 0 0
 *	return 4
 **/

#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

class Solution {
public:
	int maximalSquare(vector<vector<int>>& matrix) {
		if (matrix.size() == 0) return 0;
		int size_x = matrix[0].size(), size_y = matrix.size();
		int size_min = min(size_x, size_y);

		//creating the structure for DP
		vector<vector<vector<int>>> table;
		for (int i = 0; i < size_y; i++) { //point row
			vector<vector<int>> line;
			for (int j = 0; j < size_x; j++) { //point colum 
				vector<int> point;
				for (int k = 0; k < size_min; k++) { //point square size 0 = size 1
					point.push_back(0);
				}
				line.push_back(point);
			}
			table.push_back(line);
		}


		int max_size = 0, max_location_x = 0, max_location_y = 0; //tracking the position of maxsquare

		//filling all squares with size 1 and 2
		for (int i = 0; i < size_y; i++) { //rows 
			for (int j = 0; j < size_x; j++) { //colums 
				if (matrix[i][j] == 0) {
					table[i][j][0] = 0;
				}
				else {
					table[i][j][0] = 1; 
					if (max_size < 1) {
						max_size = 1; max_location_x = j; max_location_y = i;
					}
				}
				if (i < size_y - 1 && j < size_x - 1) {//square with size 2 
					if (matrix[i][j] == 0 || matrix[i + 1][j] == 0 || matrix[i][j + 1] == 0 || matrix[i + 1][j + 1] == 0) {
						table[i][j][1] = 0;
					}
					else {
						table[i][j][1] = 1;
						max_size = 2; max_location_x = j; max_location_y = i;
					}
					//table[i][j][1] = (matrix[i][j] == 0 || matrix[i + 1][j] == 0 || matrix[i][j + 1] == 0 || matrix[i + 1][j + 1] == 0) ? 0 : 1;
				}
			}
		}


		//checking rest squares 
		for (int i = 3; i <= size_min; i++) { //check all size, using left upper coner to locate

			for (int j = 0; j <= size_y - i; j++) { // rows 
				for (int k = 0; k <= size_x - i; k++) { //columns 
					//cout << "cp 4 i is : " << i << " j is : " << j << " k is : " << k << "\n";
					//cout << "size_y - i is : " << (size_y - i) << " size_x - i is : " << (size_x - i) << "\n"; 
					if (table[j + 1][k + 1][i - 2] == 0) { //inner square is false
						table[j][k][i - 1] = 0;
					}
					else {
						//cout << "cp 6 x is : " << k << " y is : " << j << " length is : " << i <<" \n";
						bool check = true;
						for (int c = 0; c < i; c++) {
							//cout << " c is : " << c << " j is : " << j << " k is : " << k << "\n";
							if (matrix[j + c][k] == 0) {
								check = false; break;
							}
							if (matrix[j][k + c] == 0) {
								check = false; break;
							}
							if (matrix[j + c][k + i-1] == 0) {
								check = false; break;
							}
							if (matrix[j + i-1][k + c] == 0) {
								check = false; break;
							}
						}
						if (check) {
							table[j][k][i - 1] = 1;
							if (i > max_size) {
								max_size = i; max_location_x = k; max_location_y = j;
							}
						}
						else table[j][k][i - 1] = 0;
					}
				}
			}
		}

		/*
		for (int i = 0; i < size_y; i++) {
			for (int j = 0; j < size_x; j++) {
				cout << table[i][j][2] << " ";
			}
			cout << "\n";
		}
		cout << "\n";*/

		cout << "Max size is : " << max_size*max_size << " location at x : " << max_location_x << " y : " << max_location_y << "\n";
		return max_size*max_size;
	}

	/** 
	 *	Smarter DP solution from leetcode
	 *	Well, this problem desires for the use of dynamic programming. They key to any DP problem is to come up with the state equation. In this problem, we define the state to be the maximal size of the square that can be achieved at point (i, j), denoted as P[i][j]. Remember that we use size instead of square as the state (square = size^2).

		Now let's try to come up with the formula for P[i][j].

		First, it is obvious that for the topmost row (i = 0) and the leftmost column (j = 0), P[i][j] = matrix[i][j]. This is easily understood. Let's suppose that the topmost row of matrix is like [1, 0, 0, 1]. Then we can immediately know that the first and last point can be a square of size 1 while the two middle points cannot make any square, giving a size of 0. Thus, P = [1, 0, 0, 1], which is the same as matrix. The case is similar for the leftmost column. Till now, the boundary conditions of this DP problem are solved.

		Let's move to the more general case for P[i][j] in which i > 0 and j > 0. First of all, let's see another simple case in which matrix[i][j] = 0. It is obvious that P[i][j] = 0 too. Why? Well, since matrix[i][j] = 0, no square will contain matrix[i][j]. According to our definition of P[i][j], P[i][j] is also 0.

		Now we are almost done. The only unsolved case is matrix[i][j] = 1. Let's see an example.

		Suppose matrix = [[0, 1], [1, 1]], it is obvious that P[0][0] = 0, P[0][1] = P[1][0] = 1, what about P[1][1]? Well, to give a square of size larger than 1 in P[1][1], all of its three neighbors (left, up, left-up) should be non-zero, right? In this case, the left-up neighbor P[0][0] = 0, so P[1][1] can only be 1, which means that it contains the square of itself.

		Now you are near the solution. In fact, P[i][j] = min(P[i - 1][j], P[i][j - 1], P[i - 1][j - 1]) + 1 in this case.

		Taking all these together, we have the following state equations.

		P[0][j] = matrix[0][j] (topmost row);
		P[i][0] = matrix[i][0] (leftmost column);
		For i > 0 and j > 0: if matrix[i][j] = 0, P[i][j] = 0; if matrix[i][j] = 1, P[i][j] = min(P[i - 1][j], P[i][j - 1], P[i - 1][j - 1]) + 1.
		Putting them into codes, and maintain a variable maxsize to record the maximum size of the square we have seen, we have the following (unoptimized) solution.
	**/
	int maximalSquareBetterDP(vector<vector<char>>& matrix) {
		int m = matrix.size();
		if (!m) return 0;
		int n = matrix[0].size();
		vector<vector<int> > size(m, vector<int>(n, 0));
		int maxsize = 0;
		for (int j = 0; j < n; j++) {
			size[0][j] = matrix[0][j] - '0';
			maxsize = max(maxsize, size[0][j]);
		}
		for (int i = 1; i < m; i++) {
			size[i][0] = matrix[i][0] - '0';
			maxsize = max(maxsize, size[i][0]);
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == '1') {
					size[i][j] = min(size[i - 1][j - 1], min(size[i - 1][j], size[i][j - 1])) + 1;
					maxsize = max(maxsize, size[i][j]);
				}
			}
		}
		return maxsize * maxsize;
	}

	/** 
	 *	Function to create the square 
	 **/
	vector<vector<int>> createMatrix() {
		vector<vector<int>> ret;
		vector<int>temp = { 1,0,1,0,0}; ret.push_back(temp); temp.clear();

		temp = { 1,0,1,1,1 }; ret.push_back(temp); temp.clear();

		temp = { 1, 1, 1, 1, 1 }; ret.push_back(temp); temp.clear();

		temp = { 1,0,0,1,0 }; ret.push_back(temp); temp.clear();

		return ret;
	}

	/**
	 *	Function to print out the square 
	 **/
	void printMatrix(vector<vector<int>> & matrix) {
		for (int i = 0; i < matrix.size(); i++) {
			for (int j = 0; j < matrix[i].size(); j++) {
				cout << matrix[i][j] << " ";
			}
			cout << "\n";
		}
		cout << "\n";
	}
};

int main() {
	cout << "Function Starts ! \n";
	
	Solution sol;

	auto input = sol.createMatrix();
	sol.printMatrix(input);


	int size = sol.maximalSquare(input);


	return 0;
}