package day4;

import java.util.Scanner;

public class Q17_Create_BST {
	
	static class Node {
		int data;
		Node left, right;
		
		Node(int val) {
			this.data = val;
			this.left = this.right = null;
		}
	}
	
	static Node insert(Node root, int val) {
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

	static void preorder(Node root) {
		if(root == null) return;
		System.out.print(root.data+" ");
		preorder(root.left);	
		preorder(root.right);
	}
	
	public static void main(String[] args) {

		System.out.println("Name: Rounik Prashar");
		System.out.println("Roll No: BTECH/60023/19\n");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of nodes!");
		int n = sc.nextInt();
		System.out.println("Enter data for "+n+" nodes: ");
		Node root = new Node(sc.nextInt());
		
		for(int i=1; i<n; i++) {
			insert(root, sc.nextInt());
		}	
		sc.close();
		System.out.println("Preorder traversal of this BST is: ");
		preorder(root);
		System.out.println();
	}
}