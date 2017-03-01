/**
 *	Backtracking algorithm:
 *		Eight Queens Puzzle
 *	Placing eight chess queens on an 8x8 chessboard so that no two queens threaten each other. 
 *	A solution requires that no two queens share same row, column, or diagnoal. 
 **/

#include<iostream>
#include<vector>
#include<array>


using namespace std;


struct board
{
	int arr[8][8] = { 0 }; //y-x
};

class Solution
{
public:

	/**
	 *	Backtracking solution simply as DFS which placing one queen down and moving on, if not 
	 *	able to keep moving on, going back one step and keep searching on.
	 **/
	int eightqueen1() {

		int ret = 0; //return number of solutions. 
		for (int i = 0; i < 8; i++) {
			board* map = new board; //allocate board 
			map->arr[0][i] = 1;
			invalid_fill(map, i, 0);
			ret += eightqueen_help(map, 1);
			//printboard(map);
			delete map;
		}
		return ret;
	}

	/**
	*	Helper function to fill in the board with invalid solution
	*	x : the x position of the queen placement
	*	y : the y position of the queen placement
	*	input : the input board
	**/
	void invalid_fill(board* input, int x, int y) {
		//cout << "x : " << x << " y : " << y << " \n";
		//mark current queen
		input->arr[y][x] = 2;
		//filling column
		int pos_x = x, pos_y = y;
		pos_y += 1;
		while (pos_y < 8) {
			input->arr[pos_y][pos_x] = 1;
			pos_y += 1;
		}

		//filling right branch 
		pos_x = x; pos_y = y;
		pos_x += 1; pos_y += 1;
		while (pos_x < 8 && pos_y < 8) {
			input->arr[pos_y][pos_x] = 1;
			pos_x += 1; pos_y += 1;
		}

		//filling left branch 
		pos_x = x; pos_y = y;
		pos_x -= 1; pos_y += 1;
		while (pos_x > 0 && pos_y < 8) {
			input->arr[pos_y][pos_x] = 1;
			pos_x -= 1; pos_y += 1;
		}
		
	}

	/**
	 *	Recursive helper function to calculate number of solutions. 
	 *	input : the input borad 
	 *	n : the number of rows it at 
	 **/
	int eightqueen_help(board* input, int n) {
		int ret = 0;
		//return case 
		if (n == 8) { //the last row
			for (int i = 0; i < 8; i++) {
				if (input->arr[n][i] == 0) {
					ret += 1;
					printboard(input); 
					//cout << i << "\n";
				}
			}
		}
		//recursive case 
		else {
			for (int i = 0; i < 8; i++) {
				board* temp = new board;	//allocate new board 
				if (input->arr[n][i] == 0) {
					board_copy(temp, input);
					invalid_fill(temp, i, n); //filling the board 
					ret += eightqueen_help(temp, n + 1);
				}
				delete temp;	//free new board
			}
		}
		return ret;
	}

	/* printing board helper function */
	void printboard(board* input) {
		cout << "\n"; 
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				cout << input->arr[i][j] << " ";
			}
			cout << "\n";
		}
		cout << "\n";
	}

	/**
	 *	Board copy function 
	 **/
	void board_copy(board* copy, board* src) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				copy->arr[i][j] = src->arr[i][j];
			}
		}
	}



	/**
	 * Function to free the board 
	 **/
	void free_board(board* map) {
		for (int i = 0; i < 2;  i++) {
			delete[] map->arr[i];
		}
		//delete[] map->arr;
		//delete map;
	}
};


int main() {
	cout << "Function starts! \n";

	Solution sol; 

	int ret = sol.eightqueen1();
	cout << "Solution value is : " << ret << "\n";
}
