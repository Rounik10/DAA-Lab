package day3;

import java.util.Scanner;

public class Q10_Find_Power {
	
	static int power(int x, int n) {
		if(n<0) {
			return 1/power(x,-1*n);
		}
		else if(n==0) {
			return 1;
		}
		else if((n&1)==0) {
			return power(x,n>>1)*power(x,n>>1);
		}
		else {
			return x*power(x,n-1);
		}
	}

	public static void main(String[] args) {
		
		System.out.println("Name: Rounik Prashar");
		System.out.println("Roll No: BTECH/60023/19\n");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter x: ");
		int x = sc.nextInt();
		System.out.println("Enter n: ");
		int n = sc.nextInt();
		sc.close();
		System.out.println(x+" to the power "+n+" is:\n"+power(x,n));	
	}
}