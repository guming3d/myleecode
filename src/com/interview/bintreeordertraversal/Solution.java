package com.interview.bintreeordertraversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import com.interview.bintreeordertraversal.TreeNode;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]
 利用一个堆栈，从根节点开始，先压栈，然后出栈，栈中间保存当前层级的所有节点，然后把当前层级的下一层级的节点压栈。
 
 * @author guming
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root1=new TreeNode(10);
		
		root1.left=new TreeNode(9);
		root1.right=new TreeNode(10);
		root1.left.left=new TreeNode(8);
		root1.left.right=new TreeNode(7);
		levelOrder(root1);
	}
	public  static List<List<Integer>> levelOrder(TreeNode root) {
		if(root==null)
		{
			return new ArrayList<>();
		}
		
		List<List<TreeNode>> orderList=new ArrayList<>();
		List<List<Integer>> orderListValue=new ArrayList<>();
		Stack<TreeNode> treeStack=new Stack<>();
		treeStack.push(root);
		int level=0;
		while(!treeStack.isEmpty())
		{
			//first get all the node in current level
			List<TreeNode> levelList=new ArrayList<>();
			List<Integer> levelListValue=new ArrayList<>();
			while(!treeStack.isEmpty())
			{
				TreeNode currNode=treeStack.pop();
				levelList.add(currNode);
				levelListValue.add(currNode.val);
			}
			orderList.add(levelList);
			orderListValue.add(levelListValue);
			
			for (int i = levelList.size()-1 ; i >= 0; i--) {
				
				if(levelList.get(i).right!=null)
				{
					treeStack.push(levelList.get(i).right);
				}
				
				if(levelList.get(i).left!=null)
				{
					treeStack.push(levelList.get(i).left);
				}
			}
			
		}
				
		
        return orderListValue;
    }

}
