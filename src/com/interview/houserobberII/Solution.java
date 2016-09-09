package com.interview.houserobberII;

import java.util.Arrays;

/**
 * Note: This is an extension of House Robber.

After robbing those houses on that street, the thief 
has found himself a new place for his thievery so 
that he will not get too much attention. This time, 
all houses at this place are arranged in a circle. 
That means the first house is the neighbor of the last one. 
Meanwhile, the security system for these houses remain the 
same as for those in the previous street.

Given a list of non-negative integers representing the 
amount of money of each house, determine the maximum 
amount of money you can rob tonight without alerting the police.
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution mySolution=new Solution();
		
		mySolution.rob(new int[]{1,7,2,6,3,5});

	}
	public int rob(int[] nums) {

		if(nums.length==0)
		{
			return 0;
		}
		if(nums.length==1)
		{
			return nums[0];
		}
		if(nums.length==2)
		{
		    return Math.max(nums[0],nums[1]);
		}
		int max1=robSimple(Arrays.copyOfRange(nums, 1, nums.length));
		int max2=robSimple(Arrays.copyOfRange(nums, 0, nums.length-1));
		
		
        return Math.max(max1, max2);
//        return 13;
    }
	
	public int robSimple(int[] nums)
	{
		if(nums.length==0)
		{
			return 0;
		}
		if(nums.length==1)
		{
			return nums[0];
		}
		if(nums.length==2)
		{
		    return Math.max(nums[0],nums[1]);
		}
		int[] maxSelectSum=new int[nums.length];
		int[] maxNoneSelectSum=new int[nums.length];
		
		maxSelectSum[0]=nums[0];
		maxNoneSelectSum[0]=0;
		maxSelectSum[1]=nums[1];
		maxNoneSelectSum[1]=maxSelectSum[0];
		
		for (int i = 2; i < maxSelectSum.length; i++) {
			maxSelectSum[i] = maxNoneSelectSum[i - 1] + nums[i];

			int maxPrev = 0;
			for (int j = 0; j <= i - 1; j++) {
				if (maxSelectSum[j] > maxPrev) {
					maxPrev = maxSelectSum[j];
				}
			}
			maxNoneSelectSum[i] = maxPrev;
			// maxSelectSum[i-1];
		}
		
		return Math.max(maxSelectSum[nums.length-1], maxNoneSelectSum[nums.length-1]);
		
	}
}
