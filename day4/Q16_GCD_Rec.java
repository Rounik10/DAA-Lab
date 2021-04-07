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
	
	static int gcd1(int m, int n) {
		return Math.min(m, n) == 0 ? Math.max(m, n) : m>n ? gcd(m%n,n) : gcd(n%m,m);
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(), b = sc.nextInt();
		sc.close();
		System.out.println(gcd(a,b));
		
	}

}