package day2;

import java.util.Scanner;

public class Q7_bin_search_rec {
	
	private static int Binary_Search_Rec(int[] arr, int key, int s, int e) {

		if(s>e) return -1;
		int mid = (s+e)/2;
		
		if(arr[mid] == key) return mid;
		else if(arr[mid] > key) return Binary_Search_Rec(arr,key,s,mid-1);
		else return Binary_Search_Rec(arr,key,mid+1,e);

	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of elements: ");
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		System.out.println("Now enter "+n+" elements in sorted order: ");
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println("Enter the key to find: ");
		int key = sc.nextInt();
		sc.close();
		
		int index = Binary_Search_Rec(arr, key, 0, n-1);
		
		if(index == -1) System.out.println(key+" doesnot exist in the list");
		else System.out.println(key+ " exists at index: "+index);

	}

	
}
