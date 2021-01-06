package com.java.practice.ds;

class Node {
	
	int value;
	Node left;
	Node right;
	
	Node(int value) {
		
		this.value = value;
	}
}

public class Tree {

	Node root;
	
	public void addNode(int value) {
				
		try {
			root = add(root, value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Node add(Node node, int value) throws Exception {
		
		if (node == null) {
			
			return new Node(value);
		}
		
		if (value < node.value) {
			
			node.left = add(node.left, value);
			
		} else if (value > node.value) {

			node.right = add(node.right, value);
		} else {
			
			throw new Exception("Duplicate Number...");
		}
		
		return node;
	}
	
	public String searchNode(int value) {
		
		return search(root, value) ? 
				"Found" : "Not Found";
	}
	
	private boolean search(Node node, int value) {
		
		if (node != null) {
			
			if (node.value == value) {
				
				return true;
			}
			
			if (value < node.value) {
				
				return search(node.left, value);
			} else {
				
				return search(node.right, value);
			}
		}
		return false;
	}

	public void delete(int value) {
		
	}
	
}
