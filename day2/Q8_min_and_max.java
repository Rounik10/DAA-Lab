package day2;

import java.util.Scanner;

public class Q8_min_and_max {
	
	static void print_max_min(int arr[], int n) {
		
		int max = arr[0], min = arr[0];
		
		for(int i=0; i<n; i++) {
			if(arr[i]>max) max = arr[i];
			if(arr[i]<min) min = arr[i];
		}
		
		System.out.println("Max: " + max);
		System.out.println("Min: " + min);
		
	}

	// The order of above algorithm is: O(N)
	// Where N is the number of elements in the array
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of elements: ");
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		System.out.println("Now enter "+n+" elements in the list: ");
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		sc.close();
		
		print_max_min(arr, n);
		
	}
	
}
