package quiz1;

import java.util.Scanner;

public class Q1_Fibo_In_Range {
	
	static void printFibo(int n, int m) {
		
		int a = 0;
		int b = 1;
		int c;
		
		while(a+b<=m) {
			c = a+b;
			if(c>=n && c<=m) System.out.print(c+" ");
			a = b;
			b = c;
		}
	
	}
	
	public static void main(String[] args) {
		System.out.println("Name: Rounik Prashar");
		System.out.println("Roll No: BTech/60023/19\n");
	
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter n: ");
		int n = sc.nextInt();
		System.out.println("Enter m: ");
		int m = sc.nextInt();
		sc.close();
		
		System.out.println("Fibonacci Number in range "+n +" to "+ m +" are: ");
		printFibo(n, m);
		
	}

}
