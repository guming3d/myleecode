package com.interview.kthsmallestelementinabst;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note:
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations)
 often and you need to find the kth smallest frequently? 
 How would you optimize the kthSmallest routine?
 * @author mcgu
 *
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {

	static List<Integer> sortedList=new ArrayList<>();
	static int index=0;
	static int finalResult=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root=new TreeNode(2);
		root.left=new TreeNode(1);
		root.right=new TreeNode(12);
		root.right.left=new TreeNode(7);
		System.out.println(kthSmallest2(root,3));
		
	}
	 public static int kthSmallest(TreeNode root, int k) {
		 sortedList.clear();
	     index=k; 
	     finalResult=0;
	     traversemiddle(root);
		 return finalResult;
	    }
	 public static void traversemiddle(TreeNode root)
	 {
		 if(root.left!=null)
		 {
			 traversemiddle(root.left);
		 }
		 sortedList.add(root.val);
		 if(sortedList.size()==index)
		 {
			 finalResult=root.val;
			 return;
		 }
		 if(root.right!=null)
		 {
			 traversemiddle(root.right);
		 }	 
	 }
	 //None recursive version
	 static Stack<TreeNode> nodeStack=new Stack<>();
	 public static int kthSmallest2(TreeNode root, int k) {
		 sortedList.clear();
	     index=k; 
	     finalResult=0;
	     nodeStack.clear();
	     traversemiddle2(root);
		 return finalResult;
	    }
	 public static void traversemiddle2(TreeNode root)
	 {
		 nodeStack.push(root);
		 TreeNode currNode;
		 while(!nodeStack.isEmpty())
		 {
			 currNode=nodeStack.pop();
			 if(currNode.left==null && currNode.right==null)
			 {
				 sortedList.add(currNode.val);
				 if(sortedList.size()==index)
				 {
					 finalResult=currNode.val;
					 return;
				 }
				 continue;
				 
			 }
			 if(currNode.right!=null)
			 {
				 nodeStack.push(currNode.right);
			 }
			 TreeNode tmpNode=new TreeNode(currNode.val);
			 tmpNode.left=null;
			 tmpNode.right=null;
			 nodeStack.push(tmpNode);
			 if(currNode.left!=null)
			 {
				 nodeStack.push(currNode.left);
			 }
		 }
		 return;
	 }
	 
}
