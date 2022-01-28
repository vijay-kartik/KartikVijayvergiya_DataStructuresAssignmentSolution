package com.greatlearning.main;

import com.greatlearning.model.TreeNode;
import com.greatlearning.service.Main;

/*
 * This class is a driver class for Assignment 
 * Q.2 - {Convert BST complete to skewed}
 * */
public class Driver_2 {
	public static void main(String[] args) {
		Main tree = new Main();
		tree.node = new TreeNode(50);
		tree.node.left = new TreeNode(30);
		tree.node.right = new TreeNode(60);
		tree.node.left.left = new TreeNode(10);
		tree.node.right.left= new TreeNode(55);
		
		tree.convertTreeToSkewed();
		tree.inorderTraversal(tree.node);
	}
}
