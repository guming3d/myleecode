package com.interview.uniquebinarysearchtrees;
/**
 * Given n, how many structurally unique BST's (binary search trees) 
 * that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numTrees(6));
	}
	/*
	 * 1 --> 1
	 * 2 --> 2
	 * 3 --> 5
	 * 4 -->15
	 * n --> 2*(f(n-1) + f(n-2) + ... + f(2)) + 1
	 */
	public static int numTrees(int n) {
		int[] totalTimes=new int[n+1];
		if(n==0)
		{
			return 0;
		}
		if(n==1)
		{
			return 1;
		}
		if(n==2)
		{
			return 2;
		}
		totalTimes[0]=0;
		totalTimes[1]=1;
		totalTimes[2]=2;
		totalTimes[3]=5;
		for (int i = 4; i <= n; i++) {
			int currTotal=0;
			int leftSize;
			int rightSize;
			int leftTotal;
			int rightTotal;
			for (int j = 1; j<=i  ; j++) {
				leftSize=j-1;
				rightSize=i-j;
				if(leftSize==0 || leftSize==1)
				{
					leftTotal=1;
				}else{
					leftTotal=totalTimes[leftSize];
				}
				
				if(rightSize==0 || rightSize==1)
				{
					rightTotal=1;
				}else{
					rightTotal=totalTimes[rightSize];
				}
				currTotal+=leftTotal*rightTotal;
				
			}
			
			totalTimes[i]=currTotal;
			
		}
		
        return totalTimes[n];
    }
}
