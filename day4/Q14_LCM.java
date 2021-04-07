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

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		sc.close();

		System.out.println(lcm(a,b));

	}

}
