package assignment1;

import java.util.Scanner;

public class NQueensProblem {
	
	static int[][] board;
	
	static boolean isSafePos(int x, int y) {
		int n = board.length;
		
		// column
		for(int i=0; i<n;  i++) {
			if(board[i][y] == 1 && i != x) {
				return false;
			}
		}
		
		// left diagonal
		for(int i=x-1, j=y-1; i>=0 && j>=0; i--, j--) {
			if(board[i][j]==1) return false;
		}
		
		// right diagonal
		for(int i=x-1, j=y+1; i>=0 && j<n; i--, j++) {
			if(board[i][j]==1) return false;
		}
		
		return true;
	}
	
	static boolean nQueens(int row) {
		if(row == board.length) {
			disp();
			return true;
		}
		for(int i=0; i<board.length; i++) {
			if(isSafePos(row,i)) {
				board[row][i] = 1;
				if(!nQueens(row+1)) board[row][i] = 0;
				else return true;
			}
		}
		return false;
	}
	
	static void disp() {
		System.out.println("SOLUTION");
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board.length; j++) {
				System.out.print(""+board[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {	 
		System.out.println("Name: Rounik Prashar");
		System.out.println("Roll No: BTECH/60023/19\n");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of N: ");
		
		int n = sc.nextInt();
		board = new int[n][n];
		
		if(nQueens(0)==false) {
			System.out.println("No Solution for N = "+n);
		}
		sc.close();
	}
}