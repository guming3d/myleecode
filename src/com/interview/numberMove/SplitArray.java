package com.interview.numberMove;

import java.util.Arrays;

/**
 * Given an array full of integers positive or negative, write a method to move every negative number
 * to the left and every positive number to the right. Take into account that the order of these
 * elements among the same group(positive or negative) into the array doesn't care.
 *
 * Input: [1,2,3,-1-,2,-3] Output: [-2,-1,-3,2,3,1]
 *
 */
public class SplitArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] testList={12,2,-4,-6,6,78,-9};
		System.out.println(Arrays.toString(new SplitArray().splitArray(testList)));
		
	}
	public int[] splitArray(int[] input){
		for(int i=input.length-1;i>0;i--)
		{
			if(input[i]<0)
			{
				for(int j=0;j<i;j++)
				{
					if(input[j]>0)
					{
						exchangeNumber(input, i, j);
						break;
					}
				}	
			}
		}
		return input;
	}
	
	public void exchangeNumber(int[] input, int i, int j){
		int tmp=input[i];
		input[i]=input[j];
		input[j]=tmp;
	}

}
