package com.interview.symmetrictree;
/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
   Note:
Bonus points if you could solve it both recursively and iteratively.

 */
import com.interview.symmetrictree.TreeNode;

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
		Solution mysolution=new Solution();
		mysolution.traverseTree(root);
		System.out.println("------------------");
		mysolution.reverseTree(root);
		mysolution.traverseTree(root);
	}
	 public boolean isSymmetric(TreeNode root) {
		 //reverse the whole tree
		 
		 //compare the reversed tree with old one
	        return false;
	    }
	 
	 public void reverseTree(TreeNode root)
	 {
		 if(root==null)
		 {
			 return; 
		 }
		 
		//reverse the child
		 TreeNode tmpNode=root.left;
		 root.left=root.right;
		 root.right=tmpNode;
		 
		 //recursive reverse the child
		 if(root.left!=null)
		 {
			 reverseTree(root.left);
		 }
		 
		 if(root.right!=null)
		 {
			 reverseTree(root.right);
		 }
		 
		 
		 return;
	 }
	 
	 public void traverseTree(TreeNode root)
	 {
		 if(root==null)
		 {
			 return;
		 }
		 
		 
		//recursive reverse the child
		 if(root.left!=null)
		 {
			 traverseTree(root.left);
		 }
		 
		 if(root.right!=null)
		 {
			 traverseTree(root.right);
		 }
		 System.out.println(root.val+"->");
	 }
}
