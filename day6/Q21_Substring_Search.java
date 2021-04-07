package day6;

import java.util.Scanner;

public class Q21_Substring_Search {
	
	static int getOccurences(String str, String subStr) {
		if(subStr.length() > str.length()) return 0;
		int occ = 0;
		for(int i=0; i<str.length()-subStr.length(); i++) {
			if(str.substring(i,i+subStr.length())
					.equals(subStr)) {
				occ++;
			}
		}
		return occ;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String: ");
		
		String str = sc.nextLine();
		
		System.out.println("Enter the number of substrings to be searched: ");
		int n = sc.nextInt();
		
		while(n-->0) {
			System.out.println("\nEnter a String: ");
			String subStr = sc.next();
			int occ = getOccurences(str, subStr);
			System.out.println("It occurs "+occ + " times.");
		}
			
		sc.close();
	}
	
}
