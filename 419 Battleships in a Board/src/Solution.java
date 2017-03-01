/**
 * 419. Battleships in a Board:
 * 	Given a 2D board, count how many different battleships are in it. The battleships are represented with 'x',
 * empty slots are represented with '.'s. You may assume the following rules:
 * 	* You receive a valid board, made of only battleships or empty slots.
 *  * Battleships can only be placed horizontally or vertically. In other words, they can only be made of the 
 *  	shape 1xN ( 1 row, N columns) or Nx1(N rows 1 column), where N can be of any size.
 *  * At least one horizontal or vertical cell separates between two battleships
 *  
 *  Example: 
 *  x..x
 *  ...x
 *  ...x	2 battle ships
 *  
 *  Invalid Example
 *  ...x
 *  xxxx
 *  ...x	Cant be adjacent
 *  
 *  Could you do it in one-pass, using only O(1) extra memory and without modifying the value of the board
 *  
 * @author Dereck
 * 
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Declaring a 2D array for testing, using the hard way
		char[][] board = new char[3][4];	//3x4 board 
		board[0][0] = 'X'; board[0][1] = '.'; board[0][2] = '.'; board[0][3] = 'X';
		board[1][0] = '.'; board[1][1] = '.'; board[1][2] = '.'; board[1][3] = 'X';
		board[2][0] = '.'; board[2][1] = '.'; board[2][2] = '.'; board[2][3] = 'X';
		
		
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				System.out.print(board[i][j]);
			}
			System.out.print("\n");
		}
		
		int num = countBattleships(board);
		System.out.print("The number of battleships are : ");
		System.out.print(num);
	}

	
	public static int countBattleships(char[][] board){
		int ret = 0;
		
		for(int i = 0; i < board.length; i++){
			for (int j = 0; j < board[0].length; j++){
				if(board[i][j] == 'X'){
					if((i > 0 && j > 0 && board[i-1][j] != 'X' && board[i][j-1] != 'X')
							|| (i == 0 && j > 0 && board[i][j-1] != 'X')
							|| (j == 0 && i > 0 && board[i-1][j] != 'X')
							|| (i == 0 && j == 0)){
						ret += 1;
					}
				}
			}
		}
	
		return ret;
	}
}
