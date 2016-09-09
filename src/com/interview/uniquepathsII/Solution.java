package com.interview.uniquepathsII;
/**
 * Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. 
How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,

There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]

The total number of unique paths is 2.

Note: m and n will be at most 100.
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
       return 0; 
    }
	 public static int[][] generateMatrix(int[][] obstacleGrid){
		 int n=obstacleGrid.length;
		 int m=obstacleGrid[0].length;
		 
		 int[][] finalMatrix=new int[n][m];
		 for (int i = n-1; i >= 0; i--) {
			 for(int j = m-1; j>=0;j--)
			 {
				 if(i==n-1 && j==m-1)
				 {
					 if(obstacleGrid[i][j]==1)
					 {
						 finalMatrix[i][j]=-1;
					 }else{
					     finalMatrix[i][j]=1;    
					 }
				 }else{
					 if(obstacleGrid[i][j]==1)
					 {
						 finalMatrix[i][j]=-1;
					 }else{
						 int prevA=i+1>n-1?0:finalMatrix[i+1][j];
						 int prevB=j+1>m-1?0:finalMatrix[i][j+1];
						 
						 finalMatrix[i][j]=(prevA==-1?0:prevA) + (prevB==-1?0:prevB); 
					 }
					 
				 }
			 }
			
		}
		 
		 return finalMatrix;
	 }
}
