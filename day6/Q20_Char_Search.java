package day6;

import java.util.Scanner;

public class Q20_Char_Search {
	
	static int getOccurences(String str, char c) {
		int occ = 0;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)==c) occ++;
		}
		return occ;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string: ");
		String str = sc.nextLine();
		
		System.out.println("Enter the number of characters you want to search: ");
		int n = sc.nextInt();
		
		while(n-->0) {
			System.out.println("Enter the character to be searched: ");
			char c = sc.next().charAt(0);
			
			int occ = getOccurences(str, c);
			System.out.println("\""+c+"\""+" occurs " + occ + " times");
		}
		
		sc.close();
	}

}
