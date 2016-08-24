package com.interview.houserobber;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed, the only constraint stopping you 
 * from robbing each of them is that adjacent houses have security system connected and 
 * it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.
TODO
 * @author mcgu
 *
 */
@Deprecated
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] testNum={1,3,1};
		System.out.println(rob2(testNum));
	}
	/*
	 * 找最大的那个数，再在余下的列表里面找剩下最大的数，
	 * 如果剩下来最大的那个数和之前的最大数列表里面都不相邻，则可以加入
	 */
	public static int rob(int[] nums) {
		//special case
		if(nums.length==0)
		{
			return 0;
		}else if(nums.length==1)
		{
			return nums[0];
		}
		//if all the number is same value
		
		
		Map<Integer, Integer> ajacentMap=new HashMap<>();
		List<Integer> numList=new ArrayList<>();
		
		for (int i = 0; i < nums.length; i++) {
			ajacentMap.put(nums[i], i);	
		}
		
		for (int i = 0; i < nums.length; i++) {
			numList.add(nums[i]);
		}
		
		Collections.sort(numList);
		
		List<Integer> existingajacent=new ArrayList<>();
		int maxNumber=0;
		for(int i=numList.size()-1;i>=0;i--)
		{
			if(existingajacent.contains(numList.get(i)))
			{
				//Can not select this number, existing
				continue;
			}else
			{
				maxNumber+=numList.get(i);
				//find the ajacent number and add them into the existingajacent List
				int index=ajacentMap.get(numList.get(i));
				if(index==0)
				{
					existingajacent.add(nums[index+1]);
				}else if(index==nums.length-1)
				{
					existingajacent.add(nums[index-1]);
				}else
				{
					existingajacent.add(nums[index-1]);
					existingajacent.add(nums[index+1]);
				}
			}
			
		}
		
        return maxNumber;
    }
	
	public static int rob2(int[] nums) {
		if(nums.length==1)
		{
			return nums[0];
		}
		if(nums.length==0)
		{
			return 0;
		}
		if(nums.length==2)
		{
			return Math.max(nums[0],nums[1]);
		}
		int[] maxNumber=new int[nums.length];
		maxNumber[0]=nums[0];
		maxNumber[1]=Math.max(nums[1], nums[0]);
		for (int i = 2; i < nums.length; i++) {
			maxNumber[i]=Math.max(maxNumber[i-1], maxNumber[i-2]+nums[i]);
		}
		return Math.max(maxNumber[nums.length-2], maxNumber[nums.length-1]);
	}
	
	public int rob4(int[] nums) {
		int length = nums.length;
		if (nums == null || nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		if (nums.length == 2) {
			return nums[0] > nums[1] ? nums[0] : nums[1];
		}
		if (nums.length == 3) {
			return (nums[1] > (nums[0] + nums[2])) ? nums[1] : (nums[0] + nums[2]);
		}
		int[] max = new int[nums.length];
		max[0] = nums[0];
		max[1] = Integer.max(nums[0], nums[1]);
		for (int i = 2; i < nums.length; i++) {
			max[i] = ((nums[i] + max[i - 2]) > max[i - 1]) ? (nums[i] + max[i - 2]) : max[i - 1];
		}
		return max[nums.length - 1];
	}
}
