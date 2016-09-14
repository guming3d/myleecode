package com.interview.binarytreerightsideview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 199. Binary Tree Right Side View

    Total Accepted: 54124
    Total Submissions: 146156
    Difficulty: Medium

Given a binary tree, imagine yourself standing on the right side of it, 
return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---

You should return [1, 3, 4]. 
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution mySolution=new Solution();
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		root.left.right=new TreeNode(5);
		root.right.right=new TreeNode(4);
		mySolution.rightSideView(root);
	}
	static Stack<TreeNode> myStack=new Stack<>();
	 public List<Integer> rightSideView(TreeNode root) {
		 List<Integer> resultList=new ArrayList<>();
		 if(root==null)
		 {
			 return Arrays.asList();
		 }
		 if(root.left==null && root.right==null)
	        {
			 return Arrays.asList(root.val);
	        }
		 myStack.clear();
		 myStack.push(root);
		 List<TreeNode> levelList=new ArrayList<>();
		 while(!myStack.isEmpty())
		 {
			 levelList.clear();
			 while(!myStack.isEmpty())
			 {
				 levelList.add(myStack.pop());
			 }
			 resultList.add(levelList.get(levelList.size()-1).val);
			 for (int i = levelList.size()-1; i >= 0; i--) {
				if(levelList.get(i).right!=null)
				{
					myStack.push(levelList.get(i).right);
				}
				if(levelList.get(i).left!=null)
				{
					myStack.push(levelList.get(i).left);
				}
			}
			 
			 //get the TreeNode out
		 }
		 return resultList;
	    }
	 
}
