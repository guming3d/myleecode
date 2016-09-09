package com.interview.validatebinarysearchtree;

import java.util.ArrayList;
import java.util.List;

/**
 *  Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.

Example 1:

    2
   / \
  1   3

Binary tree [2,1,3], return true.

Example 2:

    1
   / \
  2   3

Binary tree [1,2,3], return false. 
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution mySol=new Solution();
		
		TreeNode root=new TreeNode(10);
		root.left=new TreeNode(5);
		root.right=new TreeNode(15);
		root.right.left=new TreeNode(6);
		root.right.right=new TreeNode(20);
		System.out.println(mySol.isValidBST3(root));

	}
	//Using recursive method to
	//WRONG, only correct for 2 level
	public boolean isValidBST(TreeNode root) {
        if(root==null)
        {
        	return true;
        }
        if(root.left==null && root.right==null)
        {
        	return true;
        }
        
        if(root.left!=null)
        {
        	if(root.left.val<=root.val)
        	{
        		return isValidBST(root.left);
        	}else{
        		return false;
        	}
        }
        
        if(root.right!=null)
        {
        	if(root.right.val>=root.val)
        	{
        		return isValidBST(root.right);
        	}else{
        		return false;
        	}
        }
        
        return true;
    }
	static List<Integer> myList=new ArrayList<>();
	public boolean isValidBST2(TreeNode root) {
		myList.clear();
		//first flat the tree to a arrayList
		//walkthrough the tree using middle method
		traverseMiddle(root);
		
		for (int i = 0; i < myList.size()-1; i++) {
			if(myList.get(i+1)<=myList.get(i))
			{
				return false;
			}
		}
		
		
		return true;
	}
	public boolean isValidBST3(TreeNode root) {
		myList.clear();
		//first flat the tree to a arrayList
		//walkthrough the tree using middle method
		return traverseMiddle(root);
		
				
		
	}
	public boolean traverseMiddle(TreeNode root){
		boolean result=true;
		if(root==null)
		{
			return result ;
		}
//		if(root.left==null && root.right==null)
//		{
//			myList.add(root.val);
//		}
		if(root.left!=null)
		{
			result=traverseMiddle(root.left);
			if(result==false)
			{
				return false;
			}
		}
		if(myList.size()>0)
		{
			if(myList.get(myList.size()-1)>=root.val)
			{
				return false;
			}
		}
		
		myList.add(root.val);
		if(root.right!=null)
		{
			result=traverseMiddle(root.right);
			if(result==false)
			{
				return false;
			}
		}
		return result;
	}
	
}
