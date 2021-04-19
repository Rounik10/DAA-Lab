package day5;

import java.util.Scanner;

public class Q18_Fibonacci {

	static int[] dp;
	
	static int fibo(int n) {
		if(dp[n-1] !=0) return dp[n-1];
		if(n==1) return 0;
		if(n==2) return 1;
		return dp[n-1] = fibo(n-1) + fibo(n-2);
	}
	
	public static void main(String[] args) {
		System.out.println("Name: Rounik Prashar");
		System.out.println("Roll No: BTECH/60023/19\n");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter N: ");
		int n = sc.nextInt();
		System.out.println(n+" terms of Fibonacci series are: ");
		sc.close();
		dp = new int[n];
		
		for(int i=1; i<=n; i++) {
			System.out.print(fibo(i)+" ");
		}	
	}
}