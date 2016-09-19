package com.interview.lowestcommonancestorofabinarytree;
/**
 * 236. Lowest Common Ancestor of a Binary Tree

    Total Accepted: 59306
    Total Submissions: 203565
    Difficulty: Medium

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes 
v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4

For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, 
since a node can be a descendant of itself according to the LCA definition.
 * @author mcgu
 *
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

// TODO Auto-generated method stub
public class Solution{
	
	public static void main(String[] args) {
		Solution mySolution=new Solution();
		TreeNode root=new TreeNode(3);
		root.left=new TreeNode(5);
		root.right=new TreeNode(1);
		TreeNode leftNode=new TreeNode(6);
		TreeNode rightNode=new TreeNode(4);
		root.left.left=leftNode;
		root.left.right=new TreeNode(2);
		root.left.right.left=new TreeNode(7);
		root.left.right.right=rightNode;
		
		root.right.left=new TreeNode(0);
		root.right.right=new TreeNode(8);
		
		mySolution.lowestCommonAncestor(root, leftNode, rightNode);
	}
	
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		path.clear();
		finalPath.clear();
		List<TreeNode> leftStack=new Stack<>();
		if(findTarget(root,p))
		{
//			TreeNode[] resultTreeList=(TreeNode[])finalPath.toArray();
//			for (int i = 0; i < resultTreeList.length; i++) {
//				leftStack.push(resultTreeList[i]);
//			}
			leftStack.addAll(finalPath);
			
		}
		path.clear();
		finalPath.clear();
		Stack<TreeNode> rightStack=new Stack<>();
		if(findTarget(root,q))
		{
//			TreeNode[] resultTreeList=(TreeNode[])finalPath.toArray();
//			for (int i = 0; i < resultTreeList.length; i++) {
//				rightStack.push(resultTreeList[i]);
//			}
			rightStack.addAll(finalPath);
		}
		
		TreeNode parentNode=root;
		for(int i=0;i<Math.min(leftStack.size(),rightStack.size());i++)
		{
			if(leftStack.get(i)==rightStack.get(i))
			{
				parentNode=leftStack.get(i);
			}else{
				break;
			}
		}
		
		System.out.println("End");
		return parentNode;
    }
//Stack<TreeNode> path=new Stack<>();
//Stack<TreeNode> finalPath=new Stack<>();
List<TreeNode> path=new ArrayList<>();
List<TreeNode> finalPath=new ArrayList<>();

public boolean findTarget(TreeNode root,TreeNode target)
{
	path.add(root);
	boolean result=false;
	
	if(root==target)
	{
		finalPath.addAll(path);
		path.remove(path.size()-1);
		return true;
	}
	if(root.left!=null)
	{
		result=findTarget(root.left,target);
		if(result==true)
		{
			path.remove(path.size()-1);
			return true;
		}
	}
	if(root.right!=null)
	{
		result=findTarget(root.right,target);
		if(result==true)
		{
			path.remove(path.size()-1);
			return true;
		}
	}
	path.remove(path.size()-1);
	return result;
}
}
