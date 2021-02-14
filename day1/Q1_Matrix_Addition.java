package day1;

/*
 * Write a program, to add two matrices, of order ‘m’ x ‘n’, 
 * where value of ‘m’ and ‘n’ are entered by the user at runtime, 
 * and the values of matrix ‘A’ and matrix ‘B’ are also entered by the user at runtime.
 */

import java.util.*;

public class Q1_Matrix_Addition {
	
	static int[][] inputMatrix(int row, int col) {
		int arr[][] = new int[row][col];
		for(int i = 0; i<row; i++) {
			for(int j=0; j<col; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		return arr;
	}
	

	static void printMatrix(int [][] M) {
		for(int i=0; i<M.length; i++) {
			for(int j=0; j<M[0].length; j++) {
				System.out.print(M[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {

		// Taking User Input
		System.out.println("Enter the number of rows: ");
		int r = sc.nextInt();
		
		System.out.println("Enter the number of columns: ");
		int c = sc.nextInt();
		
		System.out.println("Enter "+r*c+ " elements for the second array(A): ");
		int A[][] = inputMatrix(r,c);
		System.out.println("Enter "+r*c+ " elements for the second array(B): ");
		int B[][] = inputMatrix(r,c);
		
		sc.close();
		
		int C[][] = new int[r][c];
		
		// Calculating sum
		for(int i=0; i<r; i++) {
			for(int j=0; j<c;j++) {
				C[i][j] = A[i][j]+B[i][j];
			}
		}
		
		printMatrix(C);
		
	}

}