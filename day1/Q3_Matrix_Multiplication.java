package day1;

import java.util.Scanner;

public class Q3_Matrix_Multiplication {
	
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
		
		System.out.println("Enter the number of rows for first matrix(A): ");
		int r1 = sc.nextInt();
		
		System.out.println("Enter the number of columns for first matrix(A): ");
		int c1 = sc.nextInt();
		
		System.out.println("Enter the number of rows for first matrix(B): ");
		int r2 = sc.nextInt();
		
		System.out.println("Enter the number of columns for first matrix(B): ");
		int c2 = sc.nextInt();
		
		if(c1 != r2) {
			System.out.println("Can't multiply since no. of cols in A are not equal to no. of rows in B");
		}
		
		else {
			
			int A[][] = inputMatrix(r1, c1);
			int B[][] = inputMatrix(r2, c2);
			
			sc.close();
			
			int C[][] = new int[r1][c2];
			
			for(int i=0; i<r1; i++) {
				for(int j=0; j<c2;j++) {
					C[i][j] = 0;
					for(int k=0; k<r2; k++) {
						C[i][j] += A[i][k]*B[k][j];
					}
					
				}
			}
			
			System.out.println("The multiplication of matrix A and B is: C["+r1+"]["+c2+"] = ");
			
			printMatrix(C);
		}
		
	}

}