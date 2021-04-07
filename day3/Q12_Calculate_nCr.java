package day3;

import java.util.Scanner;

public class Q12_Calculate_nCr {

	// Calculating nCr
	static int ncr(int n, int r) {
		if(r<0 || n<0) return 0;
		else if(r==0 || n==r) return 1;
		else return ncr(n-1,r-1) + ncr(n-1,r);
	}
	
	public static void main(String[] args) {

		// Taking User Input
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 'n': ");
		
		int n = sc.nextInt();
		System.out.println("Enter 'r': ");
		
		int r = sc.nextInt();
		sc.close();
		
		// Printing the output
		System.out.println("nCr is:\n"+ncr(n,r));

	}

}
