package com.interview.plusone;

import java.util.Arrays;

/**
 * Given a non-negative number represented as an array of digits, 
 * plus one to the number.

The digits are stored such that the most significant digit is 
at the head of the list.

Subscribe to see which companies asked this question

 * @author guming
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] testArr={9,9,9};
		System.out.println(Arrays.toString(plusOne(testArr)));
	}
	public static int[] plusOne(int[] digits) {
		if(digits.length==0)
		{
			return null;
		}
		
		boolean needIncrease=false;
		for (int i =digits.length-1 ; i >=0 ; i--) {
			if(i==digits.length-1)
			{
				//right most number adding one
				if(digits[i]+1<10)
				{
					digits[i]+=1;
					needIncrease=false;
					break;
				}else
				{
					digits[i]=0;
					needIncrease=true;
					continue;
				}
				
			}
			if(needIncrease==true)
			{
				//right most number adding one
				if(digits[i]+1<10)
				{
					digits[i]+=1;
					needIncrease=false;
					break;
				}else
				{
					digits[i]=0;
					needIncrease=true;
					continue;
				}
			}
		}
		
		if(needIncrease==true)
		{
			//need to add a high number on left side
			int [] newArray=new int[digits.length+1];
			newArray[0]=1;
			for (int i = 1; i < newArray.length; i++) {
				newArray[i]=digits[i-1];
			}
			return newArray;
		}
        return digits;
    }
}
