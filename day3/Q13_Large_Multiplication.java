package day3;

import java.util.Scanner;

public class Q13_Large_Multiplication {
	
	static int[] large_multiply(int[] A, int[] B) {
		
		if(A.length == 1 && A.length == B.length) {
			int[] ans = {A[0]*B[0]};
			return ans;
		} 

		int[] a1 = getHalf(A,1);
		int[] a2 = getHalf(A,2);
		int[] b1 = getHalf(B,1);
		int[] b2 = getHalf(B,2);

		int n = A.length;
		
		int[] a1b1 = large_multiply(a1,b1);
		int[] a1b2 = large_multiply(a1,b2);
		int[] a2b1 = large_multiply(a2,b1);
		int[] a2b2 = large_multiply(a2,b2);
		
		return add(powerTen(a1b1, n), 
				add(powerTen(add(a1b2,a2b1),n/2), a2b2));
	}
	
	static int[] getHalf(int[] arr, int half) {
		int l = arr.length/2;
		int[] ans = new int[l];
		int ind = (half == 1) ? 0 : l;
		for(int i=0; i<l; i++, ind++) ans[i] = arr[ind];
		return ans;
	}
	
	static int[] powerTen(int A[], int n) {
		int len = A.length;
		int ans[] = new int[n+len];
		for(int i=0; i<len; i++) ans[i] = A[i];
		return ans;
	}
	
	static int[] add(int[] A, int[] B) {
		
		int ans[] = new int[Math.max(A.length, B.length)];
		
		int i=A.length-1, j = B.length-1, k = ans.length-1;
		int sum=0, carry=0;
		while(i>=0 && j>=0) {
			sum = A[i--]+B[j--]+carry;
			if(sum>9) { carry=1; sum = sum-10; } 
			else { carry = 0; }
			ans[k--] = sum;
		}
		while(i>=0) {
			sum = A[i--]+carry;
			if(sum>9) { carry=1; sum = sum-10;} 
			else carry = 0;
			ans[k--] = sum;
		}
		while(j>=0) {
			sum = B[j--]+carry;
			if(sum>9) { carry=1; sum = sum-10; } 
			else carry = 0;
			ans[k--] = sum;
		}
	
		if(carry == 1) {
			int[] arr = new int[ans.length+1];
			arr[0] = 1;
			for(int x=1, y=0; y<ans.length; x++, y++) {
				arr[x] = ans[y];
			}
			return arr;
		}
		
		return ans;
	}
	
	public static void main(String[] args) {

		System.out.println("Name: Rounik Prashar");
		System.out.println("Roll No: BTECH/60023/19\n");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the first numbers: ");
		String n1 = sc.next();
		System.out.println("Enter the second number: ");
		String n2 = sc.next();
		sc.close();
		
		int neg1=1, neg2=1;
		if(n1.charAt(0)=='-') {
			neg1 = -1;
			n1 = n1.substring(1);
		}
		if(n2.charAt(0)=='-') {
			neg2 = -1;
			n2 = n2.substring(1);
		}
		
		boolean isProdNeg;
		if(neg1*neg2 < 0) isProdNeg = true;
		else isProdNeg  = false;
		
		int n = nearestPow2(Math.max(n1.length(), n2.length()));
		
		int[] num1 = nextIntArr(n1,n);
		int[] num2 = nextIntArr(n2,n);
		
		if(isProdNeg) System.out.print("-");
		System.out.println("Their Multiplication is: ");
		printArr(large_multiply(num1,num2));
	}

	private static int[] nextIntArr(String s, int n) {
		int ans[] = new int[n];
		int ind = n-1;
		for(int i=s.length()-1; i>=0; i--) {
			ans[ind--] = (s.charAt(i)-'0');
		}
		return ans;
	}
	
	static int nearestPow2(int n) {
		int i = 1;
		while(i<n) i<<=1;
		return i;
	}
	
	static void printArr(int a[]) {
		String ans = "";
		for(int i:a) {
			ans+=i;
		}
		int i = 0;
		while(ans.charAt(i)=='0' && i<ans.length()-1) i++;
		System.out.println(ans.substring(i));
	}
}