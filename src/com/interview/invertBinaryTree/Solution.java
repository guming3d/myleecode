package com.interview.invertBinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1
Trivia:
This problem was inspired by this original tweet by Max Howell:
Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so fuck off.
 */

//TODO:
public class Solution {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root=new TreeNode(4);
		root.left=new TreeNode(2);
		root.left.right=new TreeNode(3);
		root.left.left=new TreeNode(1);
		root.right=new TreeNode(7);
		root.right.left=new TreeNode(6);
		root.right.right=new TreeNode(9);
		root.right.left.right=new TreeNode(33);
		
		Solution solution=new Solution();
		solution.invertTree(root);
		solution.traverseTree(root);
	}

	public TreeNode invertTree(TreeNode root) {
		traverseInvertTree(root);
		return root;
    }
	
	public void traverseInvertTree(TreeNode root)
	{
		if(root==null)
	    {
	        return;
	    }
		if (!(root.left==null && root.right==null))
        {
        	TreeNode tmpNode=root.left;
        	root.left=root.right;
        	root.right=tmpNode;
        }	
        	
		if(root.left !=null){
    		traverseInvertTree(root.left);
    	}
    	
    	if(root.right !=null)
    	{
    		traverseInvertTree(root.right);
    	}
    	
        	return;
	}
	
	public void traverseTree(TreeNode root)
	{
		System.out.println(root.val);
		if(root.left!=null )
		{
			traverseTree(root.left);
		}
		if(root.right!=null )
		{
			traverseTree(root.right);
		}
	}
}
