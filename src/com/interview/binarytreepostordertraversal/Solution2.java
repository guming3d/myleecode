package com.interview.binarytreepostordertraversal;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class Solution2 {
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution2 mySol=new Solution2();
		TreeNode root=new TreeNode(10);
		root.left=new TreeNode(5);
		root.right=new TreeNode(15);
		root.left.left=new TreeNode(2);
		root.left.right=new TreeNode(6);
		List<Integer> finalResult=mySol.postorderTraversal(root);
		
	}
	static Stack<TreeNode> postStack=new Stack<>();
	static List<Integer> result=new ArrayList<>();	 
	public List<Integer> postorderTraversal(TreeNode root) {
		postStack.clear();
		result.clear();
		if(root==null)
		 {
			 return result;
		 }
		 if(root.left==null && root.right==null)
		 {
			 result.add(root.val);
			 return result;
		 }
		 postStack.push(root);
		 while(!postStack.isEmpty())
		 {
			 TreeNode currNode=postStack.pop();
			 if(currNode.left==null && currNode.right==null)
			 {
				 result.add(currNode.val);
			 }else{
				 TreeNode tmpNode=new TreeNode(currNode.val);
				 tmpNode.left=null;
				 tmpNode.right=null;
				 postStack.push(tmpNode);
				 if(currNode.right!=null)
				 {
					 postStack.push(currNode.right);
				 }
				 if(currNode.left!=null)
				 {
					 postStack.push(currNode.left);
				 }
			 }
			 
		 }
		 
		return result;
	}
}
