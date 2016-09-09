package com.interview.houserobberIII;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 337. House Robber III

    Total Accepted: 22796
    Total Submissions: 57450
    Difficulty: Medium

The thief has found himself a new place for his thievery again. 
There is only one entrance to this area, called the "root." 
Besides the root, each house has one and only one parent house. 
After a tour, the smart thief realized that "all houses in this place forms a binary tree". 
It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:

     3
    / \
   2   3
    \   \ 
     3   1

Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.

Example 2:

     3
    / \
   4   5
  / \   \ 
 1   3   1

Maximum amount of money the thief can rob = 4 + 5 = 9. 
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution mySolution=new Solution();
		TreeNode root=new TreeNode(3);
		root.left=new TreeNode(4);
		root.right=new TreeNode(5);
		root.left.left=new TreeNode(1);
		root.left.right=new TreeNode(3);
		root.right.right=new TreeNode(1);
//		root.right.right=new TreeNode(1);
		
		mySolution.rob(root);
	}
	static Stack<TreeNode> binaryTreeStack=new Stack<>();
	static List<Integer> levelTotalList=new ArrayList<>();
	public int rob(TreeNode root) {
		if(root==null)
		{
			return 0;
		}
		//first walk through the tree to generate a array List contains the total number in each level
		binaryTreeStack.clear();
		levelTotalList.clear();
		binaryTreeStack.push(root);
		walkthroughTree(root);
		
		//find the largest number in previous arrays.
		int[] numberArray=new int[levelTotalList.size()];
		for (int i = 0; i < numberArray.length; i++) {
			numberArray[i]=levelTotalList.get(i);
		}
		
		int[] maxSelectSum=new int[numberArray.length];
		int[] maxNoneSelectSum=new int[numberArray.length];
 		if(numberArray.length==1)
		{
			//only one level
			return numberArray[0];
		}
		if(numberArray.length==2)
		{
			return Math.max(numberArray[0], numberArray[1]);
		}
		maxSelectSum[0]=numberArray[0];
		maxNoneSelectSum[0]=0;
		maxSelectSum[1]=numberArray[1];
		maxNoneSelectSum[1]=maxSelectSum[0];
		
		for (int i = 2; i < maxSelectSum.length; i++) {
			maxSelectSum[i] = maxNoneSelectSum[i - 1] + numberArray[i];

			int maxPrev = 0;
			for (int j = 0; j <= i - 1; j++) {
				if (maxSelectSum[j] > maxPrev) {
					maxPrev = maxSelectSum[j];
				}
			}
			maxNoneSelectSum[i] = maxPrev;
			// maxSelectSum[i-1];
		}
		
        return Math.max(maxSelectSum[numberArray.length-1], maxNoneSelectSum[numberArray.length-1]);
    }
	
	public void walkthroughTree(TreeNode root)
	{
		int tmpTotal=0;
		List<TreeNode> levelList=new ArrayList<>();
		int index=0;
		while(!binaryTreeStack.isEmpty())
		{
			tmpTotal=0;
			levelList.clear();
			while(!binaryTreeStack.isEmpty())
			{
				TreeNode currNode=binaryTreeStack.pop();
				levelList.add(currNode);
			}
			
			for(TreeNode item:levelList)
			{
				tmpTotal+=item.val;
				if(item.left!=null)
				{
					binaryTreeStack.push(item.left);
				}
				if(item.right!=null)
				{
					binaryTreeStack.push(item.right);
				}
			}
			levelTotalList.add(tmpTotal);
		}
		
		
	}
	
	
}
