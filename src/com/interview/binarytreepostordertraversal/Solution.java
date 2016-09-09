package com.interview.binarytreepostordertraversal;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3

return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?
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
		root.left.left=new TreeNode(2);
		root.left.right=new TreeNode(6);
		List<Integer> finalResult=mySol.postorderTraversal(root);
		
	}
	static List<Integer> result=new ArrayList<>();	 
	 public List<Integer> postorderTraversal(TreeNode root) {
		 if(root==null)
		 {
			 return result;
		 }
		 if(root.left==null && root.right==null)
		 {
			 result.add(root.val);
			 return result;
		 }
		 result.clear();
		 traversePost(root);
	        return result;
	 }
	 public void traversePost(TreeNode root)
	 {
		 if(root==null)
		 {
			 return;
		 }
		 if(root.left!=null)
		 {
			 traversePost(root.left);
		 }
		 if(root.right!=null)
		 {
			 traversePost(root.right);
		 }
		 result.add(root.val);
	 }
}
