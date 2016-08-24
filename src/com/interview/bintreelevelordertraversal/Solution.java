package com.interview.bintreelevelordertraversal;

import java.util.List;
import java.util.Stack;

import com.interview.bintreelevelordertraversal.TreeNode;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 * @author mcgu
 *
 */
public class Solution {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root=new TreeNode(3);
		root.left=new TreeNode(9);
		root.right=new TreeNode(20);
		root.right.left=new TreeNode(15);
		root.right.right=new TreeNode(7);
		traverseTree(root);
	}
	public static List<List<Integer>> levelTraversal(TreeNode root)
	{
		return null;
	}
	
	/**
	 * traverse a binary tree without using recursion
	 */
	public static void traverseTree(TreeNode root)
	{
		if(root == null)
		{
			return;
		}
		Stack<TreeNode> treeStack=new Stack<>();
		
		treeStack.push(root);
		while(!treeStack.isEmpty())
		{
			TreeNode currNode=treeStack.pop();
			System.out.println(currNode.val);
			
			
			if(currNode.right!=null)
			{
				treeStack.push(currNode.right);
			}		
			if(currNode.left!=null)
			{
				treeStack.push(currNode.left);
			}
			
		}
		
	}
}
