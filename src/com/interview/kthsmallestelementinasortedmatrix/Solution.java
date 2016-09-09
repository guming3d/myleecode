package com.interview.kthsmallestelementinasortedmatrix;

import java.util.Arrays;

/**
 * Given a n x n matrix where each of the rows and columns
 *  are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, 
not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.

Note:
You may assume k is always valid, 1 ≤ k ≤ n2.
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] testMatrix=new int[][]{{1,5,9},{10,11,13},{12,13,15}};
		findRound(testMatrix,3,8);
	}
	 public int kthSmallest(int[][] matrix, int k) {
		 
	        return 0;
	    }
	 
	 //NOT CORRECT
	 @Deprecated
	 public static int findRound(int[][] matrix,int matrixSize,int k)
	 {
		 int[] arrayNumber=new int[matrixSize*2-1];
		 //first create a array for final compare
		 for (int i = 0; i < arrayNumber.length; i++) {
			if(i<matrixSize){
				arrayNumber[i]=i+1;
			}else{
				arrayNumber[i]=matrixSize*2-1-i;
			}
		}
		 System.out.println(Arrays.toString(arrayNumber));

		 int currIndex=0;;

		 int totalIndex=0;
		 int subIndex=0;
		 for (int i = 1; i <= matrixSize*2 -1; i++) {
			 if(totalIndex+1<=k && k<=totalIndex+arrayNumber[i-1]){
				 currIndex=i-1;
				 subIndex=k-totalIndex-1;
				 System.out.println("The "+k+"is in "+i+" list");
				 break;
			 }else{
				 totalIndex+=arrayNumber[i-1];
			 }
		}
		 //Get the number in currIndex and find the number
		 int[] kthNumberList=new int[arrayNumber[currIndex]];
		 int lanIndex=0;
		 int verIndex=0;
		 for (int i = 0; i < kthNumberList.length; i++) {
			 lanIndex=Math.min(matrixSize-1, currIndex) - i ;
			 verIndex=currIndex-lanIndex;
			 kthNumberList[i]=matrix[lanIndex][verIndex];
		}
		 Arrays.sort(kthNumberList);
		 
		 
		 return kthNumberList[subIndex];
	 }
	 
	 
}
