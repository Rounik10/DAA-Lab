package day3;

import java.util.Scanner;

public class Q11_Strassens_Matrix_Multiplication {

	static int[][][] split(int arr[][]) {
		
		int n = arr.length;
		int ans[][][] = new int[4][n/2][n/2];
		
		int r=0,c=n/2,ti=0,tj=0;
		
		for(int x = 0; x <4; x++) {
			
			if(x==0) {
				r=0;
				c=0;
			} else if(x==1) {
				r = 0;
				c = n/2;
			} else if(x==2) {
				r = n/2;
				c = 0;
			} else {
				r = n/2;
				c = n/2;
			}
			
			for(int i=r; i<r+n/2; i++, ti++) {
				if(ti>=n/2) ti = 0;
				tj=0;
				for(int j=c; j<c+n/2; j++,tj++) {
					ans[x][ti][tj] = arr[i][j];
				}
			}	
		}
		return ans;
	}
	
	static int[][] recombine(int arr[][][]) {
		
		int n = arr[0].length*2;
		
		int[][] ans = new int[n][n];
		int ti,tj=0;
		
		for(int x=0; x<4; x++) {
			if(x==0) {
				ti = tj = 0;
			} 
			else if(x==1) {
				ti = 0;
				tj = n/2;
			} 
			else if(x==2) {
				ti = n/2;
				tj = 0;
			} 
			else {
				ti = n/2;
				tj = n/2;
			}
			
			int xi = ti, yi = tj;
			
			for(int i=0; i<n/2; i++) {	
				if(tj>=n/2) tj = yi;
				if(ti>=n) ti = xi;
				for(int j=0; j<n/2; j++) {
					ans[ti][tj] = arr[x][i][j];
					tj++;
				}
				ti++;
			}
		}
		return ans;
	}
	
	static int[][] add(int A[][], int B[][]) {
		
		int C[][] = new int[A.length][A[0].length];
		
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<B.length; j++) {
				C[i][j] = A[i][j]+B[i][j];
			}
		}
		
		return C;
	}
	
	static int[][] sub(int A[][], int B[][]) {
		
		int C[][] = new int[A.length][A[0].length];
		
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<B.length; j++) {
				C[i][j] = A[i][j]-B[i][j];
			}
		}
		
		return C;
	}

	private static int[][] multiply(int[][] A, int[][] B) {
		
		if(A.length == 1) {
			int[][] ans= {{A[0][0]*B[0][0]}};
			return ans;
		}
		
		int[][][] X = split(A);
		int[][][] Y = split(B);
	
		int[][] p1 = multiply(X[0],sub(Y[1],Y[3]));
		int[][] p2 = multiply(add(X[0],X[1]),Y[3]);
		int[][] p3 = multiply(add(X[2],X[3]),Y[0]);
		int[][] p4 = multiply(X[3],sub(Y[2],Y[0]));
		int[][] p5 = multiply(add(X[0],X[3]),add(Y[0],Y[3]));
		int[][] p6 = multiply(sub(X[1],X[3]),add(Y[2],Y[3]));
		int[][] p7 = multiply(sub(X[0],X[2]),add(Y[0],Y[1]));
		
		X[0] = add(add(p5,p4),sub(p6,p2));
		X[1] = add(p1,p2);
		X[2] = add(p3,p4);
		X[3] = add(sub(p1,p3),sub(p5,p7));
		
		return recombine(X);
	}
	
	public static void main(String[] args) {
		
		System.out.println("Name: Rounik Prashar");
		System.out.println("Roll No: BTECH/60023/19\n");
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the order of square matrices(N): ");
		int n = sc.nextInt();
		
		int l = nearestPowerOf2(n);
		boolean flag = l!=n;
		
		int A[][] = new int[l][l];
		int B[][] = new int[l][l];
		
		System.out.println("Enter "+n*n+" elements for matrix A: ");
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n;j++) {
				A[i][j] = sc.nextInt();
			}
		}
		
		System.out.println("Enter "+n*n+" elements for matrix B: ");
		for(int i=0; i<n; i++) {
			for(int j=0; j<n;j++) {
				B[i][j] = sc.nextInt();
			}
		}
		sc.close();
		
		int C[][] = multiply(A,B);
		
		System.out.println("\nMatrix A is:");
		printArr(A, flag);
		
		System.out.println("Matrix B is:");
		printArr(B, flag);
		System.out.println("AxB is given by: ");
		
		printArr(C, flag);
			
	}
	
	private static int nearestPowerOf2(int n) {
		int num = 1;
		while(num < n) num <<= 1;
		return num;
	}

	static void printArr(int[][] arr, boolean flag) {
		int n = arr.length;
		if(flag) n--;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}