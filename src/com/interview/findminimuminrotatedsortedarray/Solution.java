package com.interview.findminimuminrotatedsortedarray;

import java.util.Arrays;

/**
 * 153. Find Minimum in Rotated Sorted Array

    Total Accepted: 109085
    Total Submissions: 290185
    Difficulty: Medium

Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int findMin(int[] nums) {
		if(nums.length==1)
		{
			return nums[0];
		}
		if(nums.length==2)
		{
			return Math.min(nums[0], nums[1]);
		}
		//copy the nums to another array
		int[] sortedNums=new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			sortedNums[i]=nums[i];
		}
		//Sort the new Array
		Arrays.sort(sortedNums);
		
		
        return 0;
    }
	
	public int findMin3(int[] nums) {
		if(nums.length==1)
		{
			return nums[0];
		}
		if(nums.length==2)
		{
			return Math.min(nums[0], nums[1]);
		}
		
		int tmpSmallest=nums[0];
		for (int i = 0; i < nums.length-1; i++) {
			if(nums[i+1]>=nums[i])
			{
				continue;
			}else{
				return nums[i+1];
			}
		}
		if(nums[nums.length-1]>=nums[nums.length-1])
		{
			return tmpSmallest;
		}else{
			return nums[nums.length-1];
		}

    }
}
