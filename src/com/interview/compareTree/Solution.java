package com.interview.compareTree;

public class Solution {
	public static void main(String args[])
	{
		TreeNode root1=new TreeNode(10);
		TreeNode root2=new TreeNode(10);
		
		root1.left=new TreeNode(9);
		root2.left=new TreeNode(9);
		
		root1.left.left=new TreeNode(8);
		root2.left.left=new TreeNode(8);
		
		root1.left.left.right=new TreeNode(7);
		
		System.out.println("Two trees are "+(isSameTree(root1,root2)? "same":"not same"));
		
	}
	 public static  boolean isSameTree(TreeNode p, TreeNode q) {
		 if(p==null && q!=null)
		 {
			 return false;
		 }
		 else if(p!=null && q==null)
		 {
			 return false;
		 }else  if(p==null && q==null)
		 {
			 return true;
		 }else  if(p.val!=q.val)
		 {
			 return false;
		 }
		 
		 if( !isSameTree( p.left, q.left) )
		 {
			 return false;
		 }
		 
		 if( !isSameTree( p.right, q.right) )
		 {
			 return false;
		 }
	        
		 return true;
	    }
}
