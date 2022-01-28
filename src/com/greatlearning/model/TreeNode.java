package com.greatlearning.model;

public class TreeNode {
	int data;
	public TreeNode left, right;
	
	public TreeNode(int value) {
		data = value;
		left = null;
		right = null;
	}
	
	public int getData() {
		return data;
	}

}
