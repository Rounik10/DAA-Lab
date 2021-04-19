package day2;

import java.util.Scanner;

public class Q6_bin_search_itr {

/*
 This function takes sorted array and a key as input
 It returns the index of key in the index of in the array
 If key is not present in array -1 will be returned.
*/
	static int Binary_Search_Itr(int arr[], int key) {
		
		int start = 0, end = arr.length;
		int mid;
		
		while(start<=end) {
			mid = (start+end)/2;
			if(arr[mid] == key) return mid;
			else if(arr[mid]>key) end = mid-1;
			else start = mid+1;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		
		System.out.println("Name: Rounik Prashar");		
		System.out.println("Roll No: BTECH/60023/19\n");

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
		
		int index = Binary_Search_Itr(arr, key);
		
		if(index == -1) System.out.println(key+" doesnot exist in the list");
		else System.out.println(key+ " exists at index: "+index);
	}
}