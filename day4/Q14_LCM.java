package day4;

import java.util.Scanner;

public class Q14_LCM {
	
	static int lcm(int a, int b) {
		int s = Math.max(a, b);
		int e = a*b;
		for(int i=s; i<e; i++) {
			if(i%a==0 && i%b==0) return i;
		}
		return a*b;
	}
	
	public static void main(String[] args) {
		System.out.println("Name: Rounik Prashar");
		System.out.println("Roll No: BTECH/60023/19\n");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first number (a): ");
		int a = sc.nextInt();
		System.out.println("Enter second number (b): ");
		int b = sc.nextInt();
		sc.close();
		System.out.println("LCM of "+a+" and "+b+" is: ");
		System.out.println(lcm(a,b));
	}
}