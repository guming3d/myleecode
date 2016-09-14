package com.interview.populatingnextrightpointersineachnode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 116. Populating Next Right Pointers in Each Node

    Total Accepted: 101397
    Total Submissions: 276069
    Difficulty: Medium

Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

    You may only use constant extra space.
    You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).

For example,
Given the following perfect binary tree,

         1
       /  \
      2    3
     / \  / \
    4  5  6  7

After calling your function, the tree should look like:

         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL

 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	Stack<TreeLinkNode> levelStack=new Stack<>();
	 public void connect(TreeLinkNode root) {
	        if(root==null)
	        {
	        	return;
	        }
	        if(root.left==null && root.right==null)
	        {
	        	root.next=null;
	        	return;
	        }
	        levelStack.clear();
	        levelStack.push(root);
	        List<TreeLinkNode> levelList=new ArrayList<>();
	        while(!levelStack.isEmpty())
	        {
	        	levelList.clear();
	        	while(!levelStack.isEmpty())
	        	{
	        		levelList.add(levelStack.pop());
	        	}
	        	for (int i = 0; i < levelList.size(); i++) {
					if(i==levelList.size()-1)
					{
						levelList.get(i).next=null;
					}else{
						levelList.get(i).next=levelList.get(i+1);
					}
				}
	        	for (int i = levelList.size()-1; i >=0; i--) {
	        		if(levelList.get(i).right!=null)
	        		{
	        			levelStack.push(levelList.get(i).right);
	        		}
	        		if(levelList.get(i).left!=null)
	        		{
	        			levelStack.push(levelList.get(i).left);
	        		}
				}
	        	
	        }
	    }
}
