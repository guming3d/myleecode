package com.interview.uniquepaths;
/**
 * A robot is located at the top-left corner of a m x n grid 
 * (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. 
The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 3 x 7 grid. How many possible unique paths are there? 
 * @author mcgu
 *
 */
public class Solution {

	/**
	 * After some time investigation, I found the possibilities of the grid is the pascal trigle 
	 * [
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generateMatrix(3,2);
	}
	 public int uniquePaths(int m, int n) {
	        return 9;
	    }
	 public static int[][] generateMatrix(int m, int n){
		 int[][] finalMatrix=new int[n][m];
		 for (int i = n-1; i >= 0; i--) {
			 for(int j = m-1; j>=0;j--)
			 {
				 if(i==n-1 && j==m-1)
				 {
					 finalMatrix[i][j]=1;
				 }else{
					 int prevA=i+1>n-1?0:finalMatrix[i+1][j];
					 int prevB=j+1>m-1?0:finalMatrix[i][j+1];
					 finalMatrix[i][j]=prevA + prevB;
				 }
			 }
			
		}
		 
		 return finalMatrix;
	 }
}
