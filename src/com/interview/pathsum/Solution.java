package com.interview.pathsum;

import com.interview.pathsum.TreeNode;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * @author mcgu
 *
 */
public class Solution {
	static int sumData=0;
	static boolean result=false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root=new TreeNode(4);
		root.left=new TreeNode(2);
		root.right=new TreeNode(2);
		root.right.right=new TreeNode(2);
		hasPathSum(root,8);
	}
	public static boolean hasPathSum(TreeNode root, int sum) {
		sumData=0;
		result=false;
		traverseBinTree(root,sum);
		return result;
        
    }
	public static void traverseBinTree(TreeNode root,int sum)
	{
		if(root==null)
		{
			return;
		}
		
		if(root.left==null && root.right==null)
		{
			if(sumData+root.val==sum)
			{
				System.out.print("Found the Node!!!");
				result=true;
			}
			System.out.println(root.val);
			return;
		}
		
		if(root.left!=null)
		{
			sumData+=root.val;
			traverseBinTree(root.left,sum);
			sumData-=root.val;
		}
		
		if(root.right!=null)
		{
			sumData+=root.val;
			traverseBinTree(root.right,sum);
			sumData-=root.val;
		}
	}
}
