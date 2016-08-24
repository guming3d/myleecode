package com.interview.moveZero;

import java.util.Arrays;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] testNum={0, 1, 0, 3, 12};
		new Solution().moveZeroes(testNum);
		
	}
	public void moveZeroes(int[] nums) {
        for(int i=0;i<nums.length;i++)
        {
        	if(nums[i]!=0)
        	{
        		for(int j=0;j<i;j++)
        		{
        			if(nums[j]==0)
        			{
        				reverse(nums,i,j);
        			}
        		}
        	}
        	
        }
        System.out.println(Arrays.toString(nums));
    }
	public void reverse(int[] nums,int i, int j)
	{
		if((i>nums.length-1)||(j > nums.length-1))
		{
			return;
		}
		int tmp=nums[i];
		nums[i]=nums[j];
		nums[j]=tmp;
	}
}
