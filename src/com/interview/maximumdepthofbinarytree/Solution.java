package com.interview.maximumdepthofbinarytree;

/**
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the root
 * node down to the farthest leaf node.
 * 
 * @author guming
 *
 */
public class Solution {
	static int currentDepth = 0;
	static int maxDepth=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root1 = new TreeNode(10);

		root1.left = new TreeNode(9);
		root1.right = new TreeNode(10);
		root1.left.left = new TreeNode(8);
		root1.left.right = new TreeNode(7);
		System.out.println(maxDepth(root1));
	}

	public static int maxDepth(TreeNode root) {
		if(root==null)
		{
			return 0;
		}
		if(root.left==null && root.right==null)
		{
			return 1;
		}
		traverseTree(root);
		return maxDepth;
	}
	
	public static void traverseTree(TreeNode root)
	{
		currentDepth++;
		if(root.left==null && root.right==null)
		{
			if(currentDepth>maxDepth)
			{
				maxDepth=currentDepth;
			}
			currentDepth--;
			return;
		}
		
		if(root.left!=null)
		{
			traverseTree(root.left);
		}
		
		if(root.right!=null)
		{
			traverseTree(root.right);
		}
		currentDepth--;
	}
}
