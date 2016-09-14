package com.interview.minimumpathsum;

import java.util.Iterator;
import java.util.Stack;

/**
 * 64. Minimum Path Sum

    Total Accepted: 84158
    Total Submissions: 231751
    Difficulty: Medium

Given a m x n grid filled with non-negative numbers, 
find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
 * @author mcgu
 *
 */
public class Solution {

	// Time Limit Exceeded
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution mySolution=new Solution();
//		int[][] testArray=new int[][]{{1,2,3,4},
//									   {5,6,7,8},
//									   {9,10,11,12},
//									   {13,14,15,16}};
		int[][] testArray=new int[][]{{7,1,3,5,8,9,9,2,1,9,0,8,3,1,6,6,9,5},
									  {9,5,9,4,0,4,8,8,9,5,7,3,6,6,6,9,1,6},
			                          {8,2,9,1,3,1,9,7,2,5,3,1,2,4,8,2,8,8},
			                          {6,7,9,8,4,8,3,0,4,0,9,6,6,0,0,5,1,4},
			                          {7,1,3,1,8,8,3,1,2,1,5,0,2,1,9,1,1,4},
			                          {9,5,4,3,5,6,1,3,6,4,9,7,0,8,0,3,9,9},
			                          {1,4,2,5,8,7,7,0,0,7,1,2,1,2,7,7,7,4},
			                          {3,9,7,9,5,8,9,5,6,9,8,8,0,1,4,2,8,2},
			                          {1,5,2,2,2,5,6,3,9,3,1,7,9,6,8,6,8,3},
			                          {5,7,8,3,8,8,3,9,9,8,1,9,2,5,4,7,7,7},
			                          {2,3,2,4,8,5,1,7,2,9,5,2,4,2,9,2,8,7},
			                          {0,1,6,1,1,0,0,6,5,4,3,4,3,7,9,6,1,9}};
//		TreeNode root=mySolution.constructBinaryTree(testArray, 0, 0);
//		mySolution.traversePreorder(root);
	    mySolution.minPathSum2(testArray);
		System.out.println(mySolution.minPathSum2(testArray));
	}
	 
	public int minPathSum(int[][] grid) {
		treeNodeStack.clear();
		minNumber=Integer.MAX_VALUE;
		TreeNode root=constructBinaryTree(grid, 0, 0);
		traversePreorder(root);
		return minNumber;
	    }
	
	static Stack<TreeNode> treeNodeStack=new Stack<>();
	static int minNumber=Integer.MAX_VALUE;
	public void traversePreorder(TreeNode root)
	{
		treeNodeStack.push(root);
		if(root.left==null && root.right==null)
		{
			System.out.println("--->"+root.val);
			//get the Maximu number in stack
			int totalNum=0;
			Iterator<TreeNode> treeIter=treeNodeStack.stream().iterator();
			while(treeIter.hasNext())
			{
				totalNum+=treeIter.next().val;
			}
			System.out.println("rount count is "+totalNum);
			if(totalNum<minNumber)
			{
				minNumber=totalNum;
			}
			
		}else{
			if(root.left!=null)
			{
				traversePreorder(root.left);
			}
			if(root.right!=null)
			{
				traversePreorder(root.right);
			}
		}
		treeNodeStack.pop();
	}
    public TreeNode constructBinaryTree(int[][] grid,int x,int y)
    {
    	TreeNode root=new TreeNode(grid[x][y]);
    	if(x==grid.length-1)
    	{
    		root.left=null;
    		if(y<grid[0].length-1)
    		{
    			//adding the left node to all the right list
    			TreeNode head=root;
    			for (int i = y+1; i < grid[0].length; i++) {
					head.right=new TreeNode(grid[x][i]);
					head=head.right;
				}
    			return root;
    		}
    	}else{
    		root.left=constructBinaryTree(grid,x+1,y);
    	}
    	
    	if(y==grid[0].length-1)
    	{
    		root.right=null;
    		if(x<grid.length)
    		{
    			//adding left node to all the left list
    			TreeNode head=root;
    			for (int i = x+1; i < grid.length; i++) {
					head.left=new TreeNode(grid[i][y]);
					head=head.left;
				}
    			return root;
    		}
    	}else{
    		root.right=constructBinaryTree(grid, x, y+1);
    	}
    	return root;
    }
    
    /*
     * Construct a 2 dimention array, start from the target, fill the array with smallest path number, return first one
     */
    public int minPathSum2(int[][] grid) {
		int[][] finalPath=constructSmallPathArray(grid);
		return finalPath[0][0];
	 }
    public int[][] constructSmallPathArray(int[][] grid)
    {
    	int[][] smallPath=new int[grid.length][grid[0].length];
    	for (int i = grid.length-1; i >= 0; i--) {
			for (int j = grid[0].length-1; j >=0 ; j--) {
				if(i==grid.length-1 && j==grid[0].length-1)
				{
					//starting point
					smallPath[i][j]=grid[i][j];
				}else if(i==grid.length-1){
					smallPath[i][j]=grid[i][j]+smallPath[i][j+1];
				}else if(j==grid[0].length-1)
				{
					smallPath[i][j]=grid[i][j]+smallPath[i+1][j];
				}else{
					smallPath[i][j]=grid[i][j]+Math.min(smallPath[i+1][j], smallPath[i][j+1]);
				}
			}
		}
    	return smallPath;
    }
    
}
