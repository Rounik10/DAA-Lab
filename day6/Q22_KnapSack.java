package day6;

import java.util.Scanner;

public class Q22_KnapSack {
	
	static int[][] dp;
	
	static int getMaxValRec(int n, int w, int[] wt, int[] val) {
		
		if(n==0 || w==0) return dp[n][w] = 0;
		
		if(dp[n][w]!=-1) return dp[n][w];
		
		if(wt[n-1]>w) return dp[n][w] = getMaxValRec(n-1,w,wt,val);
		
		int inc = val[n-1] + getMaxValRec(n-1, w-wt[n-1], wt, val);
		
		int notInc = getMaxValRec(n-1,w, wt, val);
		
		return dp[n][w] = Math.max(inc, notInc);
		
	}
	
	static int getMaxVal(int n, int w, int[] wt, int[] val) {
		
		if(n==0 || w==0) return 0;
		
		if(wt[n-1]>w) return getMaxValRec(n-1,w,wt,val);
		
		int inc = getMaxValRec(n-1, w-wt[n-1], wt, val);
		
		int notInc = getMaxValRec(n-1,w, wt, val);
		
		return Math.max(inc, notInc);
		
	}
	
	static int getMaxValItr(int n, int w, int[] wt, int[] val) {
		
		for(int i=0; i<=n; i++) {
			dp[i][0] = 0;
		}
		
		for(int j=0; j<=w; j++) {
			dp[0][j] = 0;
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=w; j++) {
				if(j < wt[i-1]) dp[i][j] = dp[i-1][j];
				else {
					int inc = val[i-1] + dp[i-1][j-wt[i-1]];
					int notInc = dp[i-1][j];
					dp[i][j] = Math.max(inc, notInc);
				}
			}
		}
		return dp[n][w];
	}

	public static void main(String[] args) {
		
		System.out.println("Name: Rounik Prashar");
		System.out.println("Roll No: BTECH/60023/19\n");
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the number of Items: ");
		int n = sc.nextInt();
		
		System.out.println("Enter the capacity of knapsack: ");
		int w = sc.nextInt();
		
		dp = new int[n+1][w+1];
		
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=w; j++) {
				dp[i][j] = -1;
			}
		}
		
		int wt[] = new int[n];
		int val[] = new int[n];
		
		System.out.println("Enter the weight array: ");
		
		for(int i=0; i<n; i++) {
			wt[i] =  sc.nextInt();
		}

		System.out.println("Enter the value array: ");
		
		for(int i=0; i<n; i++) {
			val[i] =  sc.nextInt();
		}
		
		sc.close();
		
		int max = getMaxValItr(n,w,wt,val);
		System.out.println("Maximum value: "+max);	
	}
}