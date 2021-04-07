package assignment1;

import java.util.Scanner;

public class KnapSackBT {
	
	static int knapsack(int[] wt, int[] val, int n, int w) {
		if(n==0 || w==0) {
			return 0;
		}
		if(wt[n-1]>w) {
			return knapsack(wt,val,n-1,w);
		}
		else {
			return Math.max(knapsack(wt, val, n-1, w), 
				val[n-1] + knapsack(wt, val, n-1, w-wt[n-1]));
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements: ");
		int n = sc.nextInt();
		System.out.println("Enter the bag capacity: ");
		
		int w = sc.nextInt();
		System.out.println("Enter the weight array: ");
		
		int[] wt = new int[n];
		for(int i=0; i<n; i++) {
			wt[i] = sc.nextInt();
		}
		
		System.out.println("Enter the value array: ");
		
		int[] val = new int[n];
		for(int i=0; i<n; i++) {
			val[i] = sc.nextInt();
		}
		sc.close();
		
		System.out.println("Maximum profit will be: "
				+knapsack(wt, val, n, w));
	}
}