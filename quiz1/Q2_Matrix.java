package quiz1;

import java.util.Scanner;

public class Q2_Matrix {
	
	static int[][] getMatrix(int[][] A, int n) {
		
		int B[][] = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(i==0 || j==0 || i==n-1 || j==n-1 || i==j || j==n-1-i) {
					B[i][j] = 0;
				} else {
					B[i][j] = A[i][j];
				}
			}
		}
		
		return B;
		
	}

	public static void main(String[] args) {
		
		System.out.println("Name: Rounik Prashar");
		System.out.println("Roll No: BTech/60023/19\n");
	
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter n(order of matirx A): ");

		int n = sc.nextInt();
		
		System.out.println("Now enter the elments in matrix A:");
		
		int A[][] = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				A[i][j] = sc.nextInt();
			}
		}
		sc.close();
		
		int B[][] = getMatrix(A,n);
		
		System.out.println("Output Matrix B: ");
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(B[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
