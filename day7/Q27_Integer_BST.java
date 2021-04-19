package day7;

/* 
   WAP to crate a binary tree for given number of elements 
   and traverse the binary tree, in post order.

  	N = 7
    Nodes: 4 3 7 2 1 5 8
	
		    4
		  /   \
		 3     7 
	    / \   / \  
	   2   1 5   8
   
   InOrder: 1 2 3 4 5 7 8 
   PostOrder: 1 2 3 5 8 7 4 
   PreOrder: 4 3 2 1 7 5 8

*/

import java.util.Scanner;

public class Q27_Integer_BST {
	
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

	private static void postOrder(Node root) {
		if(root == null) return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+" ");
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
		
		System.out.println("Post-Order traversal will be: ");
		postOrder(root);
	}
}