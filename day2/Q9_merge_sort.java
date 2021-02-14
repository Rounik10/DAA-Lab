package day2;

import java.util.Arrays;
import java.util.Scanner;

public class Q9_merge_sort {
	
	private static void mergeSort(int[] arr, int s, int e) {
	
		if(s<e) {
			int mid = (s+e)/2;
			mergeSort(arr,s,mid);
			mergeSort(arr,mid+1,e);
			merge(arr,s,mid,e);
		}
		
	}
	
	private static void merge(int[] arr, int s, int mid, int e) {
		
		int i = s, j = mid+1;
		int ind = 0;
		
		int ans[] = new int[e-s+1];
		
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
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of elements: ");
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		System.out.println("Now enter "+n+" elements in the list: ");
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		sc.close();
		
		System.out.println("The sorted list is: ");
		mergeSort(arr,0,n-1);
		for(int i=0; i<n; i++) System.out.print(arr[i]+" ");
	
	}

	static boolean stressTest() {
		
		int n = (int) (Math.random()*10)+1;
		
		int arr[] = new int[n];
		int clone[] = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] =(int) (Math.random()*100);
			clone[i] = arr[i];
		}
		
		Arrays.sort(arr);
		mergeSort(clone,0,n-1);
		
		for(int val: arr) System.out.print(val+" ");
		System.out.print(">> ");
		
		
		for(int i=0; i<n; i++) {
			if(arr[i] != clone[i]) {
				System.out.println("NOT MATCHED");
				return false;
			}
		}
		
		System.out.println("MATCHED");
		return true;
		
	}
	
}