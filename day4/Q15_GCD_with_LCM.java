package day4;

import java.util.Scanner;

public class Q15_GCD_with_LCM {

	static int lcm(int a, int b) {
		int s = Math.max(a, b);
		int e = a*b;
		for(int i=s; i<e; i++) {
			if(i%a==0 && i%b==0) return i;
		}
		return a*b;
	}
	
	static int gcd(int a, int b) {
		return a*b/lcm(a,b);
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the first number.");
		int a = sc.nextInt();
		
		System.out.println("Eneter the second number.");
		int b = sc.nextInt();
		
		sc.close();
		
		System.out.println(gcd(a,b));
		
	}

}
