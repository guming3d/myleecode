package com.interview.sums3closet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, find three integers in S such that 
 * the sum is closest to a given number, target. Return the sum of the 
 * three integers. You may assume that each input would have exactly 
 * one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		threeSumClosest(new int[]{0,0,0},1);
	}
	 public static int threeSumClosest(int[] nums, int target) {
		 List<List<Integer>> result = new ArrayList<>();
	        
	        Arrays.sort(nums);
	        int i = 0;
	        int distance=(nums[0]+nums[1]+nums[2]>=target)?(nums[0]+nums[1]+nums[2]-target):target-(nums[0]+nums[1]+nums[2]);
	        boolean isOnLeft=(nums[0]+nums[1]+nums[2]>=target)?false:true;
	        while(i < nums.length - 2) {
	            if(nums[i] > target) break;
	            int j = i + 1;
	            int k = nums.length - 1;
	            while(j < k) {
	                int sum = nums[i] + nums[j] + nums[k];
	                if(sum == target) return sum;
	                if(sum <= target) {
	                	if(target-sum<distance)
	                	{
	                		distance=target-sum;
	                		isOnLeft=true;
	                	}
	                	while(nums[j] == nums[++j] && j < k);
	                		}
	                if(sum >= target) 
	                	{
	                	if(sum-target<distance)
	                	{
	                		distance=sum-target;
	                		isOnLeft=false;
	                	}
	                	while(nums[k--] == nums[k] && j < k);
	                	}
	            }
	            while(nums[i] == nums[++i] && i < nums.length - 2);
	        }
	        
	        return isOnLeft?target-distance:target+distance;
	    }
	 /**
	  * 首先查找目标target有没有，然后查找剩下来两个数字合为最小的那个组合
	  * @param nums
	  * @param target
	  * @return
	  */
	 public static int threeSumClosest2(int[] nums, int target) {
		 //first find the target is in the nums
		 Arrays.sort(nums);
		 if(Arrays.binarySearch(nums, target)>=0)
		 {
			 
		 }
		 //then found the left two number with smallest adding value
		return target;
	    }
}
