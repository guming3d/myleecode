package com.interview.minimumdepthofbinarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the
 shortest path from the root node down to the nearest leaf node.
 * @author guming
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root1=new TreeNode(10);
		root1.left=new TreeNode(9);
//		root1.left.left=new TreeNode(8);
//		root1.left.left.right=new TreeNode(7);
		System.out.println(minDepth(root1));
	}
public static int minDepth(TreeNode root) {
	Stack<TreeNode> treeStack=new Stack<>();
	int currentDepth=0;
	if(root==null)
	{
		return 0;
	}
	treeStack.push(root);
	while(!treeStack.isEmpty())
	{
		List<TreeNode> levelList=new ArrayList<>();
		while(!treeStack.isEmpty())
		{
			TreeNode currNode=treeStack.pop();
			if(currNode.left==null && currNode.right==null)
			{
				//current node is leaf
				return currentDepth+1;
			}else{
				levelList.add(currNode);
			}
		}
		levelList.forEach(item->{
			if(item.left!=null)
			{
				treeStack.push(item.left);
			}
			if(item.right!=null)
			{
				treeStack.push(item.right);
			}
		});
		currentDepth++;
		
	}
	return currentDepth;
    }
}
