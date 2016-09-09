package com.interview.jumpgame;

import java.sql.Time;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * For example: A = [2,3,1,1,4], return true.
 * 
 * A = [3,2,1,0,4], return false.
 * 
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution mySolution=new Solution();
		long startTime = System.currentTimeMillis();
		blockSet.clear();
//		System.out.println(mySolution.canJump3(new int[]{2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,5,8,0,7,9,3,4,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6},0));
		int[] testArray=new int[]{2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,5,8,0,7,9,3,4,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6};
		
		System.out.println(mySolution.canJump4(testArray,testArray.length-1));
//		System.out.println(mySolution.canJump2(new int[]{2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,5,8,0,7,9,3,4,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6}));
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(totalTime);
	}

	/**
	 * Take too much time exceeded
	 * @param nums
	 * @return
	 */
	public boolean canJump(int[] nums) {
		if (nums.length == 0) {
			return false;
		}
		if (nums.length == 1) {
			return true;
		}
		//If there is no zero in the array, return true
		boolean containsZero=false;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]==0)
			{
				containsZero=true;
				blockSet.add(i);
			}
		}
		if(containsZero==false)
		{
			return true;
		}
		
		if (nums[0] < nums.length) {
			for (int i = nums[0]; i >= 1; i--) {
				if (canJump(Arrays.copyOfRange(nums, i, nums.length))) {
					return true;
				}
			}
		} else {
			return true;
		}

		return false;
	}
	
	public boolean canJump2(int[] nums) {
		if (nums.length == 0) {
			return false;
		}
		if (nums.length == 1) {
			return true;
		}
		if (nums[0] < nums.length) {
			for (int i = nums[0]; i >= 1; i--) {
				if (canJump(Arrays.copyOfRange(nums, i, nums.length))) {
					return true;
				}
			}
		} else {
			return true;
		}

		return false;
	}

	static Set<Integer> blockSet=new HashSet<>();
	/**
	 * Still can not pass the testing, need another metod
	 * @param nums
	 * @param startIndex
	 * @return
	 */
	public boolean canJump3(int[] nums,int startIndex) {
		if(startIndex==nums.length-1)
		{
			return true;
		}
		
		
		
		if (startIndex + nums[startIndex] < nums.length -1) {
			if(nums[startIndex]==0)
			{
				blockSet.add(startIndex);
				return false;
			}else if(blockSet.contains(startIndex))
			{
				return false;
			}
			
			for (int i = startIndex+nums[startIndex]; i >= startIndex+1; i--) {
				if (canJump3(nums, i)) {
					return true;
				}
			}
		} else {
			return true;
		}
		blockSet.add(startIndex);
		return false;
	}
	
	/**
	 * Try using search from last one in the array back to front
	 * @param nums
	 * @param startIndex
	 * @return
	 */
	public boolean canJump4(int[] nums,int lastOne) {
		if(lastOne==0)
		{
			return true;
		}
		int lastIndex=lastOne-1;
		while(lastIndex>=0)
		{
			if(lastIndex+nums[lastIndex]>=lastOne)
			{
				return canJump4(nums, lastIndex);
			}else{
				lastIndex--;
			}
		}
		return false;
	}

	

}
