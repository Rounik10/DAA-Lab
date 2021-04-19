package day1;

import java.util.Scanner;

public class Q2_Matrix_Substraction {

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
		System.out.println("Difference Matrix: ");
		for(int i=0; i<M.length; i++) {
			for(int j=0; j<M[0].length; j++) {
				System.out.print(M[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	static Scanner sc = new Scanner(System.in);
	
	static void printInfo() {
		System.out.println("Name: Rounik Prashar");
		System.out.println("Roll No: BTECH/60023/19");
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		printInfo();
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
		
		// Calculating Difference
		for(int i=0; i<r; i++) {
			for(int j=0; j<c;j++) {
				C[i][j] = A[i][j] - B[i][j];
			}
		}	
		printMatrix(C);	
	}
}