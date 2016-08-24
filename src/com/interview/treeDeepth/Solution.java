//package com.interview.treeDeepth;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Definition for a binary tree node.
// * public class TreeNode {
// *     int val;
// *     TreeNode left;
// *     TreeNode right;
// *     TreeNode(int x) { val = x; }
// * }
// * Given a binary tree, find its maximum depth.
//
//The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
// */
//
////TODO:
//public class Solution {
//
//	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		TreeNode root=new TreeNode(15);
//		root.left=new TreeNode(13);
//		root.left.right=new TreeNode(12);
//		root.left.left=new TreeNode(11);
//		root.right=new TreeNode(5);
//		root.right.left=new TreeNode(3);
//		root.right.left.right=new TreeNode(33);
//		new Solution().maxDepth(root);
//
//	}
//public  int maxDepth(TreeNode root) {
//	int tmpDeepth=0;
//	int maxDeepth=0;
//	List deepthList=new ArrayList<Integer>();
//	
//	traverseTree(root,deepthList);
//	System.out.println(maxDeepth);
//        return maxDeepth;
//    }
//
//
//public List<Integer> traverseTree(TreeNode root,List<Integer> deepthList)
//{	
//	System.out.println("current Node is "+root.val);
//	if(root.left==null && root.right==null){
//		deepthList.add(tmpDeepth);
//		tmpDeepth--;
//		return deepthList;
//	}
//	
//	if(root.left != null)
//	{
//		tmpDeepth++;
//		traverseTree(root.left,deepthList);
//		
//	}
//	
//	if(root.right != null)
//	{
//		tmpDeepth++;
//		traverseTree(root.right,deepthList);
//	}
//	return deepthList;
//}
//}
