package day6;

import java.util.Scanner;

public class Q23_Balanced_BST {

	static class Node {
		int data;
		Node left, right;
		
		Node(int val) {
			this.data = val;
			this.left = this.right = null;
		}
	}
	
	static Node insert(Node root, int val) {
		
		if(root == null) root = new Node(val);
		else if(root.data > val) root.left = insert(root.left, val);
		else root.right = insert(root.right, val);
		
		return root;
	}

	static void postOrder(Node root) {
		if(root == null) return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+" ");
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of nodes!");
		int n = sc.nextInt();
		System.out.println("Enter "+n+" values:");
		
		Node root = new Node(sc.nextInt());
		
		for(int i=1; i<n; i++) {
			insert(root, sc.nextInt());
		}
		
		sc.close();
		
		System.out.println("Post order traversal will be: ");
		postOrder(root);
		System.out.println();
	}

}