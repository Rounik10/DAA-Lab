package day4;

import java.util.Scanner;

public class Q16_GCD_Rec {
	
	static int gcd(int m, int n) {
		if(m<n) {
			int temp = n;
			n = m;
			m = temp;
		}
		if(n==0) return m;
		return gcd(m%n,n);
	}
	
	static int gcdOneLine(int m, int n) {
		return Math.min(m, n) == 0 ? Math.max(m, n) : m>n ? gcd(m%n,n) : gcd(n%m,m);
	}
	
	public static void main(String[] args) {
		System.out.println("Name: Rounik Prashar");
		System.out.println("Roll No: BTECH/60023/19\n");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the first number.");
		int a = sc.nextInt();
		
		System.out.println("Enter the second number.");
		int b = sc.nextInt();		
		sc.close();
		
		System.out.println("GCD of "+a+" and "+b+" is: ");
		System.out.println(gcd(a,b));	
	}
}