package com.interview.binarytreepaths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5

All root-to-leaf paths are:

["1->2->5", "1->3"]
 * @author guming
 *
 */
public class Solution {

	static List<TreeNode> pathList=new ArrayList<>();
	static List<String> pathListFinal=new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root1=new TreeNode(1);
		root1.left=new TreeNode(2);
		root1.left.right=new TreeNode(5);
//		root1.left.left.right=new TreeNode(7);
		root1.right=new TreeNode(3);
		binaryTreePaths(root1).forEach(item->{
			System.out.println(item.toString());
		});
	}
	 public  static List<String> binaryTreePaths(TreeNode root) {
		 pathList.clear();
		 pathListFinal.clear();
		 
		 if(root==null)
		 {
			 pathListFinal.add(null);
			 return pathListFinal;
		 }
		 if(root.left==null && root.right==null)
		 {
			 List<String> resultList=new ArrayList<>();
			 resultList.add(String.format("%d", root.val));
			 return resultList;
		 }
		 traverseTree(root);
		 
	        return pathListFinal;
	    }
	 public static void traverseTree(TreeNode root){
		 if(root==null)
		 {
			 return;
		 }
		 pathList.add(root);
		 
		 if(root.left==null && root.right==null)
		 {
			 pathListFinal.add(getPathString(pathList));
		 }
		 
		 
		 if(root.left!=null)
		 {
			 traverseTree(root.left);
		 }
		 if(root.right!=null)
		 {
			 traverseTree(root.right);
		 }
		 pathList.remove(root);
		 
	 }
	 public static String getPathString(List<TreeNode> pathList)
	 {
		 StringBuilder finalStr=new StringBuilder();
		 for (int i = 0; i < pathList.size(); i++) {
			if(i!=pathList.size()-1)
			{
				finalStr.append(pathList.get(i).val+"->");
			}else{
				finalStr.append(pathList.get(i).val);
			}
		}
		 return finalStr.toString();
	 }
}
