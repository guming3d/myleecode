package com.interview.combinationsum4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an integer array with all positive numbers and no duplicates, find the
 * number of possible combinations that add up to a positive integer target.
 * 
 * Example:
 * 
 * nums = [1, 2, 3] target = 4
 * 
 * The possible combination ways are: (1, 1, 1, 1) (1, 1, 2) (1, 2, 1) (1, 3)
 * (2, 1, 1) (2, 2) (3, 1)
 * 
 * Note that different sequences are counted as different combinations.
 * 
 * Therefore the output is 7.
 * 
 * Follow up: What if negative numbers are allowed in the given array? How does
 * it change the problem? What limitation we need to add to the question to
 * allow negative numbers?
 * 
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution mySolution = new Solution();
		mySolution.combinationSum4(new int[] { 1, 2, 3,4 }, 7);
		System.out.println("End");
	}

	//Time exceeded of leetcode!!! Need to find a better performance method
	public int combinationSum4(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> resultList = new ArrayList<>();
		if (target < nums[0]) {
			return 0;
		}
		for (int i = 0; i < nums.length; i++) {
			List<Integer> com = new ArrayList<>();
			combination(resultList,com,nums,target);
		}
		System.out.println(resultList.size());
		return resultList.size()/nums.length;
	}
	
	public void combination(List<List<Integer>> coms,List<Integer> com,int[] sources,int target)
	{
		if(sums(com)==target)
		{
			List<Integer> newCom=new ArrayList<>(com);
			coms.add(newCom);
			return;
		}else if(sums(com)>target)
		{
			return;
		}else{
			Set<Integer> prevSet=new HashSet<>();
			for (int i = 0; i < sources.length; i++) {
				if(prevSet.contains(sources[i]))
				{
					continue;
				}
				prevSet.add(sources[i]);
				com.add(sources[i]);
				combination(coms,com,sources,target);
				if(sums(com)>=target)
				{
					com.remove(com.size()-1);
					break;
				}else{
					com.remove(com.size()-1);
				}
				
			}
		}
	}
	
	public int sums(List<Integer> com)
	{
		int total=0;
		for (int i = 0; i < com.size(); i++) {
			total+=com.get(i);
		}
		return total;
	}

}
