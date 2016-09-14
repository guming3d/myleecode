package com.interview.constructbinarytreefrompreorderandinordertraversal;
/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal

    Total Accepted: 75299
    Total Submissions: 251670
    Difficulty: Medium

Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree. 
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution mySolution=new Solution();
		//mySolution.subArray(new int[]{1, 2, 3,4,5},0,2);
		TreeNode root=mySolution.buildTree(new int[]{3,1,2,4}, new int[]{1,2,3,4});
		System.out.println("aaa");
		
	}
	 public TreeNode buildTree(int[] preorder, int[] inorder) {
		 	if(preorder.length==0 || inorder.length==0)
		 	{
		 		return null;
		 	}
	        if(preorder.length==1)
	        {
	        	return new TreeNode(preorder[0]);
	        }
	        TreeNode root=new TreeNode(preorder[0]);
	        int rootLocation=0;
	        for(int i=0;i<inorder.length;i++)
	        {
	        	if(inorder[i]==preorder[0])
	        	{
	        		break;
	        	}
	        	rootLocation++;
	        }
	        if(rootLocation==0)
	        {
	        	root.left=null;
	        }else{
	        	int[] subLeft=subArray(inorder,0,rootLocation-1);	
	        	int[] subpreLeft=subArray(preorder,1,subLeft.length);
	        	root.left=buildTree(subpreLeft,subLeft);
	        }
	        
	        if(rootLocation==inorder.length-1)
	        {
	        	root.right=null;
	        }else{
	        	int[] subRight=subArray(inorder,rootLocation+1,inorder.length-1);	
	        	int[] subpreright=subArray(preorder,subRight.length,preorder.length-1);
	        	root.right=buildTree(subpreright,subRight);
	        }
	        
	        return root;
	        
	        
	        
	    }
	 public int[] subArray(int[] orig,int start,int end)
	 {
		 int[] newArray=new int[end - start+1];
		 for (int i = 0; i <= end - start; i++) {
			newArray[i]=orig[start+i];
		}
		 return newArray;
	 }
}
