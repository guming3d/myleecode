package com.interview.rotatefunction;
/**
 * 396. Rotate Function

    Total Accepted: 1644
    Total Submissions: 6060
    Difficulty: Easy

Given an array of integers A and let n to be its length.

Assume Bk to be an array obtained by rotating the array A k positions clock-wise, we define a "rotation function" F on A as follow:

F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].

Calculate the maximum value of F(0), F(1), ..., F(n-1).

Note:
n is guaranteed to be less than 105.

Example:

A = [4, 3, 2, 6]

F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26

So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.

 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution mySolution=new Solution();
		System.out.println(mySolution.maxRotateFunction(new int[]{4,3,2,6}));
	}
	public int maxRotateFunction(int[] A) {
		int maxNumber=Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i++) {
			int[] rotateN=rotateN(A,i);
			int currTotal=0;
			for (int j = 0; j < rotateN.length; j++) {
				currTotal+=j * rotateN[j];
			}
			if(currTotal>maxNumber)
			{
				maxNumber=currTotal;
			}
		}
        return maxNumber;
    }
	/**
	 * Rotate the arr clockwise n
	 * @param orig
	 * @param n
	 * @return
	 */
	public int[] rotateN(int[] orig,int n){
		int rotateNumber=n % orig.length;
		int[] targetArr=new int[orig.length];
		for (int i = orig.length-rotateNumber, k=0; i < orig.length; i++,k++) {
			targetArr[k]=orig[i];
		}
		for(int j=0;j<orig.length-rotateNumber;j++)
		{
			targetArr[rotateNumber+j]=orig[j];
		}
		return targetArr;
	}
	
	public int maxRotateFunction2(int[] A){
		
	}
}
