package quiz1;

import java.util.Scanner;

public class Q3_Merge_Strings {

	private static void mergeSort(char[] arr, int s, int e) {
		
		if(s<e) {
			int mid = (s+e)/2;
			mergeSort(arr,s,mid);  
			mergeSort(arr,mid+1,e);
			merge(arr,s,mid,e);
		}
		
	}
	
	private static void merge(char[] arr, int s, int mid, int e) {
		
		int i = s, j = mid+1;
		int ind = 0;
		
		char ans[] = new char[e-s+1];
		
		while(i<=mid && j<=e) {
			
			if(arr[i] < arr[j]) {
				 ans[ind++] = arr[i++];
			} 
			else {
				ans[ind++] = arr[j++];
			}
			
		}
		
		while(i<=mid) ans[ind++] = arr[i++];
		while(j<=e) ans[ind++] = arr[j++];
		
		ind = 0;
		for(int k=s; k<=e; k++) {
			arr[k] = ans[ind++];
		}
		
	}
	
	public static void main(String[] args) {

		System.out.println("Name: Rounik Prashar");
		System.out.println("Roll No: BTech/60023/19\n");
	
		// Taking User Input
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length of first string: ");
		int n = sc.nextInt();
		
		System.out.println("Now enter the first string: ");
		String A = sc.next();
		
		System.out.println("Enter the length of second string: ");
		int m = sc.nextInt();
		
		System.out.println("Now enter the second string: ");
		String B = sc.next();
		sc.close();

		char[] string = new char[m+n];
		int ind = 0;
		
		for(int i=0; i<n; i++,ind++) string[ind] = A.charAt(i);
		for(int j=0; j<m; j++,ind++) string[ind] = B.charAt(j);
		
		mergeSort(string,0,m+n-1);
		
		// Printing Merges
		System.out.println("Merged String is:");
		
		for(int i=0; i<m+n; i++) System.out.print(string[i]);
	}

}