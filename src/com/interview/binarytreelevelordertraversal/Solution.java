package com.interview.binarytreelevelordertraversal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
 * (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
 * @author mcgu
 *
 */
public class Solution {
	static int level=0; //var to mark the level;
	static Map<Integer, ArrayList<Integer>> levelMap=new HashMap<Integer, ArrayList<Integer>>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root=new TreeNode(3);
		root.left=new TreeNode(9);
		root.right=new TreeNode(20);
		root.right.left=new TreeNode(15);
		root.right.right=new TreeNode(7);
		Solution mysolution=new Solution();
		mysolution.levelOrderBottom(root);
		
	}
	 public List<List<Integer>> levelOrderBottom(TreeNode root) {
		 level=0;
		 levelMap.clear();
		 traverseTree(root);
		 List<List<Integer>> finalList=new ArrayList<>();
		 for (int i = levelMap.size()-1; i >= 0; i--) {
			finalList.add(levelMap.get(i+1));
		}
		 return finalList;
		 
	    }
	 public void traverseTree(TreeNode root)
	 {
		 level++;
		 if(root==null)
		 {
			 return;
		 }
		 if(!levelMap.containsKey(level))
		 {
			 levelMap.put(level, new ArrayList<Integer>());
		 }
		 levelMap.get(level).add(root.val);
		 if(root.left != null)
		 {
			 traverseTree(root.left);
		 }
		 
		 if(root.right != null)
		 {
			 traverseTree(root.right);
		 }
		 level--;
	 }
}
