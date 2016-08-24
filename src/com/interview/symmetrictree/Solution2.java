package com.interview.symmetrictree;
import java.util.ArrayList;
import java.util.List;

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

public class Solution2 {

	 static List<Integer> rightTraverseList=new ArrayList<>();
	 static List<Integer> leftTraverseList=new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root=new TreeNode(4);
		root.left=new TreeNode(2);
		root.right=new TreeNode(2);
		root.right=new TreeNode(2);
//		root.left.left=new TreeNode(1);
//		root.right=new TreeNode(7);
//		root.right.left=new TreeNode(6);
//		root.right.right=new TreeNode(9);
//		root.right.left.right=new TreeNode(33);
		Solution2 mysolution=new Solution2();
				
		System.out.println(mysolution.isSymmetric(root));
	}
	 public boolean isSymmetric(TreeNode root) {
		 if(root==null)
		 {
			 return true;
		 }
		 
		 if(root.left==null && root.right==null)
		 {
			 return true;
		 }
		 
		 
		 
		 rightTraverseList.clear();
		 leftTraverseList.clear();
		 //Right child --> node --> Left child
		 traverseTreeRight(root);
		 System.out.println("------------------");
		 //Left child --> node --> Right child
		 traverseTreeLeft(root);
		 System.out.println(rightTraverseList.size());
		 
		 for (int i = 0; i < leftTraverseList.size(); i++) {
			if(leftTraverseList.get(i)!=rightTraverseList.get(i))
			{
				return false;
			}
		}
		 
	        return true;
	    }
	 
	 	 
	 public void traverseTreeRight(TreeNode root)
	 {
		 if(root==null)
		 {
			 return;
		 }
		 
		 
		//recursive reverse the child
		 if(root.right!=null)
		 {
			 traverseTreeRight(root.right);
		 }else
		 {
			 rightTraverseList.add(null);
		 }
		 
		 if(root.left!=null)
		 {
			 traverseTreeRight(root.left);
		 }else
		 {
			 rightTraverseList.add(null);
		 }
		 
		 System.out.println(root.val+"->");
		 rightTraverseList.add(root.val);
		 
	 }
	 
	 public void traverseTreeLeft(TreeNode root)
	 {
		 if(root==null)
		 {
			 return;
		 }
		 
		//recursive reverse the child
		 if(root.left!=null)
		 {
			 traverseTreeLeft(root.left);
		 }else
		 {
			 leftTraverseList.add(null);
		 }
 
		 
		 if(root.right!=null)
		 {
			 traverseTreeLeft(root.right);
		 }else
		 {
			 leftTraverseList.add(null);
		 }
		 
		 System.out.println(root.val+"->");
		 leftTraverseList.add(root.val);
		 
	 }
}
