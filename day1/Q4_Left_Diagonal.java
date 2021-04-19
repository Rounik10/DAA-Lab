package day1;

import java.util.Scanner;

public class Q4_Left_Diagonal {
	
	static int[][] inputMatrix(int row, int col) {
		int arr[][] = new int[row][col];
		for(int i = 0; i<row; i++) {
			for(int j=0; j<col; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		return arr;
	}

	static Scanner sc = new Scanner(System.in);
	
	static void printInfo() {
		System.out.println("Name: Rounik Prashar");
		System.out.println("Roll No: BTECH/60023/19");
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		printInfo();
		System.out.println("Write the order of the square matrix(N): ");
		int n = sc.nextInt();
		
		System.out.println("Now enter "+n*n+" elements in the Array");
		
		int A[][] = inputMatrix(n, n);
		
		sc.close();
		
		System.out.println("Left Diagonal Matrix is: ");
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(i==j)System.out.print(A[i][i]+" ");
				else System.out.print("0 ");
			}
			System.out.println();
		}
	}
}