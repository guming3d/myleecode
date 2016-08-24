package com.interview.balancedbinarytree;

import com.interview.balancedbinarytree.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a 
binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root=new TreeNode(4);
		root.left=new TreeNode(2);
		root.right=new TreeNode(2);
		root.right.left=new TreeNode(2);
		root.right.left.left=new TreeNode(2);
//		root.left.left=new TreeNode(1);
//		root.right=new TreeNode(7);
//		root.right.left=new TreeNode(6);
//		root.right.right=new TreeNode(9);
//		root.right.left.right=new TreeNode(33);
		System.out.println(isBalanced(root));
	}
	public static boolean isBalanced(TreeNode root)
	{
		if(root==null)
		{
			return true;
		}
		if(root.left==null && root.right==null)
		{
			return true;
		}
			
		int diff=maxDeepth(root.left)-maxDeepth(root.right);
		
		if(-1>diff || diff>1)
		{
			return false;
		}
		else{
			//search the child balance
			return isBalanced(root.left) && isBalanced(root.right);
		}
		
	}
	
	public static int maxDeepth(TreeNode root)
	{
		if(root==null)
		{
			return 0;
		}
		if(root.left==null && root.right==null)
		{
			return 1;
		}
		
		int leftDepth=maxDeepth(root.left);
		int rightDepth=maxDeepth(root.right);
		if(leftDepth>rightDepth)
		{
			return leftDepth+1;
		}
		else{
			return rightDepth+1;
		}
		
	}
}
