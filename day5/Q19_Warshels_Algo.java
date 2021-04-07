package day5;

// WAP to implement Warshel’s algorithm of all pair shortest path.

import java.util.Scanner;

public class Q19_Warshels_Algo {
	
	static int[][] warshel(int[][] A, int n) {
		 
		for(int x=0; x<n; x++) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(A[i][j]==0) {
						A[i][j] = A[i][x]+A[x][j];
					}
					else if(A[i][x] + A[x][j] < A[i][j]) {
						A[i][j] = A[i][x]+A[x][j];
					}
				}
			}
			printMat(A);
		}
		
		return A;
	}
	
	static void printMat(int[][] A) {
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<A[0].length; j++) {
				System.out.print(A[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);		
		System.out.println("Enter the number of vertices in the graph: ");

		int n = sc.nextInt();
		int[][] A = new int[n][n];

		System.out.println("Now fill the adjeceny matrix: ");
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.println("Enter A["+i+"]["+j+"]");
				A[i][j] = sc.nextInt();
			}
		}
		
		sc.close();
		A = warshel(A,n);
		
		System.out.println("Shortest Path Matrix is: ");
		printMatrix(A);
	}
	
	static void printMatrix(int[][] A) {
		for(int i=0; i<A.length; i++) {
			for(int j=0;j<A[0].length; j++) {
				System.out.print(A[i][j]+"  ");
			}
			System.out.println();
		}
	}

}