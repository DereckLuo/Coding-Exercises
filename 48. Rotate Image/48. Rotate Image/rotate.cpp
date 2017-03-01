/**
 *	48. Rotate Image
 *		You are given an n x n 2D matrix representing an image
 *	Rotate the image by 90 degrees (clock wise)
 *	Follow up: Could you do this inplace?
 **/

#include <iostream>
#include <vector>

using namespace std;


class Solution {
public:
	void rotate(vector<vector<int>>& matrix) {
		//base case 
		if (matrix.size() == 0)
			return;

		int size = matrix.size();
		int mid = size / 2; //the center of the image 
		int length = matrix.size(); //the length of the rotating side 
		for (int i = 0; i <= mid - 1; i++) { //loop through rotating layers 
			for (int j = 0; j < length-1; j++) { //loop through individual item in signle layer
				int temp = matrix[i+j][i]; 
				//rotate operation 
				matrix[i + j][i] = matrix[size - 1 - i][i + j]; //bottom to left 
				matrix[size - 1 - i][i + j] = matrix[size - 1 - i - j][size - 1 - i]; //right to bottom
				matrix[size - 1 - i - j][size - 1 - i] = matrix[i][size-1-i-j];//top to right
				matrix[i][size-1-i-j] = temp;
			}
			length -= 2;
		}
	}

	/* The function to create a 2D array image */
	/* n : the width of the image */
	vector<vector<int>> image_create( int n) {
		vector<vector<int>> ret; 

		for (int i = 0; i < n; i++) {
			vector<int> temp; 
			for (int j = 0; j < n; j++) {
				temp.push_back(i);
			}
			ret.push_back(temp);
		}
		return ret;
	}

	/**
	 * Function to print out the image 
	 **/
	void image_print(vector<vector<int>> & image) {
		for (int i = 0; i < image.size(); i++) {
			for (int j = 0; j < image[i].size(); j++) {
				cout << image[i][j] << " ";
			}
			cout << "\n";
		}
	}
};



int main() {

	cout << " Function Starts ! \n";

	Solution sol;

	vector<vector<int>> image = sol.image_create(3); //creating the image 

	sol.image_print(image);

	cout << "\n\n";
	sol.rotate(image);
	sol.image_print(image);

	return 0;
}