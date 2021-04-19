package day7;

import java.util.Scanner;

/*
             4
           /   \
          3     7 
         / \   / \  
        2   1 5   8
	In-Order: 1 2 3 4 5 7 8 
*/

public class Q29_Integer_BST_InOrder {

	private static class Node {
		int data;
		Node left, right;
		Node(int val) {
			this.data = val;
			this.left = this.right = null;
		}
	}
	
	private static Node insert(Node root, int val) {
		if(root == null) {
			root = new Node(val);
		}
		else if(root.data > val) {
			root.left = insert(root.left, val);
		}
		else {
			root.right = insert(root.right, val);
		}
		return root;
	}

	private static void inOrder(Node root) {
		if(root == null) return;
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}
	
	public static void main(String[] args) {
		
		System.out.println("Name: Rounik Prashar");
		System.out.println("Roll No: BTECH/60023/19\n");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of nodes: ");
		
		int n = sc.nextInt();
		System.out.println("Enter "+n+" values:");
		
		Node root = new Node(sc.nextInt());
		
		for(int i=1; i<n; i++) {
			insert(root, sc.nextInt());
		}
		sc.close();
		
		System.out.println("In-Order traversal will be: ");
		inOrder(root);
	}
}