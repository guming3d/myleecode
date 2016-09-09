package com.interview.singlenumber2;

import java.util.Arrays;

/**
 *  Given an array of integers, every element appears
 *   three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity.
 Could you implement it without using extra memory? 
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		singleNumber(new int[]{3,3,3,6,6,6,8});
	}
	public static int singleNumber(int[] nums) {
		Arrays.sort(nums);
		int i=0;
		int currNum=nums[0];
		int tmpSize=0;
		while(i<=nums.length-3)
		{
			tmpSize=1;
			int j=i+1;
			while(nums[j]==nums[i] && j<nums.length-1)
			{
				tmpSize++;
				j++;
			}
			if(tmpSize!=3)
			{
				return nums[i];
			}else{
				
				i=j;
			}
		}
		
		
        return nums[i];
    }
}
