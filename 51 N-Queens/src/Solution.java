import java.util.ArrayList;
import java.util.List;

/**
 * 51. N-Queens
 * The n-queens puzzle is the problem of placing n queens on an nxn chessboard such that no two queens
 * attack each other
 * Given an integer n, return all distict solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space 
 * respectively.
 * 
 * @author Dereck
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<String>> output = solveNQueens(8);

		System.out.print(output);
	}
	
	public static List<List<String>> solveNQueens(int n){
		List<List<String>> ret = new ArrayList<List<String>>();
	
		//Creating an empty board 
		char board[][] = new char[n][n];
		Printboard(board);
		
		//back tracking algorithm iteratively 
		QueenHelp(ret, board, 0, n);
		return ret;
	}
	
	public static void QueenHelp(List<List<String>> ret, char[][] board, int row, int n){
		//Printboard(board);
		//base case
		if(row == n){
			List<String> temp = new ArrayList<String>();
			for(int i = 0; i < n; i++){
				String line = "";
				for(int j = 0; j < n; j++){
					line += board[i][j];
				}
				temp.add(line);
			}
			ret.add(temp);
			return;
		}
		//recursive case
		for(int i = 0; i < n; i++){
			//System.out.print(row);System.out.println(i);
			if(board[row][i] != '.'){
				char copy[][] = new char[n][n];
				//System.arraycopy(board, 0, copy, 0, n);
				for(int a = 0; a < n; a++){
					for(int b = 0; b < n; b++){
						copy[a][b] = board[a][b];
					}
				}
				copy[row][i] = 'Q';
				for(int j = 0; j < n; j++){
					if(j != i) copy[row][j] = '.';
				}
				int j = row+1; int l = i-1; int r = i+1;
				while(j < n){
					copy[j][i] = '.';
					if(l >= 0) copy[j][l] = '.';
					if(r < n) copy[j][r] = '.';
					l--; r++; j++;
				}
				QueenHelp(ret, copy, row+1, n);
			}
		}
		
	}
	
	public static void Printboard(char[][] board){
		System.out.println("printing board ");
		for(int i = 0; i < board[0].length; i++){
			for(int j = 0; j < board.length; j++){
				System.out.print(board[i][j]);
				System.out.print(" ");
			}
			System.out.print("\n");
		}
	}
	


}
