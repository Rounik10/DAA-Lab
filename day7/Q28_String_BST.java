package day7;

import java.util.Scanner;

public class Q28_String_BST {

	static class Node {
		String data;
		Node left, right;
		
		Node(String val) {
			this.data = val;
			this.left = this.right = null;
		}
	}
	
	static Node insert(Node root, String val) {
		
		if(root == null) {
			root = new Node(val);
		}
		else if(root.data.compareTo(val) > 0) {
			root.left = insert(root.left, val);
		}
		else {
			root.right = insert(root.right, val);
		}
		
		return root;
	}

	static void preOrder(Node root) {
		if(root == null) return;
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public static void main(String[] args) {

		System.out.println("Name: Rounik Prashar");
		System.out.println("Roll No: BTECH/60023/19\n");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of nodes: ");
		int n = sc.nextInt();
		System.out.println("Enter "+n+" values:");
		
		Node root = new Node(sc.next());
		
		for(int i=1; i<n; i++) {
			insert(root, sc.next());
		}
		sc.close();
		
		System.out.println("Pre order traversal will be: ");
		preOrder(root);
	}

}